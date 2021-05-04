package MonitorAPI.LogServer;

import java.io.IOException;

public class TimeCalculator {

    public static long GetTimerClass(long start, long end, String classname) throws IOException {
        long TookTime = 0; /*Inicia variavel com tempo 0, antes de realizar o calculo*/

        PermissionLogger pl = new PermissionLogger(); /*Invoca classe de permissão*/
        String properties = pl.getpermissionClass(classname); /*passa classe de contexto atual para verificar permissão*/
        if (properties.contains("ENABLE")) /*Se o arquivo de propriedade apontar que aquele atributo tem ENABLE, realiza o calculo do tempo*/
            /*Calculo de tempo*/
            TookTime = (end - start) / 1000000;
        /*Fim do calculo de tempo*/

        return TookTime;
    }


    public static long GetTimerMethod(long start, long end, String Method) throws IOException {
        long TookTime = 0; /*Inicia variavel com tempo 0, antes de realizar o calculo*/

        PermissionLogger pl = new PermissionLogger(); /*Invoca classe de permissão*/
        String properties = pl.getpermissionMethod(Method); /*passa classe de contexto atual para verificar permissão*/
        if (properties.contains("ENABLE")) /*Se o arquivo de propriedade apontar que aquele atributo tem ENABLE, realiza o calculo do tempo*/
            /*Calculo de tempo*/
            TookTime = (end - start) / 1000000;
        /*Fim do calculo de tempo*/
        return TookTime;
    }

    public static long GetTookTime(long start, long end) throws IOException {
        long TookTime = 0; /*Inicia variavel com tempo 0, antes de realizar o calculo*/

        TookTime = (end - start) / 1000000;

        return TookTime;
    }


}
