package Alocador;


import MonitorAPI.LogServer.GetClassname;
import MonitorAPI.LogServer.LogDatabase;
import MonitorAPI.LogServer.LoggerTimer;
import MonitorAPI.Wrapper.Wrapper;
import Webservice.Politicas.Administrativas.PropAutomation;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.*;

public class SessionDispatcher {

    public static Runnable SingleExecutorInternal(String Command, String ip, String vm) {
        ExecutorService executor = Executors.newCachedThreadPool();
       // ExecutorService executor = Executors.newWorkStealingPool();

        Runnable task = new SSHDispatcherInternal(Command, ip, vm);
        Future future = executor.submit(task);

        String result = null;
        try {
            result = ( String ) future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Task is submitted");
        while (!future.isDone()) {
            //  System.out.println("Tarefa não terminada ainda...");
        }
        System.out.println("Tarefa finalizada!" + vm + "ligada");

        // executor.shutdown();

        try {
            if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        return task;
    }


    public static Runnable SingleExecutorExternal(String Command, int port, String vm) throws IOException, SQLException {
      /*  GetClassname gcn = new GetClassname();
        LoggerTimer lg = new LoggerTimer();

        long start = lg.getStartClass(gcn.getNameClass());*/

        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task = new SSHDispatcherExternal(Command, port, vm);
        executor.submit(task);
        executor.shutdown();

       /* long end = lg.getEndClass(gcn.getNameClass());

        LogDatabase ld = new LogDatabase();
        ld.LogClassInsert(start, end, gcn.getNameClass());*/

        return task;
    }

/*    public static Runnable MultipleExecutor(String Command, int port, String [] vm){
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task = new SSHDispatcher( Command, port, vm  );
        executor.submit( task );
        executor.shutdown();

        return task;
    }
*/

    public static Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); /* Instancia o driver do jdbc*/
        } catch (Exception ex) {
            //  System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }

        String user = PropAutomation.getdblogin("ResourceMap");
        String senha = PropAutomation.getdbpassword("ResourceMap");
        String adress = PropAutomation.getdbAdress("ResourceMap");
        int port = Integer.parseInt(PropAutomation.getdbport("ResourceMap"));


        String url = "jdbc:mysql://" + adress + ":" + port + "/ResourcesCluster";
       // System.out.println(url);

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }


    public static String UpdateResource(String vm, String status) throws SQLException, IOException {


        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "UPDATE Resources_tb set VM_Status =? where VM_Host =?";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        //  pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(1, status);
        pst.setString(2, vm);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(pst);
    }


    public static void main(String[] args) throws IOException, SQLException {


        //String OperationStart = new MethodsOperationCall().startCall();

        String OperationStart = new MethodsOperationCall().shutdownCall();


        SingleExecutorExternal(OperationStart, 2010, "COS01-VM1");

        // UpdateResource("cos01-vm3", "shutdown");

    }

    static class SSHDispatcherExternal implements Runnable {
        String Comand;
        int pairport;
        String vm;

        public SSHDispatcherExternal(String Comand, int pairport, String vm) {
            this.Comand = Comand;
            this.pairport = pairport;
            this.vm = vm;
        }

        SessionProperties sp = new SessionProperties();
        PropertiesManipulator pm = new PropertiesManipulator();

        public void run() {

            try {


                JSch jsch = new JSch();
                Session session = jsch.getSession(pm.getLogin(), pm.getHost());
                session.setPassword(pm.getPassword());
                session.setPort(pairport);
                session.setConfig(sp.SessionProperties());

               // System.out.println("Establishing Connection...");
                session.connect(10000);
                //session1.getServerAliveCountMax();
              //  System.out.println("Connection established.");
             //   System.out.println("The session 1 has been established to " + pm.getLogin() + "@" + pm.getHost());
                /*aqui acaba a session*/


                System.out.println("The operation will be "+Comand+ " on the VM "+vm);

                new ComandChannel().CommandDispatcher(session, Comand, vm);
              //  UpdateResource( vm, Comand );


            } catch (Exception e) {
                System.out.println("exception caught:" + e);
                //System.out.println(e.getError());
            }

        }
    }


    static class SSHDispatcherInternal implements Runnable {
        String Comand;
        String ip;
        String vm;

        public SSHDispatcherInternal(String Comand, String ip, String vm) {
            this.Comand = Comand;
            this.ip = ip;
            this.vm = vm;
        }

        SessionProperties sp = new SessionProperties();
        PropertiesManipulator pm = new PropertiesManipulator();

        public void run() {

            try {
                JSch jsch = new JSch();
                Session session = jsch.getSession(pm.getLogin(), "10.1.1.50", 22);
                session.setPassword(pm.getPassword());
                // session.setPort(22);
                session.setConfig(sp.SessionProperties());

                System.out.println("Establishing Connection...");
                session.connect(3000);
                //session1.getServerAliveCountMax();
                System.out.println("Connection established.");
                System.out.println("The session 1 has been established to " + pm.getLogin() + "@" + "10.1.1.50");
                /*aqui acaba a session*/


                new ComandChannel().CommandDispatcher(session, Comand, vm);

                session.disconnect();
                System.out.println("Done!");


            } catch (Exception e) {
                System.out.println("exception caught:" + e);
                //System.out.println(e.getError());
            }

        }
    }


}


      /*  ExecutorService executor = Executors.newCachedThreadPool();
        MapResource mr = new MapResource();
        Iterator <Map.Entry <String, String>> iterator = mr.MapResource().entrySet().iterator();

        int[] portas = {2210,2220,2230,2240,2250,2260,2270  };
        for (int i = 0; i < portas.length; i++) {

            int pair = portas[i];
            Runnable worker = new SSHDispatcher("virsh list --all",pair);
            executor.execute(worker);
        }*/

  /* public static int multiexecutor(String Command, int[] port){


        for (int i = 0; i < port.length; i++) {
            ExecutorService executor = Executors.newCachedThreadPool();
            int portas = port[i];
            Runnable worker = new SSHDispatcher( Command, portas );
            executor.submit( worker );
            executor.shutdown();
        }
        return 0;
    }*/


                   /* //aqui se executa o comando
                    ChannelExec channelExec = ( ChannelExec ) session.openChannel( "exec" );

                    InputStream in = channelExec.getInputStream();

                    // channelExec.setCommand("virsh shutdown VM2-H2");
                    channelExec.setCommand( Comand );
                    channelExec.connect( 3000 );

                    BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );
                    String line;
                    int index = 0;

                    while ((line = reader.readLine()) != null) {
                        System.out.println( ++index + " : " + line );
                    }

                    channelExec.disconnect();
                    //aqui termina o comando




            /*    long startCommandAvulso = System.nanoTime();
                new ComandChannel().CommandAvulso(session, "ping " + vm + " -c 20 -W 20");
                long endCommandAvulso = System.nanoTime();

                session.disconnect();


                long end = System.nanoTime();

                long TookTime = (end - start) / 1000000;
                long TookTimeCommandDispatcher = (endCommandDispatcher - startCommandDispatcher) / 1000000;
                long TookTimeCommandAvulso = (endCommandAvulso - startCommandAvulso) / 1000000;

                System.out.print(vm+ "  levou "  + TookTime+ "  milisegundos para executar todas as operações ");
                System.out.println();
                System.out.print("  levou "  + TookTimeCommandDispatcher+ "  milisegundos para executar o CommandDispatcher ");
                System.out.println();
                System.out.print("  levou "  + TookTimeCommandAvulso+ "  milisegundos para executar o CommandAvulso ");
                System.out.println();*/

// System.out.println("Done!");


