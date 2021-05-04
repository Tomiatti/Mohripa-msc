package DecisionMaker.Filter;

import DecisionMaker.Resources.vmStats;
import MonitorAPI.PropAutomation;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResourceListSelect {

    public static Predicate<String> SetFilter(String Predicate){

        // esse metodo é para definir um predicado novo

        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();

        final vmStats vminfo = new vmStats();
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_calc()));


       Predicate<String> filtroPersonalizado = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //getBestIndexObject();
               // vmStats vminfo = new vmStats();
                return vminfo.getID_calc() < 0.8;
            }
        };//

       List<String> streamTratamentopredicate = lines.stream().distinct().filter(filtroPersonalizado).collect(Collectors.toList());
    //   System.out.println("filtro Predicate : " + streamTratamentopredicate);/**/

        return filtroPersonalizado;    }/**/




    public static List<String> GetResources (String Filtro ){
        // esse metodo trata-se de um predicado definido na fonte

        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();
        vmStats vminfo = new vmStats();


        ArrayList<String> lines = new ArrayList<String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_calc()));
        lines.add(String.valueOf(vminfo.getID_cpu()));
        lines.add(String.valueOf(vminfo.getID_mem()));

        List<String> streamTratamento= lines.stream().distinct().filter(line -> vminfo.getID_calc() < 0.8).collect(Collectors.toList());;

        Iterator it = streamTratamento.iterator();
        while (it.hasNext()) {
           //  streamTratamento = lines.stream().distinct().filter(line -> vminfo.getID_calc() < 0.8).collect(Collectors.toList());
            System.out.println(it.next());
        }

        return  streamTratamento;
    }

    public static void main(String[] args) {


       GetResources(null);


     //  System.out.println( SetFilter(null) );











    /*   ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();
        vmStats vminfo = new vmStats();


        ArrayList<String> lines = new ArrayList<String>();
        lines.add(vmStats.Hostname);
        lines.add(vmStats.Whenhappen);
        lines.add(String.valueOf(vmStats.ID_calc));

        List<String> streamTratamento = lines.stream().distinct().filter(line -> vminfo.getID_calc() < 0.8).collect(Collectors.toList());

        System.out.println("filtro : " + streamTratamento);//*/



      /*  Predicate<String> filtroPersonalizado = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                getBestIndexObject();
                vmStats vminfo = new vmStats();
                return vminfo.getID_calc() < 0.8;
            }
        };//

        List<String> streamTratamentopredicate = lines.stream().distinct().filter(filtroPersonalizado).collect(Collectors.toList());
        System.out.println("filtro Predicate : " + streamTratamentopredicate);//*/




     /*   List<info> filtro = vminfos.stream().filter(vminfos -> { return vminfo.getHostname().equals("") &&
                            vminfo.getID_calc() == 3 &&
                            vminfo.getWhenhappen().equals("");
                }).collect(Collectors.toList()); /**/

        //System.out.println(vminfoFiltrada);


    }





    public static void getBestIndexObject() {
        try {
            String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
            // GROUP BY Hostname order by Whenhappen
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(selectSQL);
            ResultSet rs = pst.executeQuery();

        /*String host = "nul0";
        Float indice = null;
        String whenhappen = "nul0";*/
            while (rs.next()) {

                vmStats vmEncap = new vmStats();
                vmEncap.setHostname(rs.getString("Hostname"));
                vmEncap.setID_calc(rs.getFloat("ID_calc"));
                vmEncap.setID_cpu(rs.getFloat("ID_cpu"));
                vmEncap.setID_mem(rs.getFloat("ID_mem"));
                vmEncap.setWhenhappen(rs.getString("Whenhappen"));
                // System.out.println(vmEncap.getHostname());



         /*   host = rs.getString("Hostname");
            indice = rs.getFloat("ID_calc");
            whenhappen = rs.getString("Whenhappen");

            vmStats vmEncap = new vmStats();
            vmEncap.setHostname(host);
            vmEncap.setID_calc(indice);
            vmEncap.setWhenhappen(whenhappen);*/
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static ArrayList<String> getBestIndex() throws SQLException, IOException {

        String selectSQL = "SELECT Hostname,ID_calc,whenhappen from Monitor_tb ;";
        // GROUP BY Hostname order by Whenhappen
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);


        ResultSet rs = pst.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<String> vmhost = new ArrayList<String>(columnCount);


        //  System.out.println(rs);
        while (rs.next()) {
            int i = 1;

            while (i <= columnCount) {
                vmhost.add(rs.getString(i++));
            }
        }
        /* Executa o statement estruturado*/
        return vmhost;
    }


    public static Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); /* Instancia o driver do jdbc*/
        } catch (Exception ex) {
            //  System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }
        String user =  PropAutomation.getdblogin("monitorAPI");
        String senha = PropAutomation.getdbpassword("monitorAPI");
        String adress =  PropAutomation.getdbAdress("monitorAPI");
        int port = Integer.parseInt(PropAutomation.getdbport("monitorAPI"));


        String url = "jdbc:mysql://"+adress+":"+port+"/MonitorTools";

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }




}
