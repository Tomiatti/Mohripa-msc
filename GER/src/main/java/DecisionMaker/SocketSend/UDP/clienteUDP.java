package DecisionMaker.SocketSend.UDP;

import DecisionMaker.Filter.ResourceListSelect;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.List;

public class clienteUDP {

    public static final int port = 12345; /*Definindo porta do cliente*/
    public static final String adress = "127.0.0.1"; /*Definindo Endereço do cliente*/

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        new clienteUDP().runClient();
    }

    public void runClient() throws IOException, ClassNotFoundException {
        try {

            DatagramSocket clientSocketUDP = new DatagramSocket();

            // String servidor = "localhost";

            InetAddress IPAddress = InetAddress.getByName(adress);

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[512];

            System.out.println("O cliente se conectou ao servidor!");

         /*   Connection con = getConnection(); // Estabelece conexão com o banco de dados
            Statement stmt = con.createStatement();
            String Query = ("SELECT Hostname, ID_calc, Whenhappen from Monitor_tb GROUP BY Hostname order by Whenhappen;");
            HashMap <String, Float> map = new HashMap <String, Float>();
            ResultSet rs = stmt.executeQuery(Query);

            while (rs.next()) {
                String host = rs.getString("Hostname");
                Float indice = rs.getFloat("ID_calc");
                map.put(host, indice);
            }*/

            List<String> resources = new ResourceListSelect().GetResources(null);
            System.out.println(resources);



            String sentence = String.valueOf(resources);
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);

            System.out.println("Enviando Informações ao Server ..." + adress + ":" + port);
            clientSocketUDP.send(sendPacket);

            DatagramPacket outToServer = new DatagramPacket(receiveData,
                    receiveData.length);

            clientSocketUDP.receive(outToServer);
            // System.out.println("Pacote UDP recebido...");

            clientSocketUDP.close();
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

//   DatagramSocket clientUDP = new DatagramSocket();
//
// /*Criando novo socket para cliente
//
// System.out.println("O cliente se conectou ao servidor!");

//                System.out.println("Gerando Hash");
//              Map <String, Object> map = new HashMap <>();
//    map.put("Provedor", "cosmos");
//   map.put("ip", "192.168.0.1");
//    map.put("VM", "VM4-01");
//   map.put("indice de desempenho", "20");

// Create the input & output streams to the server
// ObjectOutputStream outToServer = new ObjectOutputStream(client.getOutputStream());
// ObjectInputStream inFromServer = new ObjectInputStream(client.getInputStream());

//    System.out.println("Ok");
//
// outToServer.writeObject(map);
//     System.out.println("Enviando Informações ao Server ...");

// ObjectInputStream is = new ObjectInputStream(client.getInputStream());

//client.close();