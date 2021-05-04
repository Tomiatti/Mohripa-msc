package Alocador;

import java.io.IOException;
import java.sql.SQLException;

import static Alocador.SecuredSessionDispatcher.SecuredSingleExecutorExternal;
import static Alocador.SessionDispatcher.SingleExecutorExternal;

public class MultipleDispatcher {


    public static void main(String[] args) throws IOException, SQLException {

        //   String Operation = new MethodsOperationCall().startCall();

      //  String Operation = new MethodsOperationCall().restartCall();

            String Operation = new MethodsOperationCall().shutdownCall();

        //   String Operation = new MethodsOperationCall().destroyCall();

       //   String Operation = new MethodsOperationCall().resumeCall();

        //    String Operation = new MethodsOperationCall().pauseCall();

         //   String Operation = new MethodsOperationCall().stopCall();

       //  String Operation = new MethodsOperationCall().dominfoCall();


        int port = 2090;
        String host = "COS09";

        //  SingleExecutorExternal(Operation, port, host + "-VM1");


    //    ExecuteOnCosmos(Operation);

        ExecuteOnHalley(Operation);

        ExecuteOnAndromeda(Operation);


      //    SecuredExecuteOnCosmos(Operation);

     //     SecuredExecuteOnHalley(Operation);

      //    SecuredExecuteOnAndromeda(Operation);


       /* long start = System.nanoTime();
        long end = System.nanoTime();

        long TookTime = (end - start) / 1000000;

        System.out.print(TookTime);*/


    }


