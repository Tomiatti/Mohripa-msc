package DecisionMaker.Filter;

import DecisionMaker.Resources.vmStats;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import static DecisionMaker.Controller.Config.Returnvmifo;

public class PredicateFilter {


    public static void main(String[] args) throws IOException, SQLException {


        List <String> host =  ListSchedulingCPU();
        System.out.println(host.get(0));
      //  System.out.println(HashRefreshCPU());

    }

    public static List <String> HashRefreshCPU() throws IOException, SQLException {

        // esse metodo trata-se de um predicado definido na fonte
        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        Connection con = ResourceListSelect.getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        Map <String, Float> myMap = new HashMap <>();

        while (rs.next()) {
            myMap.put(rs.getString("Hostname"), rs.getFloat("ID_cpu"));
        }

        List <String> ListofCPU = new ArrayList();

        Map <String, Float> result = myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new));

        ListofCPU.add(String.valueOf(result.keySet()));

        return ListofCPU;
    }

    public static List <String> HashRefreshMEM() throws IOException, SQLException {

        // esse metodo trata-se de um predicado definido na fonte
        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        Connection con = ResourceListSelect.getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        Map <String, Float> myMap = new HashMap <>();

        while (rs.next()) {
            myMap.put(rs.getString("Hostname"), rs.getFloat("ID_mem"));

        }

        List <String> ListofMemory = new ArrayList();

        Map <String, Float> result = myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new));

        ListofMemory.add(String.valueOf(result.keySet()));

        return ListofMemory;
    }

    public static List <String> HashRefreshID() throws IOException, SQLException {
        // esse metodo trata-se de um predicado definido na fonte
        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        Connection con = ResourceListSelect.getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        Map <String, Float> myMap = new HashMap <>();

        while (rs.next()) {
            myMap.put(rs.getString("Hostname"), rs.getFloat("ID_calc"));

        }

        //String MinMEM = Collections.min(myMap.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();

        List <String> ListofID = new ArrayList();

        Map <String, Float> result = myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new));

        ListofID.add(String.valueOf(result.keySet()));

        return ListofID;
    }


    public static List <String> ListSchedulingCPU() throws IOException, SQLException {
        // esse metodo trata-se de um predicado definido na fonte
        // ResourceListSelect rlsg = new ResourceListSelect();
        // rlsg.getBestIndexObject();
        // vmStats vminfo = new vmStats();

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        Connection con = ResourceListSelect.getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        List <String> ListofCPU= new ArrayList <>();
        Map <String, Float> myMap = new HashMap <>();

        while (rs.next()) {
            myMap.put(rs.getString("Hostname"), rs.getFloat("ID_calc"));
        }

        Map <String, Float> result = myMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (newValue, oldValue) -> oldValue, LinkedHashMap::new));

        ListofCPU.add(String.valueOf(result.keySet()));

        return ListofCPU;
    }

    public static String ListSchedulingMEM() throws IOException, SQLException{
        // esse metodo trata-se de um predicado definido na fonte
        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();
        vmStats vminfo = new vmStats();


        ArrayList<String> lines = new ArrayList<String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_mem()));


        List<String> streamTratamento= lines.stream().distinct().filter(line -> (vminfo.getID_mem() < 0.50)).collect(Collectors.toList());;

        String host = streamTratamento.get(0);

        return host;
    }


    public static String ListSchedulingID() throws IOException, SQLException{
        // esse metodo trata-se de um predicado definido na fonte
        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();
        vmStats vminfo = new vmStats();

        ArrayList<String> lines = new ArrayList<String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_calc()));

        List<String> streamTratamento= lines.stream().distinct().filter(line -> (vminfo.getID_calc() < 0.50)).collect(Collectors.toList());;


        String host = streamTratamento.get(0);

        return host;
    }


    public static Predicate <String> SetFilter(String Predicate) {

        // esse metodo é para definir um predicado novo

        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();

        final vmStats vminfo = new vmStats();
        ArrayList <String> lines = new ArrayList <String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_calc()));


        java.util.function.Predicate <String> filtroPersonalizado = new Predicate <String>() {
            @Override
            public boolean test(String s) {
                //getBestIndexObject();
                // vmStats vminfo = new vmStats();
                return vminfo.getID_calc() < 0.8;
            }
        };//

        List <String> streamTratamentopredicate = lines.stream().distinct().filter(filtroPersonalizado).collect(Collectors.toList());
        //   System.out.println("filtro Predicate : " + streamTratamentopredicate);/**/

        return filtroPersonalizado;
    }/**/


    public static List <String> GetResources(String Filtro) {
        // esse metodo trata-se de um predicado definido na fonte

        ResourceListSelect rlsg = new ResourceListSelect();
        rlsg.getBestIndexObject();
        vmStats vminfo = new vmStats();


        ArrayList <String> lines = new ArrayList <String>();
        lines.add(vminfo.getHostname());
        lines.add(vminfo.getWhenhappen());
        lines.add(String.valueOf(vminfo.getID_calc()));
        lines.add(String.valueOf(vminfo.getID_cpu()));
        lines.add(String.valueOf(vminfo.getID_mem()));

        List <String> streamTratamento = lines.stream().distinct().filter(line -> vminfo.getID_calc() < 0.8).collect(Collectors.toList());
        ;

        Iterator it = streamTratamento.iterator();
        while (it.hasNext()) {
            //  streamTratamento = lines.stream().distinct().filter(line -> vminfo.getID_calc() < 0.8).collect(Collectors.toList());
            System.out.println(it.next());
        }

        return streamTratamento;
    }

}

/*List<String> Stream= info.stream().filter(line -> (vminfo.getID_cpu() > 0.3) ).collect(Collectors.toList());



        String hostname= "";
        // Map <String, Float> myMap = new HashMap <>();
        ArrayList<String> lines = new ArrayList<String>();
        while (rs.next()) {
            vminfo.setHostname( rs.getString("Hostname") );
            vminfo.setID_cpu (rs.getFloat("ID_cpu"));
            lines.add(vminfo.getHostname());
            // lines.add(vminfo.getWhenhappen());
            lines.add(String.valueOf(vminfo.getID_cpu()));
        }

        for (int i=0;i < lines.size();i++){
            System.out.println( lines.get(i) );
        }


        List<String> streamTratamento= lines.stream().filter(line -> (vminfo.getID_cpu() > 0.3) ).collect(Collectors.toList());
        List <String> Listofcpu = new ArrayList();
        //filter(line -> (vminfo.getID_cpu() < 0.80) ).
        Listofcpu.add(String.valueOf(streamTratamento));

        //return Listofcpu;*/