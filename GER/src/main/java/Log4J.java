import org.apache.log4j.Logger;

public class Log4J {

    static Logger log = Logger.getLogger(new Object() { }.getClass().getEnclosingClass());
    public static void main(String[] args)
    {


        log.debug("Sample debug message");
        log.info("Sample info message");
        log.error("Sample error message");
        log.fatal("Sample fatal message");
    }

}