    public static int ExecuteOnCosmos(String Operation) throws IOException, SQLException {

        SingleExecutorExternal(Operation, 2010, "COS01-VM1");
        SingleExecutorExternal(Operation, 2010, "COS01-VM2");
        SingleExecutorExternal(Operation, 2010, "COS01-VM3");
        SingleExecutorExternal(Operation, 2010, "COS01-VM4");

        SingleExecutorExternal(Operation, 2020, "COS02-VM1");
        SingleExecutorExternal(Operation, 2020, "COS02-VM2");
        SingleExecutorExternal(Operation, 2020, "COS02-VM3");
        SingleExecutorExternal(Operation, 2020, "COS02-VM4");

        SingleExecutorExternal(Operation, 2030, "COS03-VM1");
        SingleExecutorExternal(Operation, 2030, "COS03-VM2");
        SingleExecutorExternal(Operation, 2030, "COS03-VM3");
        SingleExecutorExternal(Operation, 2030, "COS03-VM4");

        SingleExecutorExternal(Operation, 2040, "COS04-VM1");
        SingleExecutorExternal(Operation, 2040, "COS04-VM2");
        SingleExecutorExternal(Operation, 2040, "COS04-VM3");
        SingleExecutorExternal(Operation, 2040, "COS04-VM4");

        SingleExecutorExternal(Operation, 2050, "COS05-VM1");
        SingleExecutorExternal(Operation, 2050, "COS05-VM2");
        SingleExecutorExternal(Operation, 2050, "COS05-VM3");
        SingleExecutorExternal(Operation, 2050, "COS05-VM4");

        SingleExecutorExternal(Operation, 2060, "COS06-VM1");
        SingleExecutorExternal(Operation, 2060, "COS06-VM2");
        SingleExecutorExternal(Operation, 2060, "COS06-VM3");
        SingleExecutorExternal(Operation, 2060, "COS06-VM4");

        SingleExecutorExternal(Operation, 2070, "COS07-VM1");
        SingleExecutorExternal(Operation, 2070, "COS07-VM2");
        SingleExecutorExternal(Operation, 2070, "COS07-VM3");
        SingleExecutorExternal(Operation, 2070, "COS07-VM4");

        SingleExecutorExternal(Operation, 2080, "COS08-VM1");
        SingleExecutorExternal(Operation, 2080, "COS08-VM2");
        SingleExecutorExternal(Operation, 2080, "COS08-VM3");
        SingleExecutorExternal(Operation, 2080, "COS08-VM4");

        SingleExecutorExternal(Operation, 2090, "COS09-VM1");
        SingleExecutorExternal(Operation, 2090, "COS09-VM2");
        SingleExecutorExternal(Operation, 2090, "COS09-VM3");
        SingleExecutorExternal(Operation, 2090, "COS09-VM4");

        SingleExecutorExternal(Operation, 20100, "COS10-VM1");
        SingleExecutorExternal(Operation, 20100, "COS10-VM2");
        SingleExecutorExternal(Operation, 20100, "COS10-VM3");
        SingleExecutorExternal(Operation, 20100, "COS10-VM4");

        SingleExecutorExternal(Operation, 20110, "COS11-VM1");
        SingleExecutorExternal(Operation, 20110, "COS11-VM2");
        SingleExecutorExternal(Operation, 20110, "COS11-VM3");
        SingleExecutorExternal(Operation, 20110, "COS11-VM4");

        SingleExecutorExternal(Operation, 20120, "COS12-VM1");
        SingleExecutorExternal(Operation, 20120, "COS12-VM2");
        SingleExecutorExternal(Operation, 20120, "COS12-VM3");
        SingleExecutorExternal(Operation, 20120, "COS12-VM4");

        SingleExecutorExternal(Operation, 20130, "COS13-VM1");
        SingleExecutorExternal(Operation, 20130, "COS13-VM2");
        SingleExecutorExternal(Operation, 20130, "COS13-VM3");
        SingleExecutorExternal(Operation, 20130, "COS13-VM4");

        SingleExecutorExternal(Operation, 20140, "COS14-VM1");
        SingleExecutorExternal(Operation, 20140, "COS14-VM2");
        SingleExecutorExternal(Operation, 20140, "COS14-VM3");
        SingleExecutorExternal(Operation, 20140, "COS14-VM4");

        SingleExecutorExternal(Operation, 20150, "COS15-VM1");
        SingleExecutorExternal(Operation, 20150, "COS15-VM2");
        SingleExecutorExternal(Operation, 20150, "COS15-VM3");
        SingleExecutorExternal(Operation, 20150, "COS15-VM4");

        SingleExecutorExternal(Operation, 20160, "COS16-VM1");
        SingleExecutorExternal(Operation, 20160, "COS16-VM2");
        SingleExecutorExternal(Operation, 20160, "COS16-VM3");
        SingleExecutorExternal(Operation, 20160, "COS16-VM4");

        SingleExecutorExternal(Operation, 20170, "COS17-VM1");
        SingleExecutorExternal(Operation, 20170, "COS17-VM2");
        SingleExecutorExternal(Operation, 20170, "COS17-VM3");
        SingleExecutorExternal(Operation, 20170, "COS17-VM4");

        SingleExecutorExternal(Operation, 20180, "COS18-VM1");
        SingleExecutorExternal(Operation, 20180, "COS18-VM2");
        SingleExecutorExternal(Operation, 20180, "COS18-VM3");
        SingleExecutorExternal(Operation, 20180, "COS18-VM4");

        SingleExecutorExternal(Operation, 20190, "COS19-VM1");
        SingleExecutorExternal(Operation, 20190, "COS19-VM2");
        SingleExecutorExternal(Operation, 20190, "COS19-VM3");
        SingleExecutorExternal(Operation, 20190, "COS19-VM4");/**/

        return 0;
    }

