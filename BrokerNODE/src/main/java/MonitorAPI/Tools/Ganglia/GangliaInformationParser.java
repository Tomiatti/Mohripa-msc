/*
 * - All modification in this code must be documented and the author of the modifications prints your name
 * - It is also important to make a Changelog of all modifications below of this description
 * - For each modification, please change the version number incrementing it in .1
 */

/**
 * CHANGELOG 
 * 
 * DATE: DAY/MONTH/YEAR
 * LIST OF MODIFICATIONS
 * --------------------
 * 
 * 
 * 
 * --------------------
 * 
 */

package MonitorAPI.Tools.Ganglia;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

/**
 * This class was made for helping parser information from Ganglia monitoring system
 * @author Julio Cezar Estrell and Thiago Caproni Tavares
 * @version 1.0
 */
public class GangliaInformationParser {

    public static final int TotalRESOURCES = 2;
    public static final int CPU = 0;
    public static final int MEM = 1;
    public static final int NET = 2;

    private Document doc = null;

    /**
     * Collects and makes a parser of all information from Ganglia monitoring system
     */
    public GangliaInformationParser() {
       
    }

    /**
     * Makes the connection with the Gmetad port in the Ganglia monitoring system
     * @param ip IP from the host monitored
     * @param port Port which stores all information of the host collected by the Ganglia
     * @throws UnknownHostException Exception generated if an unknown host is used
     * @throws IOException Exception generated if an i/o exception error occurred
     * @throws SAXException Exception generated if a SAX exception error occurred
     */
    public void Connect(String ip, int port) throws UnknownHostException, IOException, SAXException {
         Socket socket = new Socket(ip, port);
        DOMParser parser = new  DOMParser();
        parser.parse(new InputSource(socket.getInputStream()));
        this.doc = parser.getDocument();
    }

    /**
     * 
     * @param host Hostname monitored
     * @param metric Metric used
     * @param value Value of the metric
     */
    private void setValuesToMetrics(GangliaHost host, String metric, String value) {
        if (metric.compareTo("load_one") == 0) {
            host.setLoadOne(Float.parseFloat(value));
        } else if (metric.compareTo("mem_total") == 0) {
            host.setMemTotal(Float.parseFloat(value));
        } else if (metric.compareTo("os_release") == 0) {
            host.setOsRelease(value);
        } else if (metric.compareTo("proc_run") == 0) {
            host.setProcRun(Integer.parseInt(value));
        } else if (metric.compareTo("load_five") == 0) {
            host.setLoadFive(Float.parseFloat(value));
        } else if (metric.compareTo("gexec") == 0) {
            host.setGexec(value);
        } else if (metric.compareTo("disk_free") == 0) {
            host.setDiskFree(Double.parseDouble(value));
        } else if (metric.compareTo("mem_cached") == 0) {
            host.setMemCached(Float.parseFloat(value));
        } else if (metric.compareTo("pkts_in") == 0) {
            host.setPktsIn(Float.parseFloat(value));
        } else if (metric.compareTo("bytes_in") == 0) {
            host.setBytesIn(Float.parseFloat(value));
        } else if (metric.compareTo("bytes_out") == 0) {
            host.setBytesOut(Float.parseFloat(value));
        } else if (metric.compareTo("swap_total") == 0) {
            host.setSwapTotal(Float.parseFloat(value));
        } else if (metric.compareTo("mem_free") == 0) {
            host.setMemFree(Float.parseFloat(value));
        } else if (metric.compareTo("load_fifteen") == 0) {
            host.setLoadFifteen(Float.parseFloat(value));
        } else if (metric.compareTo("os_name") == 0) {
            host.setOsName(value);
        } else if (metric.compareTo("boottime") == 0) {
            host.setBoottime(Integer.parseInt(value));
        } else if (metric.compareTo("cpu_idle") == 0) {
            host.setCpuIdle(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_top") == 0) {
            host.setCpuTop(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_user") == 0) {
            host.setCpuUser(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_nice") == 0) {
            host.setCpuNice(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_aidle") == 0) {
            host.setCpuAidle(Float.parseFloat(value));
        } else if (metric.compareTo("mem_buffers") == 0) {
            host.setMemBuffers(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_system") == 0) {
            host.setCpuSystem(Float.parseFloat(value));
        } else if (metric.compareTo("part_max_used") == 0) {
            host.setPartMaxUsed(Float.parseFloat(value));
        } else if (metric.compareTo("disk_total") == 0) {
            host.setDiskTotal(Double.parseDouble(value));
        } else if (metric.compareTo("mem_shared") == 0) {
            host.setMemShared(Float.parseFloat(value));
        } else if (metric.compareTo("cpu_wio") == 0) {
            host.setCpuWio(Float.parseFloat(value));
        } else if (metric.compareTo("machine_type") == 0) {
            host.setMachineType(value);
        } else if (metric.compareTo("proc_total") == 0) {
            host.setProcTotal(Integer.parseInt(value));
        } else if (metric.compareTo("cpu_num") == 0) {
            host.setCpuNum(Integer.parseInt(value));
        } else if (metric.compareTo("cpu_speed") == 0) {
            host.setCpuSpeed(Integer.parseInt(value));
        } else if (metric.compareTo("pkts_out") == 0) {
            host.setPktsOut(Float.parseFloat(value));
        } else if (metric.compareTo("swap_free") == 0) {
            host.setSwapFree(Float.parseFloat(value));
        }
    }

    /**
     * Extracts all metrics collect from the Ganglia monitoring system
     * @param host Host monitored
     * @param list List of metrics used
     */
    private void extractMetrics(GangliaHost host, NodeList list) {
        NamedNodeMap attributes;
        String metric, value;
        for (int i = 0; i < list.getLength(); i++) {
            if (list.item(i).getNodeName().compareTo("METRIC") == 0) {
                if (list.item(i).hasAttributes()) {
                    attributes = list.item(i).getAttributes();
                    metric = attributes.getNamedItem("NAME").getNodeValue();
                    value = attributes.getNamedItem("VAL").getNodeValue();
                    this.setValuesToMetrics(host, metric, value);
                }
            }
        }
    }
    
    /**
     * Makes a hashmap of the information collected from the host
     * @return Returns a hashmap of all information of the host monitored
     */
    public HashMap<String, GangliaHost> getHostsInformation() {
        HashMap<String, GangliaHost> hosts = new HashMap<String, GangliaHost>();

        // Getting host elements
        NodeList nodes = this.doc.getElementsByTagName("HOST");

        for (int i = 0; i < nodes.getLength(); i++) {
            GangliaHost host = new GangliaHost();

            // Setting host properties
            NamedNodeMap map = nodes.item(i).getAttributes();
            host.setName(map.getNamedItem("NAME").getNodeValue());
            host.setIP(map.getNamedItem("IP").getNodeValue());
            host.setHeartBeat(Long.parseLong(map.getNamedItem("TN").getNodeValue()));

            // Setting metrics to host
            this.extractMetrics(host, nodes.item(i).getChildNodes());

            hosts.put(host.getIP(), host);
        }
        return hosts;
    }    
}
