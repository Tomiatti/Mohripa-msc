package LogServer;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropAutomation {

    public static Properties getPropClass() throws IOException {
        Properties props = new Properties(); /* Cria um novo conceito de arquivos de propriedades*/
        // String type= "external";
        String type= "internal";

        if(type == "external"){
            FileInputStream file = new FileInputStream(
                    "src/main/resources/DBexternal.properties"); /* realiza uma leitura da entrada do arquivo de propriedades do log timer*/
            props.load(file); /* carrega essas propriedades no conceito das propriedades*/
        }

        if(type == "internal"){
            FileInputStream file = new FileInputStream(
                    "src/main/resources/DBinfo.properties"); /* realiza uma leitura da entrada do arquivo de propriedades do log timer*/
            props.load(file); /* carrega essas propriedades no conceito das propriedades*/
        }

        return props; /* Retorna propriedades*/
    }

    public static String getdbport(String db) throws IOException {
        Properties prop = getPropClass(); /* Recupera as propriedades de classe do arquivo de propriedades*/
        //System.out.print( classname );
        String Port = prop.getProperty("prop." + db + ".Port"); /*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );
        return Port; /* Retorna a permissão que esta dentro da propriedade invocada*/
    }

    public static String getdbAdress(String db) throws IOException {
        Properties prop = getPropClass(); /* Recupera as propriedades de classe do arquivo de propriedades*/
        //System.out.print( classname );
        String Port = prop.getProperty("prop."+db+".Address"); /*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );
        return Port; /* Retorna a permissão que esta dentro da propriedade invocada*/
    }

    public static String getdblogin(String db) throws IOException {
        //Properties prop = getPropClass(); /* Recupera as propriedades de classe do arquivo de propriedades*/
        //System.out.print( classname );
        String user = getPropClass().getProperty("prop.Username."+ db); /*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );
        return user; /* Retorna a permissão que esta dentro da propriedade invocada*/
    }

    public static String getdbpassword(String db) throws IOException {
        Properties prop = getPropClass(); /* Recupera as propriedades de classe do arquivo de propriedades*/
        //System.out.print( classname );
        String passwd = prop.getProperty("prop.password." + db);/*pega informação do arquivo de propriedade*/
        //System.out.print( Permission );
        return getPropClass().getProperty("prop.password." + db); /* Retorna a permissão que esta dentro da propriedade invocada*/
    }


    public static void main(String[] args) throws IOException {
        System.out.println("logserver login "+ getdblogin("logserver"));
        System.out.println("logserver passwd "+ getdbpassword("logserver"));
        System.out.println("logserver port "+ getdbport("logserver"));
        System.out.println("logserver adress "+ getdbAdress("logserver"));

        System.out.println("monitor login "+ getdblogin("monitorAPI"));
        System.out.println("monitor passwd "+ getdbpassword("monitorAPI"));
        System.out.println("monitor port "+ getdbport("monitorAPI"));
        System.out.println("monitor adress "+ getdbAdress("monitorAPI"));

    }

}

