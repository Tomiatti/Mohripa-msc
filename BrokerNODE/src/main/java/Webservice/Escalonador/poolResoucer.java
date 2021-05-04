package Webservice.Escalonador;

import java.sql.*;
import java.util.HashMap;

public class poolResoucer {


    public static void main(String[] args) throws SQLException {

      System.out.println( getFreeVmsForHost("cos01") );


  //  getFreeVms();

    }


    public static String getFreeVmsForHost(String hostname ) throws SQLException {

        String genoma = "cos01";
        String operation="shutdown";
        String vmhost = "";

        String selectSQL = "Select * from Resources_tb WHERE  Hostname= ? and VM_Status= ?";
        //  HashMap <String, String> map = new HashMap <String, String>();
        Connection con = getConnection();

            PreparedStatement pst = con.prepareStatement(selectSQL);
            pst.setString(1, hostname);
            pst.setString(2,"shutdown");
            ResultSet rs = pst.executeQuery();
            //  System.out.println(rs);
            while (rs.next()) {
               // String host = rs.getString("Hostname");
                vmhost = rs.getString("VM_Host");
               // System.out.println(hostname);
              //  System.out.println(vmhost);
                
                ///map.put(hostname, vmhost);
                // System.out.println(map);
            }
            /* Executa o statement estruturado*/

        return vmhost;
    }

    public static String getFreeVms() throws SQLException {

        /*Escolha sem criterio nenhum */
        String vmhost = "";

        String selectSQL = "Select * from Resources_tb WHERE  VM_Status= ?";
        HashMap <String, String> map = new HashMap <String, String>();
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        pst.setString(1, "shutdown");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String hostname = rs.getString("Hostname");
            vmhost = rs.getString("VM_Host");
            map.put(hostname, vmhost);
            System.out.println(map);
        }

        return vmhost;
    }

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); /* Instancia o driver do jdbc*/
        } catch (Exception ex) {
            //  System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }
        String user = "root";
        String senha = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/ResourcesCluster";

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }


}
