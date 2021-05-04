import DecisionMaker.persistVmstats;
import MonitorAPI.PropAutomation;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
/*
    public static void main(String[] args) {

        boolean reachable = false;
        try {

            // String host = "127.0.0.1";
            String host = PropAutomation.getdbAdress("ResourceMap");
            InetAddress address = InetAddress.getByName(host);

            // String address = PropAutomation.getdbAdress("ResourceMap");
            int port = Integer.parseInt(PropAutomation.getdbport("ResourceMap"));


            boolean DBonline = isDatabaseOnline(address, 3306);

            reachable = address.isReachable(3000);


            while (reachable && DBonline == true) {


                ExecutorService executor = Executors.newCachedThreadPool();
                while (true) {
                   // new clienteTCP().run();
                  //  new persistVmstats().persistVmstats();
                    Thread.sleep(30000);
                }
            }
        } catch (IOException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }


    }*/

    public static boolean isDatabaseOnline(InetAddress address, int port) throws IOException {
        boolean result;

        try {
            Socket socket = new Socket(address, port);
            socket.close();

            result = true;
        } catch (IOException e) {
            result = false;
        }

        return result;
    }


}
