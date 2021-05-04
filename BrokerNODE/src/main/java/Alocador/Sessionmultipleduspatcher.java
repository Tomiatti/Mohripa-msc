package Alocador;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sessionmultipleduspatcher {

    static Logger log = Logger.getLogger(new Object() {
    }.getClass().getEnclosingClass());

    public static void main(String[] args) {


        MapResource mr = new MapResource();
        SessionProperties sp = new SessionProperties();
        PropertiesManipulator pm = new PropertiesManipulator();
        ExecutorService executor = Executors.newCachedThreadPool();

        Iterator <Map.Entry <String, String>> it = mr.MapResource().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry <String, String> pair = ( Map.Entry <String, String> ) (( Iterator ) it).next();

            Runnable task = new Runnable() {
                public void run() {

                    try {
                        //Aqui vai ser o session
                        JSch jsch = new JSch();
                        // Session session = jsch.getSession( user, host );
                        //session.setPassword( pwd );

                        Session session = jsch.getSession(pm.getLogin(), pm.getHost());
                        session.setPassword(pm.getPassword());


                        session.setPort(Integer.parseInt(pair.getValue()));
                        session.setConfig(sp.SessionProperties());


                       // System.out.println("Establishing Connection...");
                        session.connect(3000);
                        //session1.getServerAliveCountMax();
                       // System.out.println("Connection established.");
                        //System.out.println( "The session 1 has been established to " + user + "@" + host );

                      //  System.out.println("The session 1 has been established to " + pm.getLogin() + "@" + pm.getHost());

                        //aqui acaba a session

                        //aqui se executa o comando
                        ChannelExec channelExec = ( ChannelExec ) session.openChannel("exec");

                        InputStream in = channelExec.getInputStream();

                        // channelExec.setCommand("virsh dominfo VM1-H5");
                        channelExec.setCommand("virsh list --all");
                        //  channelExec.setCommand( "apt-get update" );
                        channelExec.connect(30000);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        String line;
                        int index = 0;

                        while ((line = reader.readLine()) != null) {
                            //System.out.println(++index + " : " + line);
                            System.out.println(line);
                        }

                        //  log.info(InetAddress.getLocalHost().getHostName() + line);

                        channelExec.disconnect();
                        //aqui termina o comando
                        session.disconnect();
                        //   System.out.println( "Done!" );

                    } catch (Exception e) {
                        System.out.println("exception caught:" + e);
                        //System.out.println(e.getError());
                    }

                }
            };

            executor.submit(task);
        }

        executor.shutdown();

    }
}