    public static int SecuredExecuteOnCosmos(String Operation) {

        SecuredSingleExecutorExternal(Operation, 2010, "COS01-VM1");
        SecuredSingleExecutorExternal(Operation, 2010, "COS01-VM2");
        SecuredSingleExecutorExternal(Operation, 2010, "COS01-VM3");
        SecuredSingleExecutorExternal(Operation, 2010, "COS01-VM4");

        SecuredSingleExecutorExternal(Operation, 2020, "COS02-VM1");
        SecuredSingleExecutorExternal(Operation, 2020, "COS02-VM2");
        SecuredSingleExecutorExternal(Operation, 2020, "COS02-VM3");
        SecuredSingleExecutorExternal(Operation, 2020, "COS02-VM4"); /* */

        SecuredSingleExecutorExternal(Operation, 2030, "COS03-VM1");
        SecuredSingleExecutorExternal(Operation, 2030, "COS03-VM2");
        SecuredSingleExecutorExternal(Operation, 2030, "COS03-VM3");
        SecuredSingleExecutorExternal(Operation, 2030, "COS03-VM4");

        SecuredSingleExecutorExternal(Operation, 2040, "COS04-VM1");
        SecuredSingleExecutorExternal(Operation, 2040, "COS04-VM2");
        SecuredSingleExecutorExternal(Operation, 2040, "COS04-VM3");
        SecuredSingleExecutorExternal(Operation, 2040, "COS04-VM4");

        SecuredSingleExecutorExternal(Operation, 2050, "COS05-VM1");
        SecuredSingleExecutorExternal(Operation, 2050, "COS05-VM2");
        SecuredSingleExecutorExternal(Operation, 2050, "COS05-VM3");
        SecuredSingleExecutorExternal(Operation, 2050, "COS05-VM4");

        SecuredSingleExecutorExternal(Operation, 2060, "COS06-VM1");
        SecuredSingleExecutorExternal(Operation, 2060, "COS06-VM2");
        SecuredSingleExecutorExternal(Operation, 2060, "COS06-VM3");
        SecuredSingleExecutorExternal(Operation, 2060, "COS06-VM4");

        SecuredSingleExecutorExternal(Operation, 2070, "COS07-VM1");
        SecuredSingleExecutorExternal(Operation, 2070, "COS07-VM2");
        SecuredSingleExecutorExternal(Operation, 2070, "COS07-VM3");
        SecuredSingleExecutorExternal(Operation, 2070, "COS07-VM4");

        SecuredSingleExecutorExternal(Operation, 2080, "COS08-VM1");
        SecuredSingleExecutorExternal(Operation, 2080, "COS08-VM2");
        SecuredSingleExecutorExternal(Operation, 2080, "COS08-VM3");
        SecuredSingleExecutorExternal(Operation, 2080, "COS08-VM4");

        SecuredSingleExecutorExternal(Operation, 2090, "COS09-VM1");
        SecuredSingleExecutorExternal(Operation, 2090, "COS09-VM2");
        SecuredSingleExecutorExternal(Operation, 2090, "COS09-VM3");
        SecuredSingleExecutorExternal(Operation, 2090, "COS09-VM4");

        SecuredSingleExecutorExternal(Operation, 20100, "COS10-VM1");
        SecuredSingleExecutorExternal(Operation, 20100, "COS10-VM2");
        SecuredSingleExecutorExternal(Operation, 20100, "COS10-VM3");
        SecuredSingleExecutorExternal(Operation, 20100, "COS10-VM4");

        SecuredSingleExecutorExternal(Operation, 20110, "COS11-VM1");
        SecuredSingleExecutorExternal(Operation, 20110, "COS11-VM2");
        SecuredSingleExecutorExternal(Operation, 20110, "COS11-VM3");
        SecuredSingleExecutorExternal(Operation, 20110, "COS11-VM4");

        SecuredSingleExecutorExternal(Operation, 20120, "COS12-VM1");
        SecuredSingleExecutorExternal(Operation, 20120, "COS12-VM2");
        SecuredSingleExecutorExternal(Operation, 20120, "COS12-VM3");
        SecuredSingleExecutorExternal(Operation, 20120, "COS12-VM4");

        SecuredSingleExecutorExternal(Operation, 20130, "COS13-VM1");
        SecuredSingleExecutorExternal(Operation, 20130, "COS13-VM2");
        SecuredSingleExecutorExternal(Operation, 20130, "COS13-VM3");
        SecuredSingleExecutorExternal(Operation, 20130, "COS13-VM4");

        SecuredSingleExecutorExternal(Operation, 20140, "COS14-VM1");
        SecuredSingleExecutorExternal(Operation, 20140, "COS14-VM2");
        SecuredSingleExecutorExternal(Operation, 20140, "COS14-VM3");
        SecuredSingleExecutorExternal(Operation, 20140, "COS14-VM4");

        SecuredSingleExecutorExternal(Operation, 20150, "COS15-VM1");
        SecuredSingleExecutorExternal(Operation, 20150, "COS15-VM2");
        SecuredSingleExecutorExternal(Operation, 20150, "COS15-VM3");
        SecuredSingleExecutorExternal(Operation, 20150, "COS15-VM4");

        SecuredSingleExecutorExternal(Operation, 20160, "COS16-VM1");
        SecuredSingleExecutorExternal(Operation, 20160, "COS16-VM2");
        SecuredSingleExecutorExternal(Operation, 20160, "COS16-VM3");
        SecuredSingleExecutorExternal(Operation, 20160, "COS16-VM4");

        SecuredSingleExecutorExternal(Operation, 20170, "COS17-VM1");
        SecuredSingleExecutorExternal(Operation, 20170, "COS17-VM2");
        SecuredSingleExecutorExternal(Operation, 20170, "COS17-VM3");
        SecuredSingleExecutorExternal(Operation, 20170, "COS17-VM4");

        SecuredSingleExecutorExternal(Operation, 20180, "COS18-VM1");
        SecuredSingleExecutorExternal(Operation, 20180, "COS18-VM2");
        SecuredSingleExecutorExternal(Operation, 20180, "COS18-VM3");
        SecuredSingleExecutorExternal(Operation, 20180, "COS18-VM4");

        SecuredSingleExecutorExternal(Operation, 20190, "COS19-VM1");
        SecuredSingleExecutorExternal(Operation, 20190, "COS19-VM2");
        SecuredSingleExecutorExternal(Operation, 20190, "COS19-VM3");
        SecuredSingleExecutorExternal(Operation, 20190, "COS19-VM4");

        return 0;
    }

