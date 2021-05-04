package Webservice.Politicas.Administrativas.SocketReceiver.UDP;


import java.io.IOException;
import java.net.*;

public class servidorUDP {

    public static final int port = 12345; /*Definindo porta do servidor*/
    private ServerSocket server = null;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // while(true){
        new servidorUDP().runServer();
        //  }
    }

    public void runServer() throws IOException, ClassNotFoundException {
        try {
            int numConn = 1;

            DatagramSocket serverSocket = new DatagramSocket(port);

            byte[] receiveData = new byte[512];
            byte[] sendData = new byte[1024];


            DatagramPacket inFromClient = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Porta 12345 está aberta!");
            serverSocket.receive(inFromClient);
            System.out.println("Nova conexão com o cliente");

            String sentence = new String(inFromClient.getData());
            System.out.println(sentence);


            InetAddress IPAddress = inFromClient.getAddress();

            int port = inFromClient.getPort();

            String capitalizedSentence = "OK";

            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);

            // System.out.print("Enviando " + capitalizedSentence + "...");

            serverSocket.send(sendPacket);

        } catch (Exception e) {
            /* TRY/CATCH para pegar as principais informações de erro que um socket pode ocorrer */
            System.err.println("Server Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
            System.err.println("To String: " + e.toString());
        }

    }
}

/* Criar um novo socker chamado server que pega a variavel final definida acima
            server = new ServerSocket(port);
                    System.out.println("Porta 12345 está aberta!");

                    /* Quando um cliente se connecta ao servidor, essa linha permite o acesso e mostra quem foi o hot responsavel
                    Socket clientUDP = server.accept();
                    System.out.println("Nova conexão com o cliente " + clientUDP.getInetAddress().getHostAddress());

                    /* Cria a entrada e a saida do socket do servidor, para troca de mensagens com o cliente
                    ObjectOutputStream outToClient = new ObjectOutputStream(clientUDP.getOutputStream());
                    ObjectInputStream inFromClient = new ObjectInputStream(clientUDP.getInputStream());

                    /* Cria-se um hashmap vazio para receber o hashmap do cliente
                    Map <String, Object> map = new HashMap <>();
        map = ( Map <String, Object> ) inFromClient.readObject();
        System.out.println(map);*/
//outToClient.writeObject(map);

// client.close();
// server.close();