package Alocador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManipulator {
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src/main/resources/ssh.properties");
        props.load(file);
        return props;
    }

    public static String getLogin() throws IOException{
        Properties prop = getProp();
        String login;
        login = prop.getProperty("prop.server.login");
       return login;
    }

    public static String getPassword() throws IOException{
        Properties prop = getProp();
        String password;
        password = prop.getProperty("prop.server.password");
        return password;
    }

    public static Properties getProphost() throws IOException {
        Properties provider = new Properties();
        FileInputStream file = new FileInputStream(
                "src/main/resources/providers.properties");
        provider.load(file);
        return provider;
    }

    public static String getHost() throws IOException{
        Properties prop = getProphost();
        String hostname = prop.getProperty("prop.provider.principal");
        //System.out.print( hostname );
        //String hostname = "cosmos";
        String host = prop.getProperty("prop."+hostname+".provider");
        return host;
    }

    public static void main(String[] args) {
        try {
            getHost();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
