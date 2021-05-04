package DecisionMaker;

import DecisionMaker.Filter.PredicateFilter;
import DecisionMaker.Resources.GetVM;
import MonitorAPI.LogServer.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import static DecisionMaker.Filter.PredicateFilter.*;
import static MonitorAPI.LogServer.LogDatabase.LogTimerdirectReponse;

@SuppressWarnings("SpringConfigurationProxyMethods")
@RestController
public class Controller {

    public Controller() throws IOException, SQLException {
    }

    @RequestMapping("/")
    public String index() {
        return "Congratulations this is Tomiatti GER";
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
                HashMap <String, Integer> hashVm = persistVmstats.getAvalibleVmWithoutHost(2);

                String VmList = String.valueOf(hashVm).replaceAll("}", "").replaceAll("\\{", "").replaceAll(" ", "").trim();
                /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

                String[] VMArray = VmList.split("=|,");
                /* lista de host sendo separada em 1 array*/
                System.out.println(VMArray[0]);

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
        LogTimerdirectReponse(Whenstart, InicialTime, FinalTime, "GER-alocate-hashRefresh","");

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
        LogTimerdirectReponse(Whenstart, InicialTime, FinalTime, "GER-alocate-listScheduling","");

        return vmfinal;
    }


    @GetMapping(value = "/getAvalibleVmWithoutHost/{service}")
    public @ResponseBody
    String GetAvalibleVmWithoutHost(@PathVariable("service") int service) throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();/**/

        HashMap <String, Integer> hashVm = persistVmstats.getAvalibleVmWithoutHost(service);

        String VmList = String.valueOf(hashVm).replaceAll("}", "").replaceAll("\\{", "").replaceAll(" ", "").trim();
        /* linha responsavel por obter a lista de hosts do algoritmo de seleção, com a adição de um tratamento via replaces */

      //  System.out.println(VmList);

       // String[] VMArray = VmList.split("=|,");
        /* lista de host sendo separada em 1 array*/
        //System.out.println(VMArray[0]);

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirectReponse(Whenstart, InicialTime, FinalTime, "GER-Mapping","");


        return VmList;
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
               //  host = new PredicateFilter().ListSchedulingCPU().get(0);
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
        LogTimerdirectReponse(Whenstart, InicialTime, FinalTime, "GER-alocate-listScheduling","");

        return vmfinal;
    }

  /*  @RequestMapping(value = "/addStats", method = RequestMethod.POST)
    public String submit(@ModelAttribute("vmstat") vmStats vmstats,
                         BindingResult result, ModelMap model) throws SQLException, IOException {
        //   Map<Long, String> vmstatsmap = new HashMap <Long, String>();

        if (result.hasErrors()) {
            return "error";
        }

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        // GROUP BY Hostname order by Whenhappen
        Connection con = ResourceListSelect.getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            vmstats.setHostname(rs.getString("Hostname"));
            vmstats.setID_calc(rs.getFloat("ID_calc"));
            vmstats.setID_cpu(rs.getFloat("ID_cpu"));
            vmstats.setID_mem(rs.getFloat("ID_mem"));
            vmstats.setWhenhappen(rs.getString("Whenhappen"));
        }

        model.addAttribute("Hostname", vmstats.getHostname());
        model.addAttribute("ID_calc", vmstats.getID_calc());
        model.addAttribute("ID_cpu", vmstats.getID_cpu());
        model.addAttribute("ID_mem", vmstats.getID_mem());
        model.addAttribute("Whenhappen", vmstats.getWhenhappen());

        //    vmstatsmap.put(vmstats.getHostname(), );

        return "StatsADD";
    }

   */


 /*   @Configuration
    @EnableAutoConfiguration
    @ComponentScan(basePackageClasses = {vmStats.class, PredicateFilter.class, persistVmstats.class, ResourceListSelect.class})
    public static class Config {


        @Bean
        public static String ReturnbestCPU() throws IOException, SQLException {

            String host = new PredicateFilter().GetResourcesFromBestCPU();
            return host;
        }

        @Bean
        public static String ReturnbestMEM() throws IOException, SQLException {
            String host = new PredicateFilter().GetResourcesFromBestMEM();
            return host;
        }

        @Bean
        public static String ReturnbestID() throws IOException, SQLException {

            String host = new PredicateFilter().GetResourcesFromBestID();
            return host;
        }


    }/**/



}
