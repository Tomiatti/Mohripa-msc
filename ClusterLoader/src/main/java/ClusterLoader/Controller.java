package ClusterLoader;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ClusterLoader.Services.*;


import java.io.IOException;
import java.sql.SQLException;

@RestController
public class Controller {
    static Logger log = Logger.getLogger(new Object() { }.getClass().getEnclosingClass());

    @RequestMapping("/")
    public String index() {
        return "Congratulations this is Tomiatti Cluster Loader";
    }

    @RequestMapping("/helloCostumer")
    public String hello() {
        return "Olá cliente aceita uma chicara de cafe?";
    }

    @RequestMapping("/memorybound")
    public String memory() throws IOException, SQLException {

        new MemoryBound().fibonacci();
        log.info("someone execute a motherfucking fibonacci sequence");

        return "you execute a motherfucking fibonacci sequence";
    }

    @RequestMapping("/cpubound")
    public String cpu() throws IOException, SQLException {

        new cpuBound().matrizmultiplication();
        log.info("someone execute a motherfucking matrix multiplication sequence");

        return "you execute a motherfucking matrix multiplication sequence";
    }

    @RequestMapping("/hybridbound")
    public String hybrid() throws IOException, SQLException {

        new HybridBound().fibonacciInsert();
        log.info("someone execute a motherfucking ordened fibonacci sequence");

        return "you execute a motherfucking ordened fibonacci";
    }

}
