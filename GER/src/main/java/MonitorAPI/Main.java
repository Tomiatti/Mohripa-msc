package MonitorAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicReference;

//import java.util.Scanner;

public class Main {

    public static void ExecuteScript(String cmd) throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec( cmd );
        pr.waitFor();
        AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>();
        buf.set( new BufferedReader( new InputStreamReader( pr.getInputStream() ) ) );
        String line = "";
        while ((line = buf.get().readLine()) != null)
            System.out.println( line );
        //return line;
    }




    public static void main(String[] args) throws IOException, InterruptedException {


    }


}
/*
    private static float calcIC(float P, float maiorP, float CR) {
        float bn = (float) (1.1D - (double) (P / maiorP));
        CR /= 100.0F;
        float ic = CR * bn;
        return ic;
    }

    public static float getID() {

        Float[] IC;

       // IC = new Float[]{getICcpu(), getICmem()};

        return calcID(IC);

    }

    private static float calcID(Float[] IC) {
        float ic = 0.0F;

        for (int i = 0; i < IC.length; ++i) {
            ic = (float) ((double) ic + Math.pow((double) IC[i], 2.0D));
        }
        float icfinal = (float) Math.sqrt(ic);
        System.out.println(icfinal);

        return icfinal;
    }


    public static float getICmem() {
        ComputingMetrics cm = new ComputingMetrics();
        float MemFree = Float.parseFloat(cm.getFree());
        float MemTotal = Float.parseFloat(cm.getFree() + cm.getUsed());
        float MemBigger = 16000;
//        float MemFree ;
//        float MemTotal;
//        float MemBigger;
        float memNormalized = 100.0F - 100.0F * MemFree / MemTotal;
        float v = calcIC(MemTotal, MemBigger, memNormalized);
        System.out.println("Memoria normalizada:" + memNormalized);
        return v;
    }

    public static float getICcpu() {
        ComputingMetrics cm = new ComputingMetrics();
        Float cpuidle = Float.parseFloat(cm.getIdl());
        float CpuSpeed = 100;
        float CPUBigger = 100;
        float cpuNormalized = 100.0F - cpuidle;
        float v = calcIC(CpuSpeed, CPUBigger, cpuNormalized);
        System.out.println("CPU normalizado:" + v);
        return v;
    }*/


/*
*         String cmd;
        float MemTotal = 16000;
        float MemFree = 1000;
        float cpuIdle = 80;
        float CpuSpeed = 20;
        float MemBigger = 16000;
        float CPUBigger = 100;


        Scanner Sc = new Scanner(System.in);
        int op, scriptchoice;
        boolean stopLoop = true;

        // getICcpu( cpuIdle,  CpuSpeed,  CPUBigger);
        //  getICmem(MemFree, MemTotal, MemBigger);
        //  getID();

        while (stopLoop) {
            System.out.println("------------------------Monitor Command API------------------------\n");
            System.out.println("Bem vindo, Escolha uma das Opções Abaixo.");
            System.out.println("1 = Executar Script, 2 = Lista de Scripts, 0 = Encerrar programa.");
            op = Sc.nextInt();

            switch (op) {

                case 0:
                    System.out.println("Programa Encerrado.");
                    stopLoop = false;
                    break;

                case 1:
                    System.out.println("------------------------Monitor Command API------------------------\n");
                    System.out.println("Escolha uma das Opções Abaixo.");
                    System.out.println("1 = Executar Script CPU/MEM, 2 = Executar Script CPU/MEM/DISK/NET, 3 = Indice de Desempenho, 0 = Encerrar programa.");
                    scriptchoice = Sc.nextInt();
                    switch (scriptchoice) {

                        case 0:
                            System.out.println("Programa Encerrado.");
                            stopLoop = false;
                            break;

                        case 1:
                            System.out.println("CPU Metricas.");
                            cmd = "dstat -v --output reportcpu.csv 1 10";
                            ExecuteScript(cmd);
                            System.out.println("MEM Metricas.");
                            cmd = "dstat -m --output reportmem.csv 1 10";
                            ExecuteScript(cmd);
                            break;

                        case 2:
                            System.out.println("All Metricas(CPU/MEM/DISK/NET) .");
                            cmd = "dstat -cmdn --output reportall.csv 1 10";
                            ExecuteScript(cmd);
                            break;


                        case 3:
                            System.out.println("Indice de Desempenho Metricas.");
                            float memNormalized = 100.0F - 100.0F * MemFree / MemTotal;
                            System.out.println("Memoria normalizada:" + memNormalized);


                            float cpuNormalized = 100.0F - cpuIdle;
                            System.out.println("CPU normalizado:" + cpuNormalized);


                            float ic = 0.0F;
                            Float[] IC = new Float[]{memNormalized, cpuNormalized};
                            for (int i = 0; i < IC.length; ++i) {
                                ic = (float) ((double) ic + Math.pow((double) IC[i], 2.0D));
                                //System.out.println(ic);
                            }
                            float icfinal = (float) Math.sqrt(ic);
                            System.out.println("Indice de Consumo:" + icfinal);
                            break;

                    }

                case 2:
                    System.out.println("------------------------Monitor Command API------------------------\n");
                    System.out.println("------------------------Script List--------------------------------\n");
                    System.out.println("CPU");
                    System.out.println("MEM");
                    break;

            }

        }
    }
*/