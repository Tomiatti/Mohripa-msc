package Alocador;

import Webservice.Politicas.Administrativas.PropAutomation;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

public class GetVM {

    public static Connection getConnection() throws SQLException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); /* Instancia o driver do jdbc*/
        } catch (Exception ex) {
            //  System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }

       String user = PropAutomation.getdblogin("ResourceMap");
        String senha = PropAutomation.getdbpassword("ResourceMap");
        String adress = PropAutomation.getdbAdress("ResourceMap");
        int port = Integer.parseInt(PropAutomation.getdbport("ResourceMap"));
        String url = "jdbc:mysql://" + adress + ":" + port + "/ResourcesCluster";  /**/
        // System.out.println(url);

      /*    String user = "root";
        String senha = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/ResourcesCluster";/**/

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }


    public static String getAvalibleVm(String host) throws SQLException, IOException {


        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "select VM_Host,Serverport from Resources_tb where Hostname = ? AND VM_Status = ? OR VM_Status = ? ";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, host); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(2, "shutdown");
        pst.setString(3, "destroy");
        // System.out.print( preparedStatement );
        // pst.executeUpdate(); /* Executa o statement estruturado*/

        ResultSet query = pst.executeQuery();
        HashMap <String, Integer> map = new HashMap <String, Integer>();
        String vm_host = "";
        int Serverport = 0;
        while (query.next()) {
            vm_host = query.getString("VM_Host");
            Serverport = query.getInt("Serverport");
            map.put(vm_host,Serverport);
        }
        String value = String.valueOf(map.entrySet());

        return value;
    }


    public static String getAvalibleVmOnly(String host) throws SQLException, IOException {


        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "select VM_Host from Resources_tb where Hostname = ? AND VM_Status = ? OR VM_Status = ? ";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, host); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(2, "resume");
        pst.setString(3, "start");
        // System.out.print( preparedStatement );
        // pst.executeUpdate(); /* Executa o statement estruturado*/

        ResultSet query = pst.executeQuery();
        HashMap <String,String> map = new HashMap<>();
        String vm_host = "";
        while (query.next()) {
            vm_host = query.getString("VM_Host");
            map.put("vm_host",vm_host);
        }


        return String.valueOf(map.entrySet());
    }

    public static String getRunningVm(String host) throws SQLException, IOException {


        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "select VM_Host from Resources_tb where Hostname = ? AND VM_Status = ? limit 1";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, host); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(2, "running");

        // System.out.print( preparedStatement );
        // pst.executeUpdate(); /* Executa o statement estruturado*/

        ResultSet query = pst.executeQuery();
        String vm_host = "";
        while (query.next()) {
            vm_host = query.getString("VM_Host");
        }


        return vm_host;
    }

    public static int getPort(String host) throws IOException, SQLException {

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "select Serverport from Resources_tb where Hostname = ? limit 1";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, host); /* Instancia os atributos a serem salvos no banco*/

        // System.out.print( preparedStatement );
        // pst.executeUpdate(); /* Executa o statement estruturado*/

        ResultSet query = pst.executeQuery();
        String serverport = "";
        while (query.next()) {
            serverport = query.getString("Serverport");
        }
        return Integer.parseInt(serverport);
    }


    public static void main(String[] args) throws IOException, SQLException {


        System.out.println(getAvalibleVm("cos01"));
       // System.out.print(getPort("cos01"));
    }

}
