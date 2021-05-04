package MonitorAPI.Tools.Zabbix;

import java.sql.*;

public class local {
    public static void main(String[] args) {

        try {

            Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();
        } catch (Exception ex) {
            System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }
        Connection con = null;

        try {
            // CouchDB12#$
            // http://devops.lasdpc.icmc.usp.br
            // 143.107.183.46
            // "jdbc:mysql://143.107.183.46:3306/information_schema?user=zabbix&password="+

            String user = "root";
            String senha = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/mydb";

            //String senha = "dash#2017";
            // String url = "jdbc:mysql://10.0.2.231:22201/cloud_db";

            con = DriverManager.getConnection( url, user, senha );
            //Connection con = getConnection();
            System.out.println( "Database connection established" );

            Statement stmt = con.createStatement();
            String query1 = "show tables";
            //String query2 = "SELECT h.itemid, avg(h.value) AS avg, hs.host FROM history h LEFT JOIN items i ON h.itemid = i.itemid LEFT JOIN hosts hs ON i.hostid = hs.hostid GROUP BY h.itemid ORDER BY avg DESC ";

            // http://www.guj.com.br/t/select-com-preparedstatement/40045 select estruturado


            ResultSet rs = stmt.executeQuery( query1 );

            while (rs.next()) {
                String result = rs.getString( 1 );
                System.out.println( "Resultado: " + result );
            }

            con.close();

        } catch (SQLException ex) {
            // handle any errors
            System.out.println( "SQLException: " + ex.getMessage() );
            System.out.println( "SQLState: " + ex.getSQLState() );
            System.out.println( "VendorError: " + ex.getErrorCode() );
        }
    }


    private static Connection getConnection() throws SQLException {
        try {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
        } catch (Exception ex) {
            System.out.println( "Problem in loading or " + "registering MS Access JDBC driver" );
            ex.printStackTrace();
        }
        String user = "zabbix";
        String senha = "CouchDB12#$%";
        String url = "jdbc:mysql://143.107.183.46:3306/information_schema";
        return DriverManager.getConnection( url, user, senha );
    }

    private static ResultSet ExecuteStatement(String Query) throws SQLException {
        Connection con = getConnection();
        System.out.println( "Database connection established" );
        Statement stmt = con.createStatement();
        ResultSet rs =  stmt.executeQuery( Query );

        return rs ;
    }

}