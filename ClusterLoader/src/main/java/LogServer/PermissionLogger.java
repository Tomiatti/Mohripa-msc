package LogServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PermissionLogger {

    public static Properties getPropClass() throws IOException {
        Properties props = new Properties(); /* Cria um novo conceito de arquivos de propriedades*/
        FileInputStream file = new FileInputStream(
                "src/main/resources/LogTimerClass.Properties"); /* realiza uma leitura da entrada do arquivo de propriedades do log timer*/
        props.load(file); /* carrega essas propriedades no conceito das propriedades*/

        return props; /* Retorna propriedades*/
    }

    public static String getpermissionClass(String classname) throws IOException {
        Properties prop = getPropClass(); /* Recupera as propriedades de classe do arquivo de propriedades*/
        //System.out.print( classname );
        String Permission = prop.getProperty("prop." + classname + ".GetTime"); /*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );
        return Permission; /* Retorna a permissão que esta dentro da propriedade invocada*/
    }


    public static Properties getPropMethod() throws IOException {
        Properties props = new Properties(); /* Cria um novo conceito de arquivos de propriedades*/
        FileInputStream file = new FileInputStream(
                "src/main/resources/LogTimerMethod.Properties");/* realiza uma leitura da entrada do arquivo de propriedades do log timer*/
        props.load(file); /* carrega essas propriedades no conceito das propriedades*/

        return props; /* Retorna propriedades*/
    }

    public static String getpermissionMethod(String Method) throws IOException {
        Properties prop = getPropMethod(); /* Recupera as propriedades de metodo do arquivo de propriedades*/
        //System.out.print( Method );
        String Permission = prop.getProperty("prop." + Method + ".GetTime"); /*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );

        return Permission; /* Retorna a permissão que esta dentro da propriedade invocada*/
    }

}



 /*  public static String getpermissionToStart(String classname) throws IOException{
        Properties prop = getProp();
       // classname = "";
        //System.out.print( classname );
        String Permission;
        Permission = prop.getProperty("prop."+classname+".GetTime");
        //System.out.print( Permission );
        return Permission;
    }

    public static String getpermissionToEnd(String classname) throws IOException{
        Properties prop = getProp();
        // classname = "";
        //System.out.print( classname );
        String Permission;
        Permission = prop.getProperty("prop."+classname+".GetTime");
        //System.out.print( Permission );
        return Permission;
    }*/