    public static int ExecuteOnHalley(String Operation) throws IOException, SQLException {

        SingleExecutorExternal(Operation, 2210, "HAL01-VM1");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM2");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM3");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM4");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM5");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM6");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM7");
        SingleExecutorExternal(Operation, 2210, "HAL01-VM8");

        SingleExecutorExternal(Operation, 2220, "HAL02-VM1");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM2");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM3");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM4");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM5");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM6");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM7");
        SingleExecutorExternal(Operation, 2220, "HAL02-VM8");

        SingleExecutorExternal(Operation, 2230, "HAL03-VM1");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM2");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM3");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM4");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM5");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM6");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM7");
        SingleExecutorExternal(Operation, 2230, "HAL03-VM8");

        SingleExecutorExternal(Operation, 2240, "HAL04-VM1");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM2");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM3");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM4");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM5");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM6");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM7");
        SingleExecutorExternal(Operation, 2240, "HAL04-VM8");

        SingleExecutorExternal(Operation, 2250, "HAL05-VM1");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM2");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM3");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM4");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM5");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM6");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM7");
        SingleExecutorExternal(Operation, 2250, "HAL05-VM8");

        SingleExecutorExternal(Operation, 2260, "HAL06-VM1");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM2");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM3");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM4");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM5");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM6");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM7");
        SingleExecutorExternal(Operation, 2260, "HAL06-VM8");

        SingleExecutorExternal(Operation, 2270, "HAL07-VM1");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM2");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM3");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM4");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM5");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM6");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM7");
        SingleExecutorExternal(Operation, 2270, "HAL07-VM8");

        SingleExecutorExternal(Operation, 2280, "HAL08-VM1");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM2");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM3");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM4");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM5");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM6");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM7");
        SingleExecutorExternal(Operation, 2280, "HAL08-VM8");

        SingleExecutorExternal(Operation, 2290, "HAL09-VM1");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM2");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM3");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM4");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM5");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM6");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM7");
        SingleExecutorExternal(Operation, 2290, "HAL09-VM8");

        SingleExecutorExternal(Operation, 22100, "HAL10-VM1");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM2");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM3");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM4");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM5");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM6");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM7");
        SingleExecutorExternal(Operation, 22100, "HAL10-VM8");

        SingleExecutorExternal(Operation, 22110, "HAL11-VM1");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM2");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM3");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM4");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM5");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM6");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM7");
        SingleExecutorExternal(Operation, 22110, "HAL11-VM8");

        SingleExecutorExternal(Operation, 22120, "HAL12-VM1");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM2");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM3");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM4");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM5");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM6");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM7");
        SingleExecutorExternal(Operation, 22120, "HAL12-VM8");

        SingleExecutorExternal(Operation, 22130, "HAL13-VM1");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM2");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM3");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM4");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM5");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM6");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM7");
        SingleExecutorExternal(Operation, 22130, "HAL13-VM8");


        return 0;
    }

    public static int SecuredExecuteOnHalley(String Operation) {

        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM1");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM2");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM3");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM4");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM5");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM6");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM7");
        SecuredSingleExecutorExternal(Operation, 2210, "HAL01-VM8");

        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM1");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM2");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM3");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM4");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM5");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM6");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM7");
        SecuredSingleExecutorExternal(Operation, 2220, "HAL02-VM8");

        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM1");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM2");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM3");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM4");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM5");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM6");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM7");
        SecuredSingleExecutorExternal(Operation, 2230, "HAL03-VM8");

        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM1");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM2");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM3");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM4");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM5");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM6");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM7");
        SecuredSingleExecutorExternal(Operation, 2240, "HAL04-VM8");

        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM1");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM2");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM3");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM4");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM5");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM6");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM7");
        SecuredSingleExecutorExternal(Operation, 2250, "HAL05-VM8");

        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM1");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM2");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM3");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM4");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM5");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM6");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM7");
        SecuredSingleExecutorExternal(Operation, 2260, "HAL06-VM8");

        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM1");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM2");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM3");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM4");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM5");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM6");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM7");
        SecuredSingleExecutorExternal(Operation, 2270, "HAL07-VM8");

        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM1");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM2");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM3");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM4");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM5");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM6");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM7");
        SecuredSingleExecutorExternal(Operation, 2280, "HAL08-VM8");

        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM1");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM2");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM3");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM4");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM5");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM6");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM7");
        SecuredSingleExecutorExternal(Operation, 2290, "HAL09-VM8");

        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM1");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM2");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM3");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM4");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM5");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM6");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM7");
        SecuredSingleExecutorExternal(Operation, 22100, "HAL10-VM8");

        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM1");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM2");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM3");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM4");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM5");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM6");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM7");
        SecuredSingleExecutorExternal(Operation, 22110, "HAL11-VM8");

        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM1");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM2");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM3");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM4");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM5");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM6");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM7");
        SecuredSingleExecutorExternal(Operation, 22120, "HAL12-VM8");

        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM1");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM2");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM3");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM4");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM5");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM6");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM7");
        SecuredSingleExecutorExternal(Operation, 22130, "HAL13-VM8");/* */


        return 0;

    }

    public static int ExecuteOnAndromeda(String Operation) throws IOException, SQLException {


        SingleExecutorExternal(Operation, 2110, "AND01-VM1");
        SingleExecutorExternal(Operation, 2110, "AND01-VM2");
        SingleExecutorExternal(Operation, 2110, "AND01-VM3");
        SingleExecutorExternal(Operation, 2110, "AND01-VM4");
        SingleExecutorExternal(Operation, 2110, "AND01-VM5");
        SingleExecutorExternal(Operation, 2110, "AND01-VM6");
        SingleExecutorExternal(Operation, 2110, "AND01-VM7");
        SingleExecutorExternal(Operation, 2110, "AND01-VM8");

        SingleExecutorExternal(Operation, 2120, "AND02-VM1");
        SingleExecutorExternal(Operation, 2120, "AND02-VM2");
        SingleExecutorExternal(Operation, 2120, "AND02-VM3");
        SingleExecutorExternal(Operation, 2120, "AND02-VM4");
        SingleExecutorExternal(Operation, 2120, "AND02-VM5");
        SingleExecutorExternal(Operation, 2120, "AND02-VM6");
        SingleExecutorExternal(Operation, 2120, "AND02-VM7");
        SingleExecutorExternal(Operation, 2120, "AND02-VM8");

        SingleExecutorExternal(Operation, 2130, "AND03-VM1");
        SingleExecutorExternal(Operation, 2130, "AND03-VM2");
        SingleExecutorExternal(Operation, 2130, "AND03-VM3");
        SingleExecutorExternal(Operation, 2130, "AND03-VM4");
        SingleExecutorExternal(Operation, 2130, "AND03-VM5");
        SingleExecutorExternal(Operation, 2130, "AND03-VM6");
        SingleExecutorExternal(Operation, 2130, "AND03-VM7");
        SingleExecutorExternal(Operation, 2130, "AND03-VM8");

        SingleExecutorExternal(Operation, 2140, "AND04-VM1");
        SingleExecutorExternal(Operation, 2140, "AND04-VM2");
        SingleExecutorExternal(Operation, 2140, "AND04-VM3");
        SingleExecutorExternal(Operation, 2140, "AND04-VM4");
        SingleExecutorExternal(Operation, 2140, "AND04-VM5");
        SingleExecutorExternal(Operation, 2140, "AND04-VM6");
        SingleExecutorExternal(Operation, 2140, "AND04-VM7");
        SingleExecutorExternal(Operation, 2140, "AND04-VM8");

      /*  SingleExecutorExternal(Operation, 2150, "AND05-VM1");
        SingleExecutorExternal(Operation, 2150, "AND05-VM2");
        SingleExecutorExternal(Operation, 2150, "AND05-VM3");
        SingleExecutorExternal(Operation, 2150, "AND05-VM4");
        SingleExecutorExternal(Operation, 2150, "AND05-VM5");
        SingleExecutorExternal(Operation, 2150, "AND05-VM6");
        SingleExecutorExternal(Operation, 2150, "AND05-VM7");
        SingleExecutorExternal(Operation, 2150, "AND05-VM8");

        SingleExecutorExternal(Operation, 2160, "AND06-VM1");
        SingleExecutorExternal(Operation, 2160, "AND06-VM2");
        SingleExecutorExternal(Operation, 2160, "AND06-VM3");
        SingleExecutorExternal(Operation, 2160, "AND06-VM4");
        SingleExecutorExternal(Operation, 2160, "AND06-VM5");
        SingleExecutorExternal(Operation, 2160, "AND06-VM6");
        SingleExecutorExternal(Operation, 2160, "AND06-VM7");
        SingleExecutorExternal(Operation, 2160, "AND06-VM8"); */

        SingleExecutorExternal(Operation, 2170, "AND07-VM1");
        SingleExecutorExternal(Operation, 2170, "AND07-VM2");
        SingleExecutorExternal(Operation, 2170, "AND07-VM3");
        SingleExecutorExternal(Operation, 2170, "AND07-VM4");
        SingleExecutorExternal(Operation, 2170, "AND07-VM5");
        SingleExecutorExternal(Operation, 2170, "AND07-VM6");
        SingleExecutorExternal(Operation, 2170, "AND07-VM7");
        SingleExecutorExternal(Operation, 2170, "AND07-VM8");

        SingleExecutorExternal(Operation, 2180, "AND08-VM1");
        SingleExecutorExternal(Operation, 2180, "AND08-VM2");
        SingleExecutorExternal(Operation, 2180, "AND08-VM3");
        SingleExecutorExternal(Operation, 2180, "AND08-VM4");
        SingleExecutorExternal(Operation, 2180, "AND08-VM5");
        SingleExecutorExternal(Operation, 2180, "AND08-VM6");
        SingleExecutorExternal(Operation, 2180, "AND08-VM7");
        SingleExecutorExternal(Operation, 2180, "AND08-VM8");

        SingleExecutorExternal(Operation, 2190, "AND09-VM1");
        SingleExecutorExternal(Operation, 2190, "AND09-VM2");
        SingleExecutorExternal(Operation, 2190, "AND09-VM3");
        SingleExecutorExternal(Operation, 2190, "AND09-VM4");
        SingleExecutorExternal(Operation, 2190, "AND09-VM5");
        SingleExecutorExternal(Operation, 2190, "AND09-VM6");
        SingleExecutorExternal(Operation, 2190, "AND09-VM7");
        SingleExecutorExternal(Operation, 2190, "AND09-VM8");/**/

        SingleExecutorExternal(Operation, 21100, "AND10-VM1");
        SingleExecutorExternal(Operation, 21100, "AND10-VM2");
        SingleExecutorExternal(Operation, 21100, "AND10-VM3");
        SingleExecutorExternal(Operation, 21100, "AND10-VM4");
        SingleExecutorExternal(Operation, 21100, "AND10-VM5");
        SingleExecutorExternal(Operation, 21100, "AND10-VM6");
        SingleExecutorExternal(Operation, 21100, "AND10-VM7");
        SingleExecutorExternal(Operation, 21100, "AND10-VM8");

        SingleExecutorExternal(Operation, 21110, "AND11-VM1");
        SingleExecutorExternal(Operation, 21110, "AND11-VM2");
        SingleExecutorExternal(Operation, 21110, "AND11-VM3");
        SingleExecutorExternal(Operation, 21110, "AND11-VM4");
        SingleExecutorExternal(Operation, 21110, "AND11-VM5");
        SingleExecutorExternal(Operation, 21110, "AND11-VM6");
        SingleExecutorExternal(Operation, 21110, "AND11-VM7");
        SingleExecutorExternal(Operation, 21110, "AND11-VM8");

        SingleExecutorExternal(Operation, 21120, "AND12-VM1");
        SingleExecutorExternal(Operation, 21120, "AND12-VM2");
        SingleExecutorExternal(Operation, 21120, "AND12-VM3");
        SingleExecutorExternal(Operation, 21120, "AND12-VM4");
        SingleExecutorExternal(Operation, 21120, "AND12-VM5");
        SingleExecutorExternal(Operation, 21120, "AND12-VM6");
        SingleExecutorExternal(Operation, 21120, "AND12-VM7");
        SingleExecutorExternal(Operation, 21120, "AND12-VM8");

        return 0;
    }

    public static int SecuredExecuteOnAndromeda(String Operation) {


        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM1");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM2");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM3");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM4");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM5");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM6");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM7");
        SecuredSingleExecutorExternal(Operation, 2110, "AND01-VM8");

        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM1");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM2");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM3");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM4");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM5");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM6");
        SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM7");
      //  SecuredSingleExecutorExternal(Operation, 2120, "AND02-VM8");

        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM1");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM2");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM3");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM4");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM5");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM6");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM7");
        SecuredSingleExecutorExternal(Operation, 2130, "AND03-VM8");

        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM1");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM2");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM3");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM4");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM5");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM6");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM7");
        SecuredSingleExecutorExternal(Operation, 2140, "AND04-VM8");

        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM1");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM2");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM3");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM4");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM5");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM6");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM7");
        SecuredSingleExecutorExternal(Operation, 2150, "AND05-VM8");

        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM1");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM2");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM3");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM4");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM5");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM6");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM7");
        SecuredSingleExecutorExternal(Operation, 2160, "AND06-VM8");

        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM1");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM2");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM3");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM4");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM5");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM6");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM7");
        SecuredSingleExecutorExternal(Operation, 2170, "AND07-VM8");

        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM1");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM2");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM3");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM4");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM5");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM6");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM7");
        SecuredSingleExecutorExternal(Operation, 2180, "AND08-VM8");

        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM1");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM2");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM3");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM4");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM5");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM6");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM7");
        SecuredSingleExecutorExternal(Operation, 2190, "AND09-VM8");/**/

        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM1");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM2");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM3");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM4");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM5");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM6");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM7");
        SecuredSingleExecutorExternal(Operation, 21100, "AND10-VM8");

        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM1");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM2");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM3");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM4");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM5");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM6");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM7");
        SecuredSingleExecutorExternal(Operation, 21110, "AND11-VM8");

        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM1");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM2");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM3");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM4");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM5");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM6");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM7");
        SecuredSingleExecutorExternal(Operation, 21120, "AND12-VM8");

        return 0;
    }


}
