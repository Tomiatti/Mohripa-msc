package MonitorAPI.Tools.Ganglia;

public class GangliaConnector {

    public static void main(String[] args) {
        GangliaInformationParser gip = new GangliaInformationParser();
      //  gip.Connect("10.0.3.10",8660  );  /*classe que conecta ao server ou aos slaves*/
      //  gip.getHostsInformation();

        GangliaHost gh = new GangliaHost();
        //gh.


    }

    public static void GetMetrics(){


    }

    /**
     * Gets the load CPU index of the resource
     * @return The calculated load index of the CPU
     */
    public static float getCPU(){
        GangliaHost gh = new GangliaHost();
        gh.getCpuIdle();
        return 0;
    }


    /**
     * Gets the memory load index of the resource
     * @return The calculated memory index of the CPU
     */
    public static float getMEM(){
        GangliaHost gh = new GangliaHost();
        gh.getMemFree();
        gh.getMemTotal();
        return 0;
    }

    /**
     * Gets the disk load index of the resource
     * @return The calculated disk index of the CPU
     */
    public static float getDISK(){
        GangliaHost gh = new GangliaHost();
        return 0;
    }

    /**
     * Gets the network load index of the resource
     * @return The calculated network index of the CPU
     */
    public static float getNET(){
        GangliaHost gh = new GangliaHost();

        return 0;
    }

}
