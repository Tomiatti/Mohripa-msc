package Webservice.Escalonador;


//escalonamento de prioridade
public class PS {
    int[] process, bt, wt, rank;
    int temp, size;
    int twt = 0; //Total Waiting time
    float awt = 0; /*Tempo de espera medio - average wait time*/

    public PS(int processes[], int burst_time[], int priority[]) { //construtor pra carregar as paradas
        this.size = processes.length;
        rank = priority;
        process = processes; //id dos processos
        bt = burst_time; //burst time
        wt = new int[size]; //waiting tme
    }

    public void get(int processes[], int burst_time[], int priority[]) {
        for (int i = 0; i < size; i++) {
            // System.out.println("position" + i + ":" + processes[i]);
            //  System.out.println("position" + i + ":" + burst_time[i]);
            //  System.out.println("position" + i + ":" + priority[i]);

        }


    }

    public void priority() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (rank[i] < rank[j]) {
                    temp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = temp;


                    temp = process[i];
                    process[i] = process[j];
                    process[j] = temp;
                }
            }
        }

    }

    public void display() {
        System.out.println("P_ID\t RANK\t B_TIME\t");
        for (int i = 0; i < size; i++) {
            System.out.println(process[i] + "\t" + rank[i] + "\t" + bt[i]);
        }
        System.out.println("Total Waiting Time: " + twt);
        System.out.println("Average Waiting Time: " + awt);
    }

}


