package Alocador;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecuredSessionDispatcher {



    public static Callable SecuredSingleExecutorExternal(String Command, int port, String vm) {

        ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Callable task = new SecuredSessionDispatcher.SecuredSSHDispatcherExternal(Command, port, vm);


        Future <Integer> future = executor.submit(task);
        //System.out.println("Task is submitted");
        while (!future.isDone()) {
            //  System.out.println("Tarefa não terminada ainda...");
        }
        //    System.out.println("Tarefa finalizada!");
     /*   long factorial = (long) future.get();
        System.out.println("Fatorial de 10 é: " + factorial);*/
        executor.shutdown();
        System.out.println();

        return task;
    }

    public static void main(String[] args) throws IOException {

        String OperationStart = new MethodsOperationCall().shutdownCall();

        //new MethodsOperationCall().startCall();

        SecuredSingleExecutorExternal(OperationStart, 2050, "COS05-VM3");
    }


    static class SecuredSSHDispatcherExternal implements Callable {
        String Comand;
        int pairport;
        String vm;

        public SecuredSSHDispatcherExternal(String Comand, int pairport, String vm) {
            this.Comand = Comand;
            this.pairport = pairport;
            this.vm = vm;
        }

        SessionProperties sp = new SessionProperties();
        PropertiesManipulator pm = new PropertiesManipulator();

        @Override
        public Object call() throws Exception {
            long output = 0;

            JSch jsch = new JSch();
            Session session = jsch.getSession(pm.getLogin(), pm.getHost());
            session.setPassword(pm.getPassword());
            session.setPort(pairport);
            session.setConfig(sp.SessionProperties());

            System.out.println("Establishing Connection...");
            session.connect(10000);
            //session1.getServerAliveCountMax();
            System.out.println("Connection established.");
            System.out.println("The session 1 has been established to " + pm.getLogin() + "@" + pm.getHost());
            /*aqui acaba a session*/


            new ComandChannel().CommandDispatcher(session, Comand, vm);

            session.disconnect();
            System.out.println("Done!");
            output = 1;
            return output;
        }

    }


    class SecuredSSHDispatcherInternal implements Callable {
        String Comand;
        String ip;
        String vm;

        public SecuredSSHDispatcherInternal(String Comand, String ip, String vm) {
            this.Comand = Comand;
            this.ip = ip;
            this.vm = vm;
        }

        SessionProperties sp = new SessionProperties();
        PropertiesManipulator pm = new PropertiesManipulator();

        @Override
        public Object call() throws Exception {
            long output = 0;
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
            output = 1;
            return output;
        }
    }

}
