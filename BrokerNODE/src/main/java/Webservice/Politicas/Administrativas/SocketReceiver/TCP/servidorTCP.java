package Webservice.Politicas.Administrativas.SocketReceiver.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.net.SocketException;
import java.util.*;

public class servidorTCP  {

    public static final int port = 12345; /*Definindo porta do servidor*/
    private ServerSocket server ;
    public List <String> Resources;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        new servidorTCP().runServer();
    }

    public List <String> runServer() {
        try {
            server = new ServerSocket(port);


            /* Criar um novo socker chamahtopdo server que pega a variavel final definida acima*/
            System.out.println("Porta 12345 está aberta!");

            /* Quando um cliente se connecta ao servidor, essa linha permite o acesso e mostra quem foi o hot responsavel*/
            Socket client = server.accept();
            System.out.println("Nova conexão com o cliente " + client.getInetAddress().getHostAddress());

            /* Cria a entrada e a saida do socket do servidor, para troca de mensagens com o cliente */
            ObjectOutputStream outToClient = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(client.getInputStream());

            /* Cria-se um hashmap vazio para receber o hashmap do cliente */
            //  Map <String, Object> map = new HashMap <>();
            //   map = ( Map <String, Object> ) inFromClient.readObject();
            //  System.out.println(map);

         //   server.setTcpNoDelay(true);

            Resources = ( List <String> ) inFromClient.readObject();
            System.out.println(Resources);
           // System.out.println("The server socket is bounded: " + server.isBound());
            server.close();

            if (server.isClosed() == true) {
                runServer();
            }

        } catch (Exception e) {
            /* TRY/CATCH para pegar as principais informações de erro que um socket pode ocorrer */
            System.err.println("Server Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
            System.err.println("To String: " + e.toString());
        }

        return Resources;
    }
}
