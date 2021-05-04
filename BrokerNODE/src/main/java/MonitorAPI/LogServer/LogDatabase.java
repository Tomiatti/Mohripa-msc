package MonitorAPI.LogServer;

import Webservice.Politicas.Administrativas.PropAutomation;

import java.io.IOException;
import java.sql.*;

public class LogDatabase {


    public static void main(String[] args) throws IOException, SQLException {

        int contadoida= (1600000*48)/2;
        System.out.println(contadoida);


        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer() ;/**/



        int conta= (16000*48)/2;
        System.out.println(conta);




        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        LogTimerdirect(Whenstart,  InicialTime,  FinalTime, "Broker-listScheduling");


    }

    public static String LogClassInsert(long start, long end, String classname) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String data = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTimerClass(start, end, classname); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO TimerClass_tb (InicialTime,FinalTime,TookTime,WhichClass,Whenhappen) VALUES(?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, end);
        pst.setLong(3, TookTime);
        pst.setString(4, classname);
        pst.setString(5, data);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogMethodInsert(long start, long end, String classname, String method) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String data = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator();  /* Instancia classe que calcula o tempo levado da execução de certo metodo*/
        long TookTime = tc.GetTimerMethod(start, end, method); /* Passa tempos de inicio e fim da execução de certo metodo*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO TimerMethod_tb (InicialTime,FinalTime,TookTime,WhichClass,Whenhappen, WhichMethod) VALUES(?,?,?,?,?,?)"; /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setLong(1, start); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, end);
        pst.setLong(3, TookTime);
        pst.setString(4, classname);
        pst.setString(5, data);
        pst.setString(6, method);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogTimerdirect(String Whenstart, long InicialTime, long FinalTime, String WhichModule) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogTimer_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime) VALUES(?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogTimerdirectApp(String Whenstart, long InicialTime, long FinalTime, String WhichModule,String Description) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogApp_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime,Description) VALUES(?,?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);
        pst.setString(7, "");

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogTimerdirectRequest(String Whenstart, long InicialTime, long FinalTime, String WhichModule,String Description) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogRequest_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime,Description) VALUES(?,?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);
        pst.setString(7, "");

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }


    public static String LogTimerdirectReponse(String Whenstart, long InicialTime, long FinalTime, String WhichModule,String Description) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogResponse_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime,Description) VALUES(?,?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);
        pst.setString(7, "");

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogTimerdirectalocator(String Whenstart, long InicialTime, long FinalTime, String WhichModule,String Description) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogAlocator_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime,Description) VALUES(?,?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);
        pst.setString(7, "");

        // System.out.print( preparedStatement );
        pst.executeUpdate(); /* Executa o statement estruturado*/

        return String.valueOf(0);
    }

    public static String LogTimerdirectTransportador(String Whenstart, long InicialTime, long FinalTime, String WhichModule,String Description) throws SQLException, IOException {
        GetData gd = new GetData(); /* Instancia a classe que pega a data*/
        String Whenfinish = gd.getDatanow(); /* Salva a data em uma variavel data*/

        TimeCalculator tc = new TimeCalculator(); /* Instancia classe que calcula o tempo levado da execução de certa classe*/
        long TookTime = tc.GetTookTime(InicialTime, FinalTime); /* Passa tempos de inicio e fim da execução de certa classe*/

        Connection con = getConnection(); /* Estabelece conexão com o banco de dados*/

        String InsertSql = "INSERT INTO LogTransportador_tb (Whenstart,InicialTime,WhichModule,Whenfinish,FinalTime,TookTime,Description) VALUES(?,?,?,?,?,?,?)";  /* String estruturada para usar com o preparedstatement */

        PreparedStatement pst = con.prepareStatement(InsertSql); /* Instancia o statement estruturado com a string estruturada*/
        pst.setString(1, Whenstart); /* Instancia os atributos a serem salvos no banco*/
        pst.setLong(2, InicialTime);
        pst.setString(3, WhichModule);
        pst.setString(4, Whenfinish);
        pst.setLong(5, FinalTime);
        pst.setLong(6, TookTime);
        pst.setString(7, "");

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
         /*String user = "root";
        String senha = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/logserver";*/

        String user =  PropAutomation.getdblogin("logserver");
        String senha = PropAutomation.getdbpassword("logserver");
        String adress =  PropAutomation.getdbAdress("logserver");
        int port = Integer.parseInt(PropAutomation.getdbport("logserver"));


        String url = "jdbc:mysql://"+adress+":"+port+"/logserver";

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


     /*  try {

            Connection con = getConnection();
            System.out.println( "Database connection established" );

            Statement stmt = con.createStatement();
            String query1 = "show tables";
            //String query2 = "SELECT h.itemid, avg(h.value) AS avg, hs.host FROM history h LEFT JOIN items i ON h.itemid = i.itemid LEFT JOIN hosts hs ON i.hostid = hs.hostid GROUP BY h.itemid ORDER BY avg DESC ";

            ResultSet rs = stmt.executeQuery( query1 );

            while (rs.next()) {
                String result = rs.getString( 1 );
                System.out.println( "Resultado: " + result );
            }

            con.close();

        } catch (Exception ex) {
            // handle any errors
            System.out.println( "SQLException: " + ex.getMessage() );
          //  System.out.println( "SQLState: " + ex.getSQLState() );
          //  System.out.println( "VendorError: " + ex.getErrorCode() );
        }*/

}
