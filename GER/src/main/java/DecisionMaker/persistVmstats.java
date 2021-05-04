package DecisionMaker;

import DecisionMaker.Resources.vmStats;
import MonitorAPI.PropAutomation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

@Component
public class persistVmstats {


    public static void main(String[] args) throws IOException, SQLException {


    }

  /*  @Configuration
    @ComponentScan(basePackageClasses = vmStats.class)
    public class Config {
        @Bean
        public String getstats() throws IOException, SQLException {
            return persistVmstats();
        }
    }*/


    public static HashMap <String, Integer> getAvalibleVmWithoutHost(int operation) throws SQLException, IOException {

        String convertedOperation ="";

        if (operation == 1) {
            convertedOperation = "shutdown";
        }
        if (operation == 2) {
            convertedOperation = "start";
        }
        if (operation == 3) {
            convertedOperation = "stop";
        }
        if (operation == 4) {
            convertedOperation = "resume";
        }

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "select VM_Host,Serverport from Resources_tb where VM_Status = ? ";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        //  pst.setString(1, host); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(1, convertedOperation);
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


        return map;
    }

  /*  public static String persistVmstats() throws SQLException, IOException {

        String selectSQL = "SELECT Hostname,ID_calc,ID_cpu,ID_mem,whenhappen from Monitor_tb ;";
        // GROUP BY Hostname order by Whenhappen
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(selectSQL);
        ResultSet rs = pst.executeQuery();

        String host = "nul0";
        Float indice = null;
        String whenhappen = "nul0";
        while (rs.next()) {
            vmStats vmEncap = new vmStats();
            vmEncap.setHostname(rs.getString("Hostname"));
            vmEncap.setID_calc(rs.getFloat("ID_calc"));
            vmEncap.setID_cpu(rs.getFloat("ID_cpu"));
            vmEncap.setID_mem(rs.getFloat("ID_mem"));
            vmEncap.setWhenhappen(rs.getString("Whenhappen"));
        }
        return selectSQL;
    }*/


        private static Connection getConnection() throws SQLException, IOException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); /* Instancia o driver do jdbc*/
            } catch (Exception ex) {
                //  System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
                ex.printStackTrace();
            }
            String user =  PropAutomation.getdblogin("ResourceMap");
            String senha = PropAutomation.getdbpassword("ResourceMap");
            String adress =  PropAutomation.getdbAdress("ResourceMap");
            int port = Integer.parseInt(PropAutomation.getdbport("ResourceMap"));


            String url = "jdbc:mysql://"+adress+":"+port+"/ResourcesCluster";

            return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
        }


}
