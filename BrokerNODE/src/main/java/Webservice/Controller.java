package Webservice;

import Alocador.GetVM;
import Alocador.MethodsOperationCall;

import MonitorAPI.LogServer.*;
import static Alocador.SessionDispatcher.SingleExecutorExternal;
import static Alocador.SessionDispatcher.UpdateResource;
import static MonitorAPI.LogServer.LogDatabase.*;
import static Webservice.PredicateFilter.*;
import static Webservice.URLCatcher.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {


    @RequestMapping("/")
    public String index() {
        return "Congratulations this is Tomiatti broker";
    }

    /*
     *
     *
     *                                 Alocate
     *
     *
     * */

    @GetMapping(value = "/getVmfromAlocateHashRefresh/{service}")
    public @ResponseBody
    String GetAvaliableVMFromAlocateHashRefresh(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String vmfinal = "";
        List <String> hostlist;

        switch (service) {
            case 1:
                String hostlistCPU = String.valueOf(HashRefreshCPU()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoCPU = hostlistCPU.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectCPU = hostlistFiltradoCPU[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectCPU = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoCPU[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectCPU == "") {

                    vmselectCPU = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoCPU[2]));

                } else

                    vmfinal = vmselectCPU.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;

            case 2:

                String hostlistMEM = String.valueOf(HashRefreshMEM()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoMEM = hostlistMEM.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectMEM = hostlistFiltradoMEM[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectMEM = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoMEM[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectMEM == "") {

                    vmselectMEM = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoMEM[2]));

                } else

                    vmfinal = vmselectMEM.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;

            case 3:
                String hostlistID = String.valueOf(HashRefreshMEM()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoID = hostlistID.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectID = hostlistFiltradoID[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectID = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoID[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectID == "") {

                    vmselectID = String.valueOf(new GetVM().getAvalibleVm(hostlistFiltradoID[2]));

                } else

                    vmfinal = vmselectID.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;
        }

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-alocate-hashRefresh","");

        return vmfinal;
    }


    @GetMapping(value = "/getVmfromAlocateListScheduling/{service}")
    public @ResponseBody
    String GetAvaliableVMFromAlocateListScheduling(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String host = "";


        switch (service) {
            case 1:
                host = new PredicateFilter().ListSchedulingCPU().get(0);
                // host = Config.ReturnbestCPU();
                //  System.out.println(host);
                break;

            case 2:
                host = new PredicateFilter().ListSchedulingMEM();
                //host = Config.ReturnbestMEM();
                // System.out.println(host);
                break;

            case 3:
                host = new PredicateFilter().ListSchedulingID();
                //  host = Config.ReturnbestID();
                //   System.out.println(host);
                break;
        }

        String vmfinal = String.valueOf(new GetVM().getAvalibleVm(host));

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-alocate-listScheduling","");

        return vmfinal;
    }

    @RequestMapping("/RequestDirectExternalAlocate/{service}")
    public synchronized String RequestDirectExternalAlocate(@PathVariable("service") int service) throws IOException, SQLException {
        /*                    Request GER                                       */
        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();


        String Operation = "";

        if (service == 1) {
            Operation = new MethodsOperationCall().startCall(); //start
        }
        if (service == 2) {
            Operation = new MethodsOperationCall().shutdownCall(); //shutdown
        }
        if (service == 3) {
            Operation = new MethodsOperationCall().resumeCall(); //resume
        }
        if (service == 4) {
            Operation = new MethodsOperationCall().stopCall(); //pause
        }

        String vmfinal = new httpRequest().getAvalibleVmWithoutHost(service);
        //System.out.println(vmfinal);

        vmfinal.replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();

        //System.out.println(vmfinal);
        String[] arrayinfofinal = vmfinal.split("=|,");

        System.out.println(arrayinfofinal[0]);
        String vm = arrayinfofinal[0].replace("{", "");
        int port = Integer.parseInt(arrayinfofinal[1].replace("}", ""));

        System.out.println(vm);
        System.out.println(port);

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-External-GER-Alocate","");
        /*                    Request GER                                       */

        /*                    Alocator                                       */
        String WhenstartAlocator = GetData.getDatanow();
        long InicialTimeAlocator = lg.getStartTimer();

        UpdateResource(vm, Operation.replace("virsh ", ""));
        SingleExecutorExternal(Operation, port, vm);


        long FinalTimeAlocator = lg.getEndTimer();
        LogTimerdirectalocator(WhenstartAlocator, InicialTimeAlocator, FinalTimeAlocator, "Broker-Alocator","");
        /*                    Alocator                                       */


        /*                    Transportador                                       */
        String Whenstarttransporter = GetData.getDatanow();
        long InicialTimetransporter = lg.getStartTimer();

      //  String linkagreggation = vmAcessVM(vm,port);
      //  System.out.println(linkagreggation);

        String linkagreggation = new httpRequest().GetAvalibleVMfromAlocateExternal(service);

        long FinalTimetransporter = lg.getEndTimer();
        LogTimerdirectTransportador(Whenstarttransporter, InicialTimetransporter, FinalTimetransporter, "Broker-Transporter-Service","");
        /*                    Transportador                                       */

      //  return "Melhor Vm possivel para o serviço " + service + " " + linkagreggation;
        return linkagreggation;
    }


    @RequestMapping("/RequestDirectInternalAlocate/{service}")
    public synchronized String RequestDirectInternalAlocate(@PathVariable("service") int service) throws IOException, SQLException {
        /*                    Request GER                                       */
        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String Operation = new MethodsOperationCall().startCall();
        String vmfinal = new httpRequest().GetAvalibleVMfromAlocateInternal(service);

        vmfinal.replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
        System.out.println(vmfinal);

        String[] arrayinfofinal = vmfinal.split("=|,");

        String vm = arrayinfofinal[0].replace("{", "");
        System.out.println(vm);
        int port = Integer.parseInt(arrayinfofinal[1].replace("}", ""));
        System.out.println(port);

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-Internal-alocate","");
        /*                    Request GER                                       */




        /*                    Alocator                                       */
        String WhenstartAlocator = GetData.getDatanow();
        long InicialTimeAlocator = lg.getStartTimer();

        SingleExecutorExternal(Operation, port, vm);
        UpdateResource(vm, Operation.replace("virsh", ""));

        long FinalTimeAlocator = lg.getEndTimer();
        LogTimerdirectalocator(WhenstartAlocator, InicialTimeAlocator, FinalTimeAlocator, "Alocator","");
        /*                    Alocator                                       */


        /*                    Transportador                                       */
        String Whenstarttransporter = GetData.getDatanow();
        long InicialTimetransporter = lg.getStartTimer();

        String linkagreggation = vmAcessVM(vm,port);
        System.out.println(linkagreggation);

        long FinalTimetransporter = lg.getEndTimer();
        LogTimerdirectRequest(Whenstarttransporter, InicialTimetransporter, FinalTimetransporter, "Broker-Transporter-Service","");
        /*                    Transportador                                       */


        return "Melhor Vm possivel para o serviço " + service + " " + linkagreggation;
    }

    /*
     *
     *
     *                                 SERVICE
     *
     *
     * */

    @GetMapping(value = "/getVmfromServiceHashrefresh/{service}")
    public @ResponseBody
    String GetAvaliableVMFromServiceHashRefresh(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String vmfinal = "";
        List <String> Hostlist;

        switch (service) {
            case 1:
                String hostlistCPU = String.valueOf(HashRefreshCPU()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoCPU = hostlistCPU.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectCPU = hostlistFiltradoCPU[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectCPU = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoCPU[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectCPU == "") {

                    vmselectCPU = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoCPU[2]));

                } else

                    vmfinal = vmselectCPU.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;

            case 2:

                String hostlistMEM = String.valueOf(HashRefreshMEM()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoMEM = hostlistMEM.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectMEM = hostlistFiltradoMEM[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectMEM = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoMEM[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectMEM == "") {

                    vmselectMEM = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoMEM[2]));

                } else

                    vmfinal = vmselectMEM.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;

            case 3:
                String hostlistID = String.valueOf(HashRefreshID()).replaceAll("]", "").replaceAll("\\[", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] hostlistFiltradoID = hostlistID.split("=|,");
                /* lista de host sendo separada em 1 array*/

                String hostselectID = hostlistFiltradoID[0];
                /* seleciona primeiro valor do array para executar a busca por vm disponivel para aquele host*/


                String vmselectID = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoID[0]));
                // String vmselect = String.valueOf(new GetVM().getAvalibleVmOnly(hostselect));
                /* seleciona vm disponivel para aquele host*/

                if (vmselectID == "") {

                    vmselectID = String.valueOf(new GetVM().getAvalibleVmOnly(hostlistFiltradoID[2]));

                } else

                    vmfinal = vmselectID.replace("vm_host=", "").replaceAll("]", "").replaceAll("\\[", "");
                /* realiza tratamento da string da vm disponivel*/

                break;
        }

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectReponse(Whenstart, InicialTime, FinalTime, "GER-Service-Hashrefresh","");

        return vmfinal;
    }


    @GetMapping(value = "/getVmfromServiceListScheduling/{service}")
    public @ResponseBody
    String GetAvaliableVMFromServiceListScheduling(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String host = "";

        switch (service) {
            case 1:
                // host = new PredicateFilter().ListSchedulingCPU();
                // host = Config.ReturnbestCPU();
                //  System.out.println(host);
                break;

            case 2:
                host = new PredicateFilter().ListSchedulingMEM();
                //host = Config.ReturnbestMEM();
                // System.out.println(host);
                break;

            case 3:
                host = new PredicateFilter().ListSchedulingID();
                //  host = Config.ReturnbestID();
                //   System.out.println(host);
                break;
        }

        String vmfinal = String.valueOf(new GetVM().getAvalibleVmOnly(host));

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-alocate-listScheduling","");

        return vmfinal;
    }

    @RequestMapping("/RequestDirectExternalService/{service}")
    public synchronized String RequestDirectExternalService(@PathVariable("service") int service) throws IOException, SQLException {
        /*                    Request GER                                       */
        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String vmfinal = new httpRequest().GetAvalibleVMfromServiceExternal(service);

        // System.out.println(vmfinal);

        String[] arrayinfofinal = vmfinal.split("=|,");

        String vm = arrayinfofinal[0].replace("{", "");

        //System.out.println(vm);
        //int port = Integer.parseInt(arrayinfofinal[1].replace("}", ""));

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-External-GER-Service","");
        /*                    Request GER                                       */


        /*                    Transportador                                       */
        String Whenstarttransporter = GetData.getDatanow();
        long InicialTimetransporter = lg.getStartTimer();

        //   int portToService = GetPortToService(vmfinal);
        //    System.out.println(portToService); /* realiza a agregação de link para retornar para o cliente*/

        String linkagreggation = new httpRequest().clusterload(service);

        long FinalTimetransporter = lg.getEndTimer();
        LogTimerdirectTransportador(Whenstarttransporter, InicialTimetransporter, FinalTimetransporter, "Broker-Transporter-Service","");
        /*                    Transportador                                       */



        //return "http://andromeda.lasdpc.icmc.usp.br:"+portToService+"/"+service;
        return linkagreggation;
    }


    @RequestMapping("/RequestDirectInternalService/{service}")
    public synchronized String RequestDirectInternalService(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        String vmfinal = new httpRequest().GetAvalibleVMfromServiceInternal(service);

        /* System.out.println(vmfinal);
        String[] arrayinfofinal = vmfinal.split("=|,");
        String vm = arrayinfofinal[0].replace("{", "");
        int port = Integer.parseInt(arrayinfofinal[1].replace("}", ""));
        String Link = VMLinkService(vmfinal,service); */

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectRequest(Whenstart, InicialTime, FinalTime, "Broker-internal-service","");


        /*                    Transportador                                       */
        String Whenstarttransporter = GetData.getDatanow();
        long InicialTimetransporter = lg.getStartTimer();

     //   int portToService = GetPortToService(vmfinal);
    //    System.out.println(portToService); /* realiza a agregação de link para retornar para o cliente*/

        String linkagreggation = new httpRequest().GetAvalibleVMfromAlocateExternal(service);

        long FinalTimetransporter = lg.getEndTimer();
        LogTimerdirectRequest(Whenstarttransporter, InicialTimetransporter, FinalTimetransporter, "Broker-Transporter-Service","");
        /*                    Transportador                                       */



        //return "http://andromeda.lasdpc.icmc.usp.br:"+portToService+"/"+service;
        return linkagreggation;
    }


    /*  @RequestMapping(value = "/RequestServiceStack/{service}", method = RequestMethod.GET)
      public String RequestService(@PathVariable("service") int service) throws IOException, SQLException, ExecutionException, InterruptedException {
          Producer pd = new Producer();

          Queue queue = null;

          String host = new httpRequest().GetAvaliblehost(service);

          List <String> list = new ArrayList <String>();
          list.add(host);

          for (int i = 0; i < list.size(); i++) {

              try {
                  List <String> map = new ArrayList <String>();
                  map.add(String.valueOf(new GetVM().getAvalibleVm(list.get(i))));
                  String mapToarray = String.valueOf(map).replaceAll("}", "").replaceAll("\\{", "");
                  String[] arrayToProduct = mapToarray.split(",");

                  for (int j = 0; j < arrayToProduct.length; j++) {
                      System.out.println(arrayToProduct[j]);
                      pd.ProduceVM(arrayToProduct[i], queue);
                  }

              } catch (SQLException | IOException | InterruptedException | ExecutionException e) {
                  e.printStackTrace();
              }

          }

     if (queue.isEmpty() == true) {
              for (int i = 0; i < arrayToProduct.length; i++) {
                  pd.ProduceVM(arrayToProduct[i], queue);
              }   }

        String Operation = new MethodsOperationCall().startCall();

        Consumer cs = new Consumer();
        String Removed = cs.ConsumeVM(queue);
        System.out.println("this is what i remove" + Removed);
        String[] arrayinfofinal = Removed.split("=");

        String vm = arrayinfofinal[0];
        String port = String.valueOf(arrayinfofinal[1]);

        SingleExecutorExternal(Operation, Integer.parseInt(port), vm);
        //   UpdateResource(vm, Operation.replace("virsh", ""));

        return String.valueOf(GetPortToService(vm));
    }  */

 /*   @RequestMapping(value = "/StartExecutor/{port}/{vm}", method = RequestMethod.GET)
    public String SingleExecutorStart(@PathVariable("port") int port, @PathVariable("vm") String vm) throws IOException, SQLException {

        String Operation = new MethodsOperationCall().startCall();

        SingleExecutorExternal(Operation, port, vm);

        return "URL parameters " + " Port = " + port + " VM = " + vm;
    }

    /*localhost:8080/ShutdownExecutor/2010/COS01-VM3*/

  /*  @RequestMapping(value = "/ShutdownExecutor/{port}/{vm}", method = RequestMethod.GET)
    public String SingleExecutorShutdown(@PathVariable("port") int port, @PathVariable("vm") String vm) throws IOException, SQLException {

        String Operation = new MethodsOperationCall().shutdownCall();

        SingleExecutorExternal(Operation, port, vm);


        return "URL parameters " + " Port = " + port + " VM = " + vm;
        //  return "execute executor";
    }

    /*localhost:8080/DestroyExecutor/2010/COS01-VM3*/

  /*  @RequestMapping(value = "/DestroyExecutor/{port}/{vm}", method = RequestMethod.GET)
    public String SingleExecutorDestroy(@PathVariable("port") int port, @PathVariable("vm") String vm) throws IOException, SQLException {

        String Operation = new MethodsOperationCall().destroyCall();

        SingleExecutorExternal(Operation, port, vm);


        return "URL parameters " + " Port = " + port + " VM = " + vm;
        //  return "execute executor";
    }

    /*localhost:8080/StopExecutor/2010/COS01-VM3*/

 /*   @RequestMapping(value = "/StopExecutor/{port}/{vm}", method = RequestMethod.GET)
    public String SingleExecutorStop(@PathVariable("port") int port, @PathVariable("vm") String vm) throws IOException, SQLException {

        String Operation = new MethodsOperationCall().stopCall();

        SingleExecutorExternal(Operation, port, vm);


        return "URL parameters " + " Port = " + port + " VM = " + vm;
        //  return "execute executor";
    }

    /*localhost:8080/ResumeExecutor/2010/COS01-VM3*/

    /*   @RequestMapping(value = "/ResumeExecutor/{port}/{vm}", method = RequestMethod.GET)
       public String SingleExecutorResume(@PathVariable("port") int port, @PathVariable("vm") String vm) throws IOException, SQLException {

           String Operation = new MethodsOperationCall().resumeCall();

           SingleExecutorExternal(Operation, port, vm);


           return "URL parameters " + " Port = " + port + " VM = " + vm;
           //  return "execute executor";
       }


     */

}
