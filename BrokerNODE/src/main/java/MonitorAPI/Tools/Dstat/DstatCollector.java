package MonitorAPI.Tools.Dstat;

import MonitorAPI.LogServer.GetData;
import MonitorAPI.Wrapper.IndiceCalc;
import MonitorAPI.Wrapper.Wrapper;
import Webservice.Politicas.Administrativas.PropAutomation;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DstatCollector {


    public static String DstatColletInsert() throws SQLException, IOException {

        String Hostname = InetAddress.getLocalHost().getHostName();
        float i_desempenho = new IndiceCalc().IDcalculator(Wrapper.DstatRequest());
        String tool = "dstat";

        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String data = gd.getDatanow(); /* Salva a data em uma variavel data*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO Monitor_tb (Hostname,ID_calc,tool,Whenhappen) VALUES(?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        //  pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(1,Hostname);
        pst.setFloat(2,i_desempenho);
        pst.setString(3,tool);
        pst.setString(4,data);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
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


        String url = "jdbc:mysql://"+adress+":"+port+"/Monitortools";
        System.out.println(url);

      /*  String user = "root";
        String senha = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/monitortools";*/

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }

    private static ResultSet ExecuteStatement(String Query) throws SQLException, IOException {
        Connection con = getConnection();
        //System.out.println( "Database connection established" );
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(String.valueOf(Query));

        return rs;
    }


    public static void ShowResultSet() throws SQLException {

        String query1 = "show tables";

        try {
            ResultSet rs = ExecuteStatement(query1);

            while (rs.next()) {
                String result = rs.getString(1);
                System.out.println("Resultado: " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getDatanow() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        java.util.Date hora = new Date();
        String Hora = formatador.format(hora);
        // String.valueOf( LocalDateTime.now() );

        return Hora; /* Retorna a horario e data do exato momento que foi invocado*/
    }

}
