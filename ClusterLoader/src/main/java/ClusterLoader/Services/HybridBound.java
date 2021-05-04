package ClusterLoader.Services;


import LogServer.GetData;
import LogServer.LogDatabase;
import LogServer.LoggerTimer;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.Random;

import static LogServer.LogDatabase.LogTimerdirectApp;

public class HybridBound {

    public void fibonacciInsert() throws IOException, SQLException {

        String Whenstart = GetData.getDatanow();
        LoggerTimer lg = new LoggerTimer();
        long InicialTime = lg.getStartTimer();


        long X[] = new long[102];
        int i, j;
        long eleito;
        Random gerador = new Random();

        //  Scanner entrada = new Scanner(System.in);
        for (i = 0; i < 101; i++) {
           //  System.out.println("digite o" + (i + 1) + "° numero");
            X[i] = 20 + gerador.nextInt(10);
        }


        for (i = 1; i <= 100; i++) {
            eleito = X[i];
            j = i - 1;

            while (j >= 0 && X[j] > eleito) {
                X[j + 1] = X[j];
                System.out.println(Fibonacci((int)X[j]));
                j = j - 1;

            }
            X[j + 1] = eleito;
            Fibonacci((int)X[i]);
        }


        long FinalTime = lg.getEndTimer();
        LogDatabase ld = new LogDatabase();
        String whichmodule= "HybridBound-time from "+ InetAddress.getLocalHost().getHostName()+ "";
        LogTimerdirectApp(Whenstart,  InicialTime,  FinalTime, whichmodule,"");

    }


    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (n == 1) {
                return 1;
            } else {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException {

        new HybridBound().fibonacciInsert();


    }

}
