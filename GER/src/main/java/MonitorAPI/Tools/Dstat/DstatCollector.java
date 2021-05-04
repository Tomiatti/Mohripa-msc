package MonitorAPI.Tools.Dstat;

import MonitorAPI.Wrapper.IndiceCalc;
import MonitorAPI.Wrapper.Wrapper;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DstatCollector {


    public static Runnable DstatColletInsert() throws SQLException, IOException {

        String Hostname = InetAddress.getLocalHost().getHostName();
        float i_desempenho = new IndiceCalc().IDcalculator(Wrapper.DstatRequest());
        String tool = "dstat";

        //  GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        //  String data = gd.getDatasql(); /* Salva a data em uma variavel data*/
        Date hora = new Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(hora.getTime());


        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO Monitor_tb (Hostname,ID_calc,tool,Whenhappen) VALUES(?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        //  pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/
        pst.setString(1, Hostname);
        pst.setFloat(2, i_desempenho);
        pst.setString(3, tool);
        pst.setTimestamp(4, timestamp);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return null;
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
        String url = "jdbc:mysql://127.0.0.1:3306/MonitorTools";

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }


    public static void main(String[] args) throws IOException, SQLException {
        DstatColletInsert();
    }

}
