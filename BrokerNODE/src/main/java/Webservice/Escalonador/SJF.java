package Webservice.Escalonador;

import java.util.Scanner;

public class SJF {

    Scanner sc = new Scanner( System.in );
    int[] process, bt, wt;
    int temp, size;
    int twt = 0; //Total Waiting time
    float awt = 0; /*Tempo de espera medio - average wait time*/

    public SJF(int processes[],  int burst_time[]) { //construtor pra carregar as paradas
        this.size = processes.length;
        process = processes; //id dos processos
        bt = burst_time; //burst time
        wt = new int[size]; //waiting tme
    }

    public void get(int processes[],  int burst_time[]) {
        for (int i = 0; i < size; i++) {
          /*  System.out.println( "insira ID do processo " + (i + 1) );
          //  process[i] = sc.nextInt();
            System.out.println( "insira Burst Time processo " + (i + 1) );
            bt[i] = sc.nextInt();*/

            // System.out.println("position" + i + ":" + processes[i]);
           //  System.out.println("position" + i + ":" + burst_time[i]);
        }
    }

    public void shortess() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (bt[i] > bt[j]) {
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }

        wt[0] = 0;
        for (int i = 1; i < size; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            twt = twt + wt[i];
        }
        awt = ( float ) twt / size;
    }

    public void display() {
        System.out.println( "P_ID\t P_TIME\t W_TIME\t" );
        for (int i = 0; i < size; i++) {
            System.out.println( process[i] + "\t" + bt[i] + "\t" + wt[i] );
        }
        System.out.println( "Total Waiting Time: " + twt );
        System.out.println( "Average Waiting Time: " + awt );
    }


}

/*class KSJF {
    public static void main(String arg[]) {
        Scanner s = new Scanner( System.in );
        System.out.println( "Enter Number of Processes:" );
        int n = s.nextInt();
        SJF obj = new SJF( n );
        obj.get();
        obj.shortess();
        obj.display();
    }
}*/

