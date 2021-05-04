package DecisionMaker.SocketSend;

import DecisionMaker.SocketSend.TCP.clienteTCP;
import DecisionMaker.SocketSend.UDP.clienteUDP;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class socketSender {

    public static class executorMonitor implements Runnable {
        public void run() {

            try {

                //   String service = "TCP";
                String service = "UDP";

                if(service =="TCP")

                {
                    new clienteTCP().run();


                }

                if(service =="UDP")

                {
                    new clienteUDP().runClient();


                }

            } catch (
                    Exception e) {
                System.out.println("exception caught:" + e);
            }
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        while (true) {
            executor.submit(new executorMonitor());
            Thread.sleep(10000);
        }

        //DstatColletInsert();
    }




}

