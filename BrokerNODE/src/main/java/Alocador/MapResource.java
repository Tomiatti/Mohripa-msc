package Alocador;

import java.util.HashMap;
import java.util.Map;

public class MapResource {

    public Map <String, String> MapResource() {
        Map <String, String> map = new HashMap <String, String>();

        // String PrincipalMap = "cosmos";

        //  String PrincipalMap = "andromeda";

        //    String PrincipalMap = "halley";

        // String PrincipalMap ="all";

         String PrincipalMap ="experiment";

if(PrincipalMap == "experiment"){
    map.put("HalleyPort1", "2210");
    map.put("HalleyPort2", "2220");
          /*  map.put("HalleyPort3", "2230");
            map.put("HalleyPort4", "2240");
            map.put("HalleyPort5", "2250");  */
    map.put("HalleyPort6", "2260");
   // map.put("HalleyPort7", "2270");
    map.put("HalleyPort8", "2280");
    map.put("HalleyPort9", "2290");
    map.put("HalleyPort10", "22100");
    map.put("HalleyPort11", "22110");
    map.put("HalleyPort12", "22120");
    map.put("HalleyPort13", "22130");
    map.put("AndromedaPort1", "2110");
    map.put("AndromedaPort2", "2120");
    map.put("AndromedaPort3", "2130");
    map.put("AndromedaPort4", "2140");
}

        if (PrincipalMap == "cosmos") {

            map.put("CosmosPort1", "2010");
            map.put("CosmosPort2", "2020");
            map.put("CosmosPort3", "2030");
            map.put("CosmosPort4", "2040");
            map.put("CosmosPort5", "2050");
            map.put("CosmosPort6", "2060");
            map.put("CosmosPort7", "2070");
            map.put("CosmosPort8", "2080");
            map.put("CosmosPort9", "2090");
            map.put("CosmosPort10", "20100");
            map.put("CosmosPort11", "20110");
            map.put("CosmosPort12", "20120");
            map.put("CosmosPort13", "20130");
            map.put("CosmosPort14", "20140"); // falta essa
            map.put("CosmosPort15", "20150");
            map.put("CosmosPort16", "20160");
            map.put("CosmosPort17", "20170");
            map.put("CosmosPort18", "20180");
            map.put("CosmosPort19", "20190");

        }

        if (PrincipalMap == "andromeda") {
            map.put("AndromedaPort1", "2110");
            map.put("AndromedaPort2", "2120");
            map.put("AndromedaPort3", "2130");
            map.put("AndromedaPort4", "2140");
            map.put("AndromedaPort5", "2150");
            map.put("AndromedaPort6", "2160");
            map.put("AndromedaPort7", "2170");
            map.put("AndromedaPort8", "2180");
            map.put("AndromedaPort9", "2190");
            map.put("AndromedaPort10", "21100");
            map.put("AndromedaPort11", "21110");
            map.put("AndromedaPort12", "21120");

        }

        if (PrincipalMap == "halley") {
            map.put("HalleyPort1", "2210");
            map.put("HalleyPort2", "2220");
          /*  map.put("HalleyPort3", "2230");
            map.put("HalleyPort4", "2240");
            map.put("HalleyPort5", "2250");  */
            map.put("HalleyPort6", "2260");
            map.put("HalleyPort7", "2270");
            map.put("HalleyPort8", "2280");
            map.put("HalleyPort9", "2290");
            map.put("HalleyPort10", "22100");
            map.put("HalleyPort11", "22110");
            map.put("HalleyPort12", "22120");
            map.put("HalleyPort13", "22130");

        }

        if (PrincipalMap == "all") {
         /*   map.put("CosmosPort1", "2010");
            map.put("CosmosPort2", "2020");
            map.put("CosmosPort3", "2030");
            map.put("CosmosPort4", "2040");
            map.put("CosmosPort5", "2050");
            map.put("CosmosPort6", "2060");
            map.put("CosmosPort7", "2070");
            map.put("CosmosPort8", "2080");
            map.put("CosmosPort9", "2090");
            map.put("CosmosPort10", "20100");
            map.put("CosmosPort11", "20110");
            map.put("CosmosPort12", "20120");
            map.put("CosmosPort13", "20130");
            map.put("CosmosPort14", "20140"); // falta essa
            map.put("CosmosPort15", "20150");
            map.put("CosmosPort16", "20160");
            map.put("CosmosPort17", "20170");
            map.put("CosmosPort18", "20180");
            map.put("CosmosPort19", "20190"); */
            map.put("AndromedaPort1", "2110");
            map.put("AndromedaPort2", "2120");
            map.put("AndromedaPort3", "2130");
            map.put("AndromedaPort4", "2140");
            map.put("AndromedaPort5", "2150");
            map.put("AndromedaPort6", "2160");
            map.put("AndromedaPort7", "2170");
            map.put("AndromedaPort8", "2180");
            map.put("AndromedaPort9", "2190");
            map.put("AndromedaPort10", "21100");
            map.put("AndromedaPort11", "21110");
            map.put("AndromedaPort12", "21120");
            map.put("HalleyPort1", "2210");
            map.put("HalleyPort2", "2220");
            map.put("HalleyPort3", "2230");
            map.put("HalleyPort4", "2240");
            map.put("HalleyPort5", "2250");
            map.put("HalleyPort6", "2260");
            map.put("HalleyPort7", "2270");
            map.put("HalleyPort8", "2280");
            map.put("HalleyPort9", "2290");
            map.put("HalleyPort10", "22100");
            map.put("HalleyPort11", "22110");
            map.put("HalleyPort12", "22120");
            map.put("HalleyPort13", "22130");

        }

        return map;
    }


}
