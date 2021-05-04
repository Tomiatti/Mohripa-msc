package ClusterLoader.Services;

import LogServer.GetData;
import LogServer.LogDatabase;
import LogServer.LoggerTimer;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;

import static LogServer.LogDatabase.LogTimerdirectApp;


public class MemoryBound {


   public void fibonacci() throws IOException, SQLException{
       String Whenstart = GetData.getDatanow();
       LoggerTimer lg = new LoggerTimer();
       long InicialTime = lg.getStartTimer();


       int tamanho = 100;
       //getTotalTermos();
       long[] numeros = new long[tamanho];

       numeros[0]=0;
       numeros[1]=1;

       System.out.print("0, 1");

       for(int i=2; i<numeros.length; i++)
       {
           numeros[i] = numeros[i-1] + numeros[i-2];

           System.out.println(", " + numeros[i]);
       }

       System.out.println();

       long FinalTime = lg.getEndTimer();
       LogDatabase ld = new LogDatabase();
       String whichmodule= "Memorybound-time from "+ InetAddress.getLocalHost().getHostName()+ "";
       LogTimerdirectApp(Whenstart,  InicialTime,  FinalTime, whichmodule,"");

    }

    public static void main(String[] args)throws IOException, SQLException
    {
        new MemoryBound().fibonacci();
    }


}


 /*   private static int getTotalTermos()
    {
        int total_termos;
        Scanner input = new Scanner(System.in);

        try
        {
            System.out.print("Digite a quantidade de termos: " );
            total_termos = input.nextInt();

            if(total_termos<2)
            {
                System.out.println("Por favor digite um número que seja maior do que 1" );
                return getTotalTermos();
            }
        }
        catch(Exception e)
        {
            System.out.println("Erro - Número inteiro inválido");
            return getTotalTermos();
        }

        return total_termos;
    }*/