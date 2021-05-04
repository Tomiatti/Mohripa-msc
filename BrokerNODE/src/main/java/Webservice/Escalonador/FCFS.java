package Webservice.Escalonador;

import java.util.Scanner;

public class FCFS {
    Scanner in = new Scanner(System.in);
    int[] bt, wt, tat;
    int size;
    float t1 = 0, t2 = 0;

    public FCFS(int processes[], int burst_time[]) {  //construtor pra carregar as paradas
        this.size = processes.length; /* tamanho da fila de processos */
        bt = burst_time; /* burst time - tempo da rajada */
        wt = new int[size]; /*wait time - tempo de espera */
        tat = new int[size]; /* turn around time - tempo de resposta */
    }

    public void get(int processes[], int burst_time[]) {

        System.out.println("insira com o numero de processos");
        //size = in.nextInt();
        // System.out.print( size );
        for (int i = 0; i < size; i++) {
            // System.out.println("position" + i + ":" + processes[i]);
            //  System.out.println("position" + i + ":" + burst_time[i]);
        }
        //  System.out.println( "insira o tempo de rajada" );
        for (int i = 0; i < size; i++) {
            //    System.out.println( "tempo de rajada para o processo " + (i + 1) + "=" );
            // bt[i] = in.nextInt();
            //bt[i] = burst_time[i];
        }
    }

    public void fila() {
        wt[0] = 0;
        for (int i = 1; i < size; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
            t1 += wt[i];
        }
        for (int i = 0; i < size; i++) {
            tat[i] = bt[i] + wt[i];
            t2 += tat[i];
        }
    }

    public void display() {
        System.out.println("processo\tBT\tWT\tTAT");
        for (int i = 0; i < size; i++) {
            System.out.println("P" + (i + 1) + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        float awt = t1 / size; /*Tempo de espera medio - average wait time*/
        float atat = t2 / size; /*tempo de resposta medio - average turn around time*/
        System.out.println("tempo de espera medio " + awt);
        System.out.println("tempo de resposta medio " + atat);
    }
}

/*class KFCFS {
    public void main(String arg[]) {
        Scanner in = new Scanner( System.in );
        System.out.print( "Enter the no of process:" );
        int m = in.nextInt();
        FCFS obj = new FCFS( m );
        obj.get();
        obj.fila();
        obj.display();
    }

}*/
