package MonitorAPI.Wrapper;

import MonitorAPI.LogServer.GetClassname;
import MonitorAPI.LogServer.LogDatabase;
import MonitorAPI.LogServer.LoggerTimer;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

//import MonitorIndice.Wrapper.Wrapper;

public class IndiceCalc {

    // private static float CPUBigger = 2400;
    //private static float MemBigger = 244748;
    //private static float netBigger = 1000000000 / 8;

    public static float IDcalculator(float[] Metrics) throws IOException {

     /*   GetClassname gcn = new GetClassname();
        GetMethodname gmn = new GetMethodname();
        LoggerTimer lg = new LoggerTimer();
        long start = lg.getStartMethod(gmn.getNamemethod());*/


        DecimalFormat df = new DecimalFormat("0.00");
        float ic = 0.0F;


        float[] IC = Metrics;
        //Float[] IC = new Float[]{};

        for (int i = 0; i < IC.length; ++i) {
            ic = ( float ) (( double ) ic + Math.pow(( double ) IC[i], 2.0D));
            //System.out.println(ic);
        }

        float icfinal = ( float ) Math.sqrt(ic);
        System.out.println("Indice de Consumo:" + df.format(icfinal));


       /* long end = lg.getEndMethod(gmn.getNamemethod());
        LogDatabase ld = new LogDatabase();
        ld.LogMethodInsert(start,end,gcn.getNameClass(), gmn.getNamemethod());
        */

        return icfinal;
    }

    public static void main(String[] args) throws IOException, SQLException {

        GetClassname gcn = new GetClassname();
        LoggerTimer lg = new LoggerTimer();

        long start = lg.getStartClass(gcn.getNameClass());/**/

        IDcalculator(Wrapper.DstatRequest());

        long end = lg.getEndClass(gcn.getNameClass());

        LogDatabase ld = new LogDatabase();
        ld.LogClassInsert(start, end, gcn.getNameClass());



       /* TimeCalculator tc = new TimeCalculator();
        long TookTime = tc.GetTimerClass( start, end, gcn.getNameClass() );
        System.out.print( "Took:" + TookTime + "ms" ); */


    }


}