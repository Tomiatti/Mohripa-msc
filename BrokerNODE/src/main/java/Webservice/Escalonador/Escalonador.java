package Webservice.Escalonador;

import java.util.Scanner;

public class Escalonador {


    public static void SchedulingDispatcher(int process, int burst_time, int priority){

        //process id's
         int vectorProcesses[] = {process};
        int size = vectorProcesses.length;

        //Burst time of all processes
         int Vectorburst_time[] = {burst_time};

        //priority of all processes
        int Vectorpriority[] = {priority};

      //  SchedulerProcess(vectorProcesses, Vectorburst_time, Vectorpriority);


    }
   // int process, int burst_time, int priority
    // int vectorProcesses[], int Vectorburst_time[], int Vectorpriority[]

    public static int SchedulerProcess(int process, int burst_time, int priority){


        //process id's
        int vectorProcesses[] = {process};
       int size = vectorProcesses.length;

        //Burst time of all processes
        int Vectorburst_time[] = {burst_time};

        //priority of all processes
        int Vectorpriority[] = {priority};

        Scanner Sc = new Scanner(System.in);
        int op;

        System.out.println("------------------------Escalonador Choicer API------------------------\n");
        System.out.println("Bem vindo, Escolha uma das Opções Abaixo.");
        System.out.println("1 = Round Robin, 2 = First in First Out, 3 = Shortest JOb first,0 = Sair.");

        op = 1;

        switch (op) {

            case 0:
                System.out.println("Faloou pra quem fica!!! eu to indo #PARTIU");
                break;

            case 1:
                RR rr = new RR(vectorProcesses, Vectorburst_time);
                //rr.get(vectorProcesses, Vectorburst_time);
                rr.round();
                rr.display();

                break;

            case 2:
                FCFS fc = new FCFS(vectorProcesses, Vectorburst_time);
                //fc.get( processes,   burst_time); //para debuggar
                fc.fila();
                fc.display();

                break;

            case 3:
                SJF sjf = new SJF(vectorProcesses, Vectorburst_time);
                //sjf.get(processes,   burst_time );
                sjf.shortess();
                sjf.display();

                break;

            case 4:
                PS ps = new PS(vectorProcesses, Vectorburst_time, Vectorpriority);
                //ps.get(vectorProcesses, Vectorburst_time, Vectorpriority);
                ps.priority();
                ps.display();

                break;
        }

            return 0;
    }


    public static int ProcessConsultingPool (int process, int burst_time, int priority){
        SchedulerProcess(process,burst_time,priority);






        return 0;
    }



    public static void main(String[] args) {

        SchedulerProcess(1,2,1);
        SchedulerProcess(2,12,2);
        SchedulerProcess(3,9,3);

       // SchedulerProcess();

    }


    /*
    *  //   int[] processos = {12, 32, 54, 6, 8, 89, 64, 64, 6};

        //process id's
        int processes[] = {1, 2, 3};
        int size = processes.length;

        //Burst time of all processes
        int burst_time[] = {10, 5, 8};

        //priority of all processes
        int priority[] = {3, 2, 1};

        Scanner Sc = new Scanner(System.in);
        int op;

        System.out.println("------------------------Escalonador Choicer API------------------------\n");
        System.out.println("Bem vindo, Escolha uma das Opções Abaixo.");
        System.out.println("1 = Round Robin, 2 = First in First Out, 3 = Shortest JOb first,0 = Sair.");

        op = 4;

        switch (op) {

            case 0:
                System.out.println("Faloou pra quem fica!!! eu to indo #PARTIU");
                break;

            case 1:
                // int n = Sc.nextInt();
                //int n = 2;
                RR rr = new RR(processes, burst_time);
                rr.get(processes, burst_time);
                rr.round();
                rr.display();

                break;

            case 2:
                FCFS fc = new FCFS(processes, burst_time);
                //fc.get( processes,   burst_time); //para debuggar
                fc.fila();
                fc.display();

                break;

            case 3:
                //int o = Sc.nextInt();
                //int o = 0;
                SJF sjf = new SJF(processes, burst_time);
                //sjf.get(processes,   burst_time );
                sjf.shortess();
                sjf.display();

                break;

            case 4:

                PS ps = new PS(processes, burst_time, priority);
                ps.get(processes, burst_time, priority);
                ps.priority();
                ps.display();

                break;
        }
    }*/

}
