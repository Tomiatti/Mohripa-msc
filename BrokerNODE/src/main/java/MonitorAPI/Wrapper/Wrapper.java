package MonitorAPI.Wrapper;

import MonitorAPI.Tools.Dstat.DstatConnector;
import MonitorAPI.Tools.Dstat.DstatMetrics;
import MonitorAPI.Tools.Ganglia.GangliaConnector;

public class Wrapper extends NormalizedMetrics {

    public static float[] DstatRequest() {
        DstatConnector dc = new DstatConnector();
        dc.getCPU();
        dc.getMEM();

        DstatMetrics dm = new DstatMetrics();

        Wrapper wp = new Wrapper();

        float iCcpu = wp.getICcpu( dm.getIdl() );
        //  System.out.print( iCcpu );

        float ICmem = wp.getICmem( dm.getUsed(), dm.getBuff(), dm.getCach(), dm.getFree() );
        //  System.out.print( ICmem );

        float[] Metrics = {iCcpu, ICmem};

        return Metrics;
    }

    public static float[] GangliaRequest() {
        GangliaConnector gc = new GangliaConnector();
        gc.getCPU();
        gc.getMEM();

        float iCcpu = gc.getCPU();
        float ICmem = gc.getMEM();

        float[] Metrics = {iCcpu, ICmem};
        return Metrics;
    }

    public static float[] ZabbixRequest() {
        float[] Metrics = {};
        return Metrics;
    }


    public static void main(String[] args) {
        DstatRequest();

    }

    public float getICcpu(float CpuIdle) {

        // float CpuIdle = 50;
        // float CpuSpeed = 50;

        float cpuNormalized = (100 - CpuIdle);
        //System.out.println( cpuNormalized );
        return cpuNormalized;
    }

    public float getICmem(float MemUsed, float MemBuff, float MemCach, float MemFree) {
        float MemTotal = MemUsed + MemBuff + MemCach + MemFree;
        //float MemFree = 8000;
        //System.out.println( MemTotal );
        float memNormalized = 100 - (100 * MemFree / MemTotal);
        //System.out.println( memNormalized );
        return memNormalized;
    }

    public float getICdsk() {
        float read = 0;
        float writ = 0;
        // float DiskTotal = 1000000000 / 8;
        float diskNormalized = (100 * (read + writ));
        return diskNormalized;
    }

    public float getICnet() {
        float recv = 0;
        float send = 0;
        Float netNormalized = (100 * (recv + send)) / (1000000000 / 8);
        return netNormalized;
    }

}

/*private static float CPUBigger = 2400;
    private static float MemBigger = 244748;
    private static float netBigger = 1000000000 / 8;
    private static float DiskBigger = 1000000000;*/