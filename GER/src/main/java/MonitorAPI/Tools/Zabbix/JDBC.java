package MonitorIndice.Zabbix;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {

        try {

            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
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

            String user = "zabbix";
            String senha = "CouchDB12#$%";
            String url = "jdbc:mysql://143.107.183.46:3306/information_schema";

            con = DriverManager.getConnection( url, user, senha );
            //Connection con = getConnection();
            System.out.println( "Database connection established" );

            Statement stmt = con.createStatement();
            String query = "show tables";
            ResultSet rs = stmt.executeQuery( query );

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

    private static Connection getConnection() throws Exception {
        String user = "zabbix";
        String senha = "CouchDB12#$%";
        String url = "jdbc:mysql://143.107.183.46:3306/information_schema";
        return DriverManager.getConnection( url, user, senha );
    }
}
