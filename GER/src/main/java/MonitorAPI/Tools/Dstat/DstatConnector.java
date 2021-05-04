package MonitorAPI.Tools.Dstat;

public class DstatConnector {

   /* public static void main(String[] args){
        getCPU();
        DstatMetrics dm = new DstatMetrics(  );
     //   System.out.print( dm.getIdl() );

    }*/

   public static void GetMetrics(){
       ProcessBuilderDstat pbd = new ProcessBuilderDstat();
       pbd.cpuMetrics();
       pbd.memMetrics();
       pbd.diskMetrics();
       pbd.networkMetrics();
   }

    /**
     * Gets the load CPU index of the resource
     * @return The calculated load index of the CPU
     */
    public static float getCPU(){
        ProcessBuilderDstat pbd = new ProcessBuilderDstat();
        pbd.cpuMetrics();
        return 0;
    }


    /**
     * Gets the memory load index of the resource
     * @return The calculated memory index of the CPU
     */
    public static float getMEM(){
        ProcessBuilderDstat pbd = new ProcessBuilderDstat();
        pbd.memMetrics();
        return 0;
    }

    /**
     * Gets the disk load index of the resource
     * @return The calculated disk index of the CPU
     */
    public static float getDISK(){
        ProcessBuilderDstat pbd = new ProcessBuilderDstat();
        pbd.diskMetrics();
        return 0;
    }

    /**
     * Gets the network load index of the resource
     * @return The calculated network index of the CPU
     */
    public static float getNET(){
        ProcessBuilderDstat pbd = new ProcessBuilderDstat();
        pbd.networkMetrics();
        return 0;
    }


}
