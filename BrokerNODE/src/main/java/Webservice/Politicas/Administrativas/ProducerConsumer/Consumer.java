package Webservice.Politicas.Administrativas.ProducerConsumer;


public class Consumer extends Thread {
    private String product;
    private Queue queue;

    public Consumer() {
        this.queue = queue;
    }

    public String ConsumeVM(Queue queue){

       String Result = queue.remove(queue);

       System.out.println("consume 1");
        return Result;
    }




  /*  public void run() {
        while (true) {
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.isRemovable())
                queue.remove();
        }
    }*/
}