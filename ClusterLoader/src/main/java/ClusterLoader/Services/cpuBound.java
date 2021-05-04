package ClusterLoader.Services;

import LogServer.*;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Random;

import static LogServer.LogDatabase.LogTimerdirectApp;

public class cpuBound {

    public void matrizmultiplication() throws IOException, SQLException {
        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();

        int n = 10; // ordem da matriz quadrada
        int i, j, k, sm;
        int a[][] = new int[10][10];
        int b[][] = new int[10][10];
        int ab[][] = new int[10][10];
        Random gerador = new Random();

// entrada de dados
        //    System.out.printf("1a. Matriz_________________________\n");
        for (i=0; i<n; i++) {
            for (j=0; j<n; j++) {
               // System.out.printf("a[%d][%d] = ", i, j);
                a[i][j] = gerador.nextInt(5) + 10;
            }
            System.out.printf("\n");
        }

        //   System.out.printf("\n2a. Matriz_________________________\n");
        for (i=0; i<n; i++) {
            for (j=0; j<n; j++) {
              //  System.out.printf("b[%d][%d] = ", i, j);
                b[i][j] = gerador.nextInt(5) + 10;
            }
            System.out.printf("\n");
        }

// processamento: multiplicando as matrizes de entrada
        for (i=0; i<n; i++) {
            for (j=0; j<n; j++) {
                sm = 0;
                for (k=0; k<n; k++) {
                    sm = sm + (a[i][k] * b[k][j]);
                }
                ab[i][j] = sm;
            }
        }

// saida
        System.out.printf("\n1a. Matriz________\n");
        for (i=0; i<n; i++) {
            System.out.printf("%da. linha: ", (i+1));
            for (j=0; j<n; j++) {
               // System.out.printf("%d ", a[i][j]);
            }
          //  System.out.printf("\n");
        }

        System.out.printf("\n2a. Matriz________\n");
        for (i=0; i<n; i++) {
           // System.out.printf("%da. linha: ", (i+1));
            for (j=0; j<n; j++) {
          //      System.out.printf("%d ", b[i][j]);
            }
        //    System.out.printf("\n");
        }

        System.out.printf("\nProduto___________\n");
        for (i=0; i<n; i++) {
            System.out.printf("%da. linha: ", (i+1));
            for (j=0; j<n; j++) {
                System.out.printf("%d ", ab[i][j]);
            }
            System.out.printf("\n");
        }

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        String whichmodule= "CpuBound-time from "+ InetAddress.getLocalHost().getHostName()+ "";
        LogTimerdirectApp(Whenstart,  InicialTime,  FinalTime, whichmodule,"");
    }

    public static void main(String[] args) throws IOException, SQLException{




        new cpuBound().matrizmultiplication();


      /*  String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer() ;

        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        String whichmodule= "cpubound-time from "+ InetAddress.getLocalHost().getHostName()+ "";

        System.out.println(whichmodule);
       LogTimerdirect(Whenstart,  InicialTime,  FinalTime, whichmodule);*/


    }
}
