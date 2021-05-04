package DecisionMaker.Resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class vmStats implements Serializable {

    public static String  Hostname;
    public static Float  ID_calc;
    public static Float  ID_cpu;
    public static Float  ID_mem;
    public static String Whenhappen;

    public vmStats(String hostname, float ID_calc, float ID_cpu, float ID_mem, String whenhappen) {
        this.Hostname = hostname;
        this.ID_calc = ID_calc;
        this.ID_cpu = ID_cpu;
        this.ID_mem = ID_mem;
        this.Whenhappen = whenhappen;
    }

    public vmStats() {

    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        this.Hostname = hostname;
    }

    public Float getID_calc() {
        return ID_calc;
    }

    public void setID_calc(float ID_calc) {
        this.ID_calc = ID_calc;
    }

    public Float getID_cpu() {
        return ID_cpu;
    }

    public void setID_cpu(float ID_cpu) {
        this.ID_cpu = ID_cpu;
    }

    public Float getID_mem() {
        return ID_mem;
    }

    public void setID_mem(float ID_mem) {
        this.ID_mem = ID_mem;
    }

    public String getWhenhappen() {
        return Whenhappen;
    }

    public void setWhenhappen(String whenhappen) {
        this.Whenhappen = whenhappen;
    }


    public String toString() {
        return "vmStats [Hostname=" + Hostname + ", ID_calc=" + ID_calc + ",ID_cpu=" + ID_cpu + ", ID_mem=" + ID_mem + ", Whenhappen=" + Whenhappen +  "]";
    }

    private List <vmStats> vmStatsList;

    public List<vmStats> getVmStatsList() {
        if(vmStatsList == null) {
            vmStatsList = new ArrayList <>();
        }
        return vmStatsList;
    }

    public void setVmStatsList(List<vmStats> vmStatsList) {
        this.vmStatsList = vmStatsList;
    }



}
