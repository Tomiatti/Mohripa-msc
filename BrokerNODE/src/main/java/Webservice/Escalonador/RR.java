package Webservice.Escalonador;

import java.util.Scanner;

public class RR {
    Scanner sc = new Scanner( System.in );
    int[] bt, rem, wt, ta;
    int size, q = 2, b = 0, t = 0, flag = 0;

    public RR(int processes[],  int burst_time[]) { //construtor pra carregar as paradas
        this.size = processes.length;
        bt = burst_time;
        wt = new int[size];
        ta = new int[size];
        rem = new int[size];
    }

    public void get(int processes[],  int burst_time[]) {
        for (int i = 0; i < size; i++) {
        /*    System.out.print( "Enter burst time of P" + (i + 1) + ":" );
            bt[i] = rem[i] = sc.nextInt();
        }
        System.out.print( "Enter quantum time:" );
        //q=sc.nextInt();
        q = 2;*/
            // System.out.println("position" + i + ":" + processes[i]);
            //  System.out.println("position" + i + ":" + burst_time[i]);

        }
    }

    public void round() {
        do {
            flag = 0;
            for (int i = 0; i < size; i++) {
                if (rem[i] >= q) {
                    System.out.print( "P" + (i + 1) + "\t" );
                    for (int j = 0; j < size; j++) {
                        if (j == i)
                            rem[i] = rem[i] - q;
                        else if (rem[j] > 0)
                            wt[j] += q;
                    }
                } else if (rem[i] > 0) {
                    System.out.print( "P" + (i + 1) + "\t" );
                    for (int j = 0; j < size; j++) {
                        if (j == i)
                            rem[i] = 0;
                        else if (rem[j] > 0)
                            wt[j] += rem[i];
                    }
                }
            }
            for (int i = 0; i < size; i++)
                if (rem[i] > 0)
                    flag = 1;
        } while (flag == 1);
        for (int i = 0; i < size; i++)
            ta[i] = wt[i] + bt[i];
    }

    public void display() {
        System.out.println( "\nProcess\tBurst\tWaiting\tTurnaround" );
        for (int i = 0; i < size; i++) {
            System.out.println( "P" + (i + 1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + ta[i] );
            b += wt[i];
            t += ta[i];
        }
        float awt = b / size; /*Tempo de espera medio - average wait time*/
        float atat = t / size; /*tempo de resposta medio - average turn around time*/
        System.out.println( "tempo de espera medio " +  awt);
        System.out.println( "tempo de resposta medio " + atat );
    }

}

/*class KRR {
    public static void main(String arg[]) {
        Scanner s = new Scanner( System.in );
        System.out.print( "Enter the no of process:" );
        int n = s.nextInt();
        RR obj = new RR( n );
        obj.get();
        obj.round();
        obj.display();
    }

}*/