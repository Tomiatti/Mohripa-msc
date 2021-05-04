package Webservice.Politicas.Administrativas.ProducerConsumer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread {

    private String product;
    private Queue queue;

    public Producer() {
        this.queue = queue;
        this.product = product;
    }

    public void ProduceVM(String array, Queue queue) throws InterruptedException, ExecutionException, IOException, SQLException {
        //  sleep(1);
        String product = queue.add(array);
        // return product;
    }

}
  /*  public void run(String product) throws InterruptedException, ExecutionException, SQLException, IOException {
        while (true) {
            try {
                sleep(5000);
                ProduceVM(product);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProduceVM(product);
        }*/

// Queue queue = new Queue();
     /*
        HashMap map = new GetVM().getAvalibleVm(host);
        String mapToarray = String.valueOf(map).replaceAll("}", "").replaceAll("\\{", "");
        String[] arrayToProduct = mapToarray.split(",");

        for (int i = 0; i < arrayToProduct.length; i++) {
            queue.add(arrayToProduct[i]);
        }*/



 /*   public void getToArray(String host){

        HashMap map = null;
        try {
            map = new GetVM().getAvalibleVm("cos01");
        } catch (SQLException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String mapToarray = String.valueOf(map).replaceAll("}","").replaceAll("\\{","");
        String[] arrayToProduct = mapToarray.split(",");


    }

    public void run(String product) throws ExecutionException, InterruptedException, IOException, SQLException {
        while (true) {
            try {
                sleep(5000);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProduceVM(product);
        }
    }*/



