package MonitorAPI.Tools.Ganglia;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GangliaCollector {

    public static String GangliaColletInsert() throws SQLException, IOException {

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO dstat_tb (InicialTime,FinalTime,TookTime,WhichClass,Whenhappen) VALUES(?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        //  pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/


        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
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
        String url = "jdbc:mysql://127.0.0.1:3306/monitortools";

        return DriverManager.getConnection(url, user, senha); /* Estabelece a conexão */
    }

    private static ResultSet ExecuteStatement(String Query) throws SQLException {
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
