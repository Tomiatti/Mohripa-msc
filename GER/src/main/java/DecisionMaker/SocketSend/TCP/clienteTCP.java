package DecisionMaker.SocketSend.TCP;

import DecisionMaker.Filter.ResourceListSelect;
import DecisionMaker.Resources.GetVM;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;


public class clienteTCP extends Thread{
    public static final int port = 12345; /*Definindo porta do cliente*/
    public static final String adress = "127.0.0.1"; /*Definindo Endereço do cliente*/


    public Socket cliente;

    public clienteTCP(Socket cliente){
        this.cliente = cliente;
    }

    public clienteTCP() {

    }


    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        new clienteTCP().run();
    }

    public void run() {
        try {

            Socket Socket = new Socket(adress, port); /*Criando novo socket para cliente*/
            System.out.println("O cliente se conectou ao servidor!");
            Socket.setKeepAlive(true);
            Socket.setTcpNoDelay(true);


           /* Connection con = getConnection(); // Estabelece conexão com o banco de dados
            Statement stmt = con.createStatement();
            String Query = ("SELECT Hostname, ID_calc, Whenhappen from Monitor_tb GROUP BY Hostname order by Whenhappen;");
            HashMap <String, Float> map = new HashMap <String, Float>();
            ResultSet rs = stmt.executeQuery(Query);


            while (rs.next()) {
                String host = rs.getString("Hostname");
                Float indice = rs.getFloat("ID_calc");
                map.put(host, indice);
            }*/

            List<String> Resources = new ResourceListSelect().GetResources(null);
           // HashMap map = new GetVM().getAvalibleVm(String.valueOf(Resources));
            String mapToarray = String.valueOf("map").replaceAll("}", "").replaceAll("\\{", "");
            String[] arrayToProduct = mapToarray.split(",");
            System.out.println(Resources);

            // Create the input & output streams to the server
            ObjectOutputStream outToServer = new ObjectOutputStream(Socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(Socket.getInputStream());

            System.out.println("Ok");

            outToServer.writeObject(arrayToProduct);
            outToServer.flush();
            System.out.println("Enviando Informações ao Server ..." + adress + ":" + port);

            // ObjectInputStream is = new ObjectInputStream(client.getInputStream());
            Socket.close();
            System.out.println("Socket cliente fechado!");


        } catch (Exception e) {
            System.err.println("Client Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
        }

    }


    public static Connection getConnection() throws SQLException {
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

}

 /*
        * Map<String, Object> map = new HashMap<>();
        map.put("ip", "192.168.0.1");
        map.put("indice de desempenho", 20);
        socket.send(map)
        *
        * */

/* Scanner sc = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (sc.hasNextLine()) {
            saida.println(sc.nextLine());
        }*/

//saida.close();
//  sc.close();