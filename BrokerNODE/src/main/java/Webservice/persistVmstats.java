package Webservice;

import Webservice.Politicas.Administrativas.PropAutomation;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;

@Component
public class persistVmstats extends vmStats {


    public static void main(String[] args) throws IOException, SQLException {


        new persistVmstats();

    }




    public static void persistVmstats() throws SQLException, IOException {

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
        }

    //    return 0;
       // return selectSQL;
    }


        private static Connection getConnection() throws SQLException, IOException {
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
