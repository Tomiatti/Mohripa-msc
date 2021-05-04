package Alocador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetVirtualProps {

    public static Properties getPropClass() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src/main/resources/virtualcommands.properties");
        props.load(file);
        return props;

    }

    public static String getVirtualOperation(String tool, String operation) throws IOException {
        Properties prop = getPropClass();
        // System.out.print( tool );
        String Operation = prop.getProperty("prop.virtualization." + tool + "." + operation);
        //System.out.print( Permission );
        return Operation;
    }

}
