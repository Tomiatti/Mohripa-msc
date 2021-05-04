package DecisionMaker.AutorityModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PoliticPermission {

    public static Properties getPropClass() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "src/main/resources/decisionpermission.properties");
        props.load(file);
        return props;

    }

    public static String getpermissionClass(String classname) throws IOException{
        Properties prop = getPropClass();
        //System.out.print( classname );
        String Permission;
        Permission = prop.getProperty("prop."+classname+".politic");
        //System.out.print( Permission );
        return Permission;
    }


}
