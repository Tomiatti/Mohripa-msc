package Webservice.Politicas.Administrativas.ProducerConsumer;

import java.util.Stack;

import static java.lang.Thread.sleep;

public abstract class Queue implements java.util.Queue {

    public Stack <String> stack = new Stack <String>();
    private final Integer MAX_ITENS = 30;
    private Integer itens = 0;
    private boolean firstThousand = false;

    private synchronized boolean isFull() {
        if (stack.size() == MAX_ITENS) {
            if (!this.firstThousand) this.firstThousand = true;
            return true;
        } else {
            return false;
        }

    }

    public synchronized boolean isEmpty() {
        if (stack.isEmpty() == true ) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized String add(String vm)  {
        while (isFull()) {
            try {
                synchronized (this) {
                    wait();
                    sleep(1);
                    System.out.println(Thread.currentThread().getName() + " waiting");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            String pilhar = stack.push(vm);
            itens++;

            System.out.println(stack);
            //System.out.println(Thread.currentThread().getName()+ " produziu um valor. Total [" + stack + "] ");

            synchronized (this) {
                notifyAll();
            }
            return pilhar;

    }

    public synchronized String remove(Queue queue) {
        while (isEmpty()) {
            try {
                synchronized (this) {
                    wait();
                    System.out.println(Thread.currentThread().getName() + " waiting");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String despilhar = stack.pop();
     //   System.out.println(despilhar);
    //    System.out.println(Thread.currentThread().getName()+ " consumiu um valor. Total [" + stack + "]");


        synchronized (this) {
            notifyAll();
        }
        return despilhar;
    }

    public synchronized boolean isRemovable() {
        return this.firstThousand;
    }



}
