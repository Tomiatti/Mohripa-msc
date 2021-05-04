package Alocador;

import java.io.IOException;
import java.util.Properties;

public class MethodsOperationCall {

    public static String  resumeCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".resume");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  pauseCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".pause");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  dominfoCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".dominfo");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  destroyCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".destroy");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  deleteCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".delete");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  restartCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".restart");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  shutdownCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".shutdown");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  startCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".start");
        // System.out.print( Comannd );

        return Comannd;
    }

    public static String  stopCall() throws IOException {
        GetVirtualProps gvp = new GetVirtualProps();
        Properties prop = gvp.getPropClass();

        String tool = prop.getProperty( "prop.virtualization.principal" );
        // System.out.print( tool );

        String Comannd = prop.getProperty( "prop.virtualization."+ tool +".stop");
        // System.out.print( Comannd );

        return Comannd;
    }

}
