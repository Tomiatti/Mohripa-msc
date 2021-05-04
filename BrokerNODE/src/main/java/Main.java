import Alocador.GetVM;
import Alocador.MethodsOperationCall;
import Webservice.Politicas.Administrativas.ProducerConsumer.Consumer;
import Webservice.Politicas.Administrativas.ProducerConsumer.Producer;
import Webservice.Politicas.Administrativas.ProducerConsumer.Queue;

import java.util.HashMap;

import static Alocador.SessionDispatcher.SingleExecutorExternal;
import static Webservice.URLCatcher.*;

public class Main {

    public static void main(String[] args) throws Exception {


    }
}

  /*      Producer pd = new Producer();
        Consumer cs = new Consumer();
        String host = "hal01";

     //  List <String> ReceivedInfoGer = new servidorTCP().runServer();


        Queue queue = new Queue();
        HashMap map = new GetVM().getAvalibleVm(host);
        String mapToarray = String.valueOf(map).replaceAll("}", "").replaceAll("\\{", "");
        String[] arrayToProduct = mapToarray.split(",");


          /*System.out.print(arrayToProduct[0]);
            System.out.print(arrayToProduct[1]);
            System.out.print(arrayToProduct[2]);
            System.out.print(arrayToProduct[3]);
            System.out.print(queue.remove());*/


     /*   if (queue.isEmpty() == true) {
            for (int i = 0; i < arrayToProduct.length; i++) {
                pd.ProduceVM(arrayToProduct[i], queue);
            }
        }
      String Removed = cs.ConsumeVM(queue);
        System.out.println("this is what i remove" + Removed );

       // System.out.println("this is what i remove" + Removed );
        String[] arrayInfoVm = Removed.split("=");

        String vm = arrayInfoVm[0];
        String port = String.valueOf( arrayInfoVm[1]);

        String Operation = new MethodsOperationCall().startCall();

        // GetVM.getAvalibleVm(host);

        // int port = GetVM.getPort(host);

      SingleExecutorExternal(Operation, Integer.parseInt(port), vm);
        SingleExecutorExternal(Operation, Integer.parseInt(port), vm);
        SingleExecutorExternal(Operation, Integer.parseInt(port), vm);
        SingleExecutorExternal(Operation, Integer.parseInt(port), vm);

       System.out.println(vmProp(vm,1));


    }

}

// queue.remove(queue);

//System.out.println("pilha sem recurso");

// String removida=


      /*  HashMap map = new GetVM().getAvalibleVm("cos01");
        String mapToarray = String.valueOf(map).replaceAll("}", "").replaceAll("\\{", "");
        String[] arrayToProduct = mapToarray.split(",");

        //  pd.run(arrayToProduct[0]);
        for (int i = 0; i < arrayToProduct.length; i++) {
            pd.ProduceVM(arrayToProduct[i]);
        }*/




    /*    while (!queue.isEmpty()) {
            for (int i = 0; i < MAX_CONSUMER; i++) {
                Consumer c = new Consumer(queue, "Consumer " + i);
                 c.run();
            }
        }*/

//    pd.ProduceVM(arrayToProduct[2]);
//     pd.ProduceVM(arrayToProduct[1]);
//    pd.ProduceVM(arrayToProduct[3]);


//pd.start();

//
      /*  System.out.println(arrayToProduct[0]);
        System.out.println(arrayToProduct[1]);
        System.out.println(arrayToProduct[2]);
        System.out.println(arrayToProduct[3]);/**/


//for(int i = 0; i < arrayToProduct.length; i++) { }


//    queue.add(arrayToProduct[i]);


//     int i = 0;
//     while(arrayToProduct.length < i){


//      queue.add(arrayToProduct[i]);
//        i++;
//    }


//   queue.add(new GetVM().getAvalibleVm("cos01"));

//    queue.remove();
//   queue.remove();
//  queue.remove();
//  queue.remove();


//     new servidorTCP().runServer();
//  SpringApplication.run(MainApplication.class, args);

//  String Operation = new MethodsOperationCall().startCall();

//  String vm = GetVM.getAvalibleVm("cos19");
//  String vm = GetVM.getRunningVm("cos03");

//       System.out.println(Operation);

//       System.out.println(vm);

//       int port = GetVM.getPort("cos19");

//        System.out.println(port);

//      SingleExecutorExternal(Operation, port, vm);
        /**/

