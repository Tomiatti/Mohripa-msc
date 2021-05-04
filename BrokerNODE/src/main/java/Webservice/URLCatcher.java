package Webservice;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class URLCatcher {


    public static String VMLinkService(String VM, int opcao) {
        String service ="";

        if (opcao == 1){
             service = "cpubound";
        }

        if (opcao == 2){
             service = "memorybound";
        }

        if (opcao == 3){
             service = "hybridbound";
        }

      int portToService =GetPortToService(VM);

        return "http://andromeda.lasdpc.icmc.usp.br:"+portToService+"/"+service;
    }

    public static String vmAcessVM(String VM, int port) {

        int Port = GetPortTossh(VM);

        return "ssh user@andromeda.lasdpc.icmc.usp.br:"+Port;
    }


    public static void main(String[] args) {

        String VM= "COS01-VM3";


        //System.out.println(port);

        String lastdigitVM = VM.substring(VM.length() -1);
        //System.out.println(lastdigitVM);

        System.out.println(VMLinkService(VM,1));

    }


    public static Integer GetPortTossh(String VM){

        ConcurrentHashMap <String,Integer> config = new ConcurrentHashMap <String,Integer>();

        config.put("COS01-VM1",2011);
        config.put("COS01-VM2",2012);
        config.put("COS01-VM3",2013);
        config.put("COS01-VM4",2014);

        config.put("COS02-VM1",2021);
        config.put("COS02-VM2",2022);
        config.put("COS02-VM3",2023);
        config.put("COS02-VM4",2024);

        config.put("COS03-VM1",2031);
        config.put("COS03-VM2",2032);
        config.put("COS03-VM3",2033);
        config.put("COS03-VM4",2034);

        config.put("COS04-VM1",2041);
        config.put("COS04-VM2",2042);
        config.put("COS04-VM3",2043);
        config.put("COS04-VM4",2044);

        config.put("COS05-VM1",2051);
        config.put("COS05-VM2",2052);
        config.put("COS05-VM3",2053);
        config.put("COS05-VM4",2054);

        config.put("COS06-VM1",2061);
        config.put("COS06-VM2",2062);
        config.put("COS06-VM3",2063);
        config.put("COS06-VM4",2064);

        config.put("COS07-VM1",2071);
        config.put("COS07-VM2",2072);
        config.put("COS07-VM3",2073);
        config.put("COS07-VM4",2074);

        config.put("COS08-VM1",2081);
        config.put("COS08-VM2",2082);
        config.put("COS08-VM3",2083);
        config.put("COS08-VM4",2084);

        config.put("COS09-VM1",2091);
        config.put("COS09-VM2",2092);
        config.put("COS09-VM3",2093);
        config.put("COS09-VM4",2094);

        config.put("COS10-VM1",20101);
        config.put("COS10-VM2",20102);
        config.put("COS10-VM3",20103);
        config.put("COS10-VM4",20104);

        config.put("COS11-VM1",20111);
        config.put("COS11-VM2",20112);
        config.put("COS11-VM3",20113);
        config.put("COS11-VM4",20114);

        config.put("COS12-VM1",20121);
        config.put("COS12-VM2",20122);
        config.put("COS12-VM3",20123);
        config.put("COS12-VM4",20124);

        config.put("COS13-VM1",20131);
        config.put("COS13-VM2",20132);
        config.put("COS13-VM3",20133);
        config.put("COS13-VM4",20134);

        config.put("COS14-VM1",20141);
        config.put("COS14-VM2",20142);
        config.put("COS14-VM3",20143);
        config.put("COS14-VM4",20144);

        config.put("COS15-VM1",20151);
        config.put("COS15-VM2",20152);
        config.put("COS15-VM3",20153);
        config.put("COS15-VM4",20154);

        config.put("COS16-VM1",20161);
        config.put("COS16-VM2",20162);
        config.put("COS16-VM3",20163);
        config.put("COS16-VM4",20164);

        config.put("COS17-VM1",20171);
        config.put("COS17-VM2",20172);
        config.put("COS17-VM3",20173);
        config.put("COS17-VM4",20174);

        config.put("COS18-VM1",20181);
        config.put("COS18-VM2",20182);
        config.put("COS18-VM3",20183);
        config.put("COS18-VM4",20184);

        config.put("COS19-VM1",20191);
        config.put("COS19-VM2",20192);
        config.put("COS19-VM3",20193);
        config.put("COS19-VM4",20194);

        config.put("HAL01-VM1",2211);
        config.put("HAL01-VM2",2212);
        config.put("HAL01-VM3",2213);
        config.put("HAL01-VM4",2214);
        config.put("HAL01-VM5",2215);
        config.put("HAL01-VM6",2216);
        config.put("HAL01-VM7",2217);
        config.put("HAL01-VM8",2218);

        config.put("HAL02-VM1",2221);
        config.put("HAL02-VM2",2222);
        config.put("HAL02-VM3",2223);
        config.put("HAL02-VM4",2224);
        config.put("HAL02-VM5",2225);
        config.put("HAL02-VM6",2226);
        config.put("HAL02-VM7",2227);
        config.put("HAL02-VM8",2228);

        config.put("HAL03-VM1",2231);
        config.put("HAL03-VM2",2232);
        config.put("HAL03-VM3",2233);
        config.put("HAL03-VM4",2234);
        config.put("HAL03-VM5",2235);
        config.put("HAL03-VM6",2236);
        config.put("HAL03-VM7",2237);
        config.put("HAL03-VM8",2238);

        config.put("HAL04-VM1",2241);
        config.put("HAL04-VM2",2242);
        config.put("HAL04-VM3",2243);
        config.put("HAL04-VM4",2244);
        config.put("HAL04-VM5",2245);
        config.put("HAL04-VM6",2246);
        config.put("HAL04-VM7",2247);
        config.put("HAL04-VM8",2248);

        config.put("HAL05-VM1",2251);
        config.put("HAL05-VM2",2252);
        config.put("HAL05-VM3",2253);
        config.put("HAL05-VM4",2254);
        config.put("HAL05-VM5",2255);
        config.put("HAL05-VM6",2256);
        config.put("HAL05-VM7",2257);
        config.put("HAL05-VM8",2258);

        config.put("HAL06-VM1",2261);
        config.put("HAL06-VM2",2262);
        config.put("HAL06-VM3",2263);
        config.put("HAL06-VM4",2264);
        config.put("HAL06-VM5",2265);
        config.put("HAL06-VM6",2266);
        config.put("HAL06-VM7",2267);
        config.put("HAL06-VM8",2268);

        config.put("HAL07-VM1",2271);
        config.put("HAL07-VM2",2272);
        config.put("HAL07-VM3",2273);
        config.put("HAL07-VM4",2274);
        config.put("HAL07-VM5",2275);
        config.put("HAL07-VM6",2276);
        config.put("HAL07-VM7",2277);
        config.put("HAL07-VM8",2278);

        config.put("HAL08-VM1",2281);
        config.put("HAL08-VM2",2282);
        config.put("HAL08-VM3",2283);
        config.put("HAL08-VM4",2284);
        config.put("HAL08-VM5",2285);
        config.put("HAL08-VM6",2286);
        config.put("HAL08-VM7",2287);
        config.put("HAL08-VM8",2288);

        config.put("HAL09-VM1",2291);
        config.put("HAL09-VM2",2292);
        config.put("HAL09-VM3",2293);
        config.put("HAL09-VM4",2294);
        config.put("HAL09-VM5",2295);
        config.put("HAL09-VM6",2296);
        config.put("HAL09-VM7",2297);
        config.put("HAL09-VM8",2298);

        config.put("HAL10-VM1",22101);
        config.put("HAL10-VM2",22102);
        config.put("HAL10-VM3",22103);
        config.put("HAL10-VM4",22104);
        config.put("HAL10-VM5",22105);
        config.put("HAL10-VM6",22106);
        config.put("HAL10-VM7",22107);
        config.put("HAL10-VM8",22108);

        config.put("HAL11-VM1",22111);
        config.put("HAL11-VM2",22112);
        config.put("HAL11-VM3",22113);
        config.put("HAL11-VM4",22114);
        config.put("HAL11-VM5",22115);
        config.put("HAL11-VM6",22116);
        config.put("HAL11-VM7",22117);
        config.put("HAL11-VM8",22118);

        config.put("HAL12-VM1",22121);
        config.put("HAL12-VM2",22122);
        config.put("HAL12-VM3",22123);
        config.put("HAL12-VM4",22124);
        config.put("HAL12-VM5",22125);
        config.put("HAL12-VM6",22126);
        config.put("HAL12-VM7",22127);
        config.put("HAL12-VM8",22128);

        config.put("HAL13-VM1",22131);
        config.put("HAL13-VM2",22132);
        config.put("HAL13-VM3",22133);
        config.put("HAL13-VM4",22134);
        config.put("HAL13-VM5",22135);
        config.put("HAL13-VM6",22136);
        config.put("HAL13-VM7",22137);
        config.put("HAL13-VM8",22138);


        config.put("AND01-VM1",2111);
        config.put("AND01-VM2",2112);
        config.put("AND01-VM3",2113);
        config.put("AND01-VM4",2114);
        config.put("AND01-VM5",2115);
        config.put("AND01-VM6",2116);
        config.put("AND01-VM7",2117);
        config.put("AND01-VM8",2118);

        config.put("AND02-VM1",2121);
        config.put("AND02-VM2",2122);
        config.put("AND02-VM3",2123);
        config.put("AND02-VM4",2124);
        config.put("AND02-VM5",2125);
        config.put("AND02-VM6",2126);
        config.put("AND02-VM7",2127);
        config.put("AND02-VM8",2128);

        config.put("AND03-VM1",2131);
        config.put("AND03-VM2",2132);
        config.put("AND03-VM3",2133);
        config.put("AND03-VM4",2134);
        config.put("AND03-VM5",2135);
        config.put("AND03-VM6",2136);
        config.put("AND03-VM7",2137);
        config.put("AND03-VM8",2138);

        config.put("AND04-VM1",2141);
        config.put("AND04-VM2",2142);
        config.put("AND04-VM3",2143);
        config.put("AND04-VM4",2144);
        config.put("AND04-VM5",2145);
        config.put("AND04-VM6",2146);
        config.put("AND04-VM7",2147);
        config.put("AND04-VM8",2148);

        config.put("AND05-VM1",2151);
        config.put("AND05-VM2",2152);
        config.put("AND05-VM3",2153);
        config.put("AND05-VM4",2154);
        config.put("AND05-VM5",2155);
        config.put("AND05-VM6",2156);
        config.put("AND05-VM7",2157);
        config.put("AND05-VM8",2158);

        config.put("AND06-VM1",2161);
        config.put("AND06-VM2",2162);
        config.put("AND06-VM3",2163);
        config.put("AND06-VM4",2164);
        config.put("AND06-VM5",2165);
        config.put("AND06-VM6",2166);
        config.put("AND06-VM7",2167);
        config.put("AND06-VM8",2168);

        config.put("AND07-VM1",2171);
        config.put("AND07-VM2",2172);
        config.put("AND07-VM3",2173);
        config.put("AND07-VM4",2174);
        config.put("AND07-VM5",2175);
        config.put("AND07-VM6",2176);
        config.put("AND07-VM7",2177);
        config.put("AND07-VM8",2178);

        config.put("AND08-VM1",2181);
        config.put("AND08-VM2",2182);
        config.put("AND08-VM3",2183);
        config.put("AND08-VM4",2184);
        config.put("AND08-VM5",2185);
        config.put("AND08-VM6",2186);
        config.put("AND08-VM7",2187);
        config.put("AND08-VM8",2188);

        config.put("AND09-VM1",2191);
        config.put("AND09-VM2",2192);
        config.put("AND09-VM3",2193);
        config.put("AND09-VM4",2194);
        config.put("AND09-VM5",2195);
        config.put("AND09-VM6",2196);
        config.put("AND09-VM7",2197);
        config.put("AND09-VM8",2198);

        config.put("AND10-VM1",21101);
        config.put("AND10-VM2",21102);
        config.put("AND10-VM3",21103);
        config.put("AND10-VM4",21104);
        config.put("AND10-VM5",21105);
        config.put("AND10-VM6",21106);
        config.put("AND10-VM7",21107);
        config.put("AND10-VM8",21108);

        config.put("AND11-VM1",21111);
        config.put("AND11-VM2",21112);
        config.put("AND11-VM3",21113);
        config.put("AND11-VM4",21114);
        config.put("AND11-VM5",21115);
        config.put("AND11-VM6",21116);
        config.put("AND11-VM7",21117);
        config.put("AND11-VM8",21118);

        config.put("AND12-VM1",21121);
        config.put("AND12-VM2",21122);
        config.put("AND12-VM3",21123);
        config.put("AND12-VM4",21124);
        config.put("AND12-VM5",21125);
        config.put("AND12-VM6",21126);
        config.put("AND12-VM7",21127);
        config.put("AND12-VM8",21128);

        return config.get(VM);
    }


    public static Integer GetPortToService(String VM){

        ConcurrentHashMap <String,Integer> config = new ConcurrentHashMap <String,Integer>();

        config.put("COS01-VM1",6011);
        config.put("COS01-VM2",6012);
        config.put("COS01-VM3",6013);
        config.put("COS01-VM4",6014);

        config.put("COS02-VM1",6021);
        config.put("COS02-VM2",6022);
        config.put("COS02-VM3",6023);
        config.put("COS02-VM4",6024);

        config.put("COS03-VM1",6031);
        config.put("COS03-VM2",6032);
        config.put("COS03-VM3",6033);
        config.put("COS03-VM4",6034);

        config.put("COS04-VM1",6041);
        config.put("COS04-VM2",6042);
        config.put("COS04-VM3",6043);
        config.put("COS04-VM4",6044);

        config.put("COS05-VM1",6051);
        config.put("COS05-VM2",6052);
        config.put("COS05-VM3",6053);
        config.put("COS05-VM4",6054);

        config.put("COS06-VM1",6061);
        config.put("COS06-VM2",6062);
        config.put("COS06-VM3",6063);
        config.put("COS06-VM4",6064);

        config.put("COS07-VM1",6071);
        config.put("COS07-VM2",6072);
        config.put("COS07-VM3",6073);
        config.put("COS07-VM4",6074);

        config.put("COS08-VM1",6081);
        config.put("COS08-VM2",6082);
        config.put("COS08-VM3",6083);
        config.put("COS08-VM4",6084);

        config.put("COS09-VM1",6091);
        config.put("COS09-VM2",6092);
        config.put("COS09-VM3",6093);
        config.put("COS09-VM4",6094);

        config.put("COS10-VM1",60101);
        config.put("COS10-VM2",60102);
        config.put("COS10-VM3",60103);
        config.put("COS10-VM4",60104);

        config.put("COS11-VM1",60111);
        config.put("COS11-VM2",60112);
        config.put("COS11-VM3",60113);
        config.put("COS11-VM4",60114);

        config.put("COS12-VM1",60121);
        config.put("COS12-VM2",60122);
        config.put("COS12-VM3",60123);
        config.put("COS12-VM4",60124);

        config.put("COS13-VM1",60131);
        config.put("COS13-VM2",60132);
        config.put("COS13-VM3",60133);
        config.put("COS13-VM4",60134);

        config.put("COS14-VM1",60141);
        config.put("COS14-VM2",60142);
        config.put("COS14-VM3",60143);
        config.put("COS14-VM4",60144);

        config.put("COS15-VM1",60151);
        config.put("COS15-VM2",60152);
        config.put("COS15-VM3",60153);
        config.put("COS15-VM4",60154);

        config.put("COS16-VM1",60161);
        config.put("COS16-VM2",60162);
        config.put("COS16-VM3",60163);
        config.put("COS16-VM4",60164);

        config.put("COS17-VM1",60171);
        config.put("COS17-VM2",60172);
        config.put("COS17-VM3",60173);
        config.put("COS17-VM4",60174);

        config.put("COS18-VM1",60181);
        config.put("COS18-VM2",60182);
        config.put("COS18-VM3",60183);
        config.put("COS18-VM4",60184);

        config.put("COS19-VM1",60191);
        config.put("COS19-VM2",60192);
        config.put("COS19-VM3",60193);
        config.put("COS19-VM4",60194);

        config.put("HAL01-VM1",6211);
        config.put("HAL01-VM2",6212);
        config.put("HAL01-VM3",6213);
        config.put("HAL01-VM4",6214);
        config.put("HAL01-VM5",6215);
        config.put("HAL01-VM6",6216);
        config.put("HAL01-VM7",6217);
        config.put("HAL01-VM8",6218);

        config.put("HAL02-VM1",6221);
        config.put("HAL02-VM2",6222);
        config.put("HAL02-VM3",6223);
        config.put("HAL02-VM4",6224);
        config.put("HAL02-VM5",6225);
        config.put("HAL02-VM6",6226);
        config.put("HAL02-VM7",6227);
        config.put("HAL02-VM8",6228);

        config.put("HAL03-VM1",6231);
        config.put("HAL03-VM2",6232);
        config.put("HAL03-VM3",6233);
        config.put("HAL03-VM4",6234);
        config.put("HAL03-VM5",6235);
        config.put("HAL03-VM6",6236);
        config.put("HAL03-VM7",6237);
        config.put("HAL03-VM8",6238);

        config.put("HAL04-VM1",6241);
        config.put("HAL04-VM2",6242);
        config.put("HAL04-VM3",6243);
        config.put("HAL04-VM4",6244);
        config.put("HAL04-VM5",6245);
        config.put("HAL04-VM6",6246);
        config.put("HAL04-VM7",6247);
        config.put("HAL04-VM8",6248);

        config.put("HAL05-VM1",6251);
        config.put("HAL05-VM2",6252);
        config.put("HAL05-VM3",6253);
        config.put("HAL05-VM4",6254);
        config.put("HAL05-VM5",6255);
        config.put("HAL05-VM6",6256);
        config.put("HAL05-VM7",6257);
        config.put("HAL05-VM8",6258);

        config.put("HAL06-VM1",6261);
        config.put("HAL06-VM2",6262);
        config.put("HAL06-VM3",6263);
        config.put("HAL06-VM4",6264);
        config.put("HAL06-VM5",6265);
        config.put("HAL06-VM6",6266);
        config.put("HAL06-VM7",6267);
        config.put("HAL06-VM8",6268);

        config.put("HAL07-VM1",6271);
        config.put("HAL07-VM2",6272);
        config.put("HAL07-VM3",6273);
        config.put("HAL07-VM4",6274);
        config.put("HAL07-VM5",6275);
        config.put("HAL07-VM6",6276);
        config.put("HAL07-VM7",6277);
        config.put("HAL07-VM8",6278);

        config.put("HAL08-VM1",6281);
        config.put("HAL08-VM2",6282);
        config.put("HAL08-VM3",6283);
        config.put("HAL08-VM4",6284);
        config.put("HAL08-VM5",6285);
        config.put("HAL08-VM6",6286);
        config.put("HAL08-VM7",6287);
        config.put("HAL08-VM8",6288);

        config.put("HAL09-VM1",6291);
        config.put("HAL09-VM2",6292);
        config.put("HAL09-VM3",6293);
        config.put("HAL09-VM4",6294);
        config.put("HAL09-VM5",6295);
        config.put("HAL09-VM6",6296);
        config.put("HAL09-VM7",6297);
        config.put("HAL09-VM8",6298);

        config.put("HAL10-VM1",62101);
        config.put("HAL10-VM2",62102);
        config.put("HAL10-VM3",62103);
        config.put("HAL10-VM4",62104);
        config.put("HAL10-VM5",62105);
        config.put("HAL10-VM6",62106);
        config.put("HAL10-VM7",62107);
        config.put("HAL10-VM8",62108);

        config.put("HAL11-VM1",62111);
        config.put("HAL11-VM2",62112);
        config.put("HAL11-VM3",62113);
        config.put("HAL11-VM4",62114);
        config.put("HAL11-VM5",62115);
        config.put("HAL11-VM6",62116);
        config.put("HAL11-VM7",62117);
        config.put("HAL11-VM8",62118);

        config.put("HAL12-VM1",62121);
        config.put("HAL12-VM2",62122);
        config.put("HAL12-VM3",62123);
        config.put("HAL12-VM4",62124);
        config.put("HAL12-VM5",62125);
        config.put("HAL12-VM6",62126);
        config.put("HAL12-VM7",62127);
        config.put("HAL12-VM8",62128);

        config.put("HAL13-VM1",62131);
        config.put("HAL13-VM2",62132);
        config.put("HAL13-VM3",62133);
        config.put("HAL13-VM4",62134);
        config.put("HAL13-VM5",62135);
        config.put("HAL13-VM6",62136);
        config.put("HAL13-VM7",62137);
        config.put("HAL13-VM8",62138);


        config.put("AND01-VM1",6111);
        config.put("AND01-VM2",6112);
        config.put("AND01-VM3",6113);
        config.put("AND01-VM4",6114);
        config.put("AND01-VM5",6115);
        config.put("AND01-VM6",6116);
        config.put("AND01-VM7",6117);
        config.put("AND01-VM8",6118);

        config.put("AND02-VM1",6121);
        config.put("AND02-VM2",6122);
        config.put("AND02-VM3",6123);
        config.put("AND02-VM4",6124);
        config.put("AND02-VM5",6125);
        config.put("AND02-VM6",6126);
        config.put("AND02-VM7",6127);
        config.put("AND02-VM8",6128);

        config.put("AND03-VM1",6131);
        config.put("AND03-VM2",6132);
        config.put("AND03-VM3",6133);
        config.put("AND03-VM4",6134);
        config.put("AND03-VM5",6135);
        config.put("AND03-VM6",6136);
        config.put("AND03-VM7",6137);
        config.put("AND03-VM8",6138);

        config.put("AND04-VM1",6141);
        config.put("AND04-VM2",6142);
        config.put("AND04-VM3",6143);
        config.put("AND04-VM4",6144);
        config.put("AND04-VM5",6145);
        config.put("AND04-VM6",6146);
        config.put("AND04-VM7",6147);
        config.put("AND04-VM8",6148);

        config.put("AND05-VM1",6151);
        config.put("AND05-VM2",6152);
        config.put("AND05-VM3",6153);
        config.put("AND05-VM4",6154);
        config.put("AND05-VM5",6155);
        config.put("AND05-VM6",6156);
        config.put("AND05-VM7",6157);
        config.put("AND05-VM8",6158);

        config.put("AND06-VM1",6161);
        config.put("AND06-VM2",6162);
        config.put("AND06-VM3",6163);
        config.put("AND06-VM4",6164);
        config.put("AND06-VM5",6165);
        config.put("AND06-VM6",6166);
        config.put("AND06-VM7",6167);
        config.put("AND06-VM8",6168);

        config.put("AND07-VM1",6171);
        config.put("AND07-VM2",6172);
        config.put("AND07-VM3",6173);
        config.put("AND07-VM4",6174);
        config.put("AND07-VM5",6175);
        config.put("AND07-VM6",6176);
        config.put("AND07-VM7",6177);
        config.put("AND07-VM8",6178);

        config.put("AND08-VM1",6181);
        config.put("AND08-VM2",6182);
        config.put("AND08-VM3",6183);
        config.put("AND08-VM4",6184);
        config.put("AND08-VM5",6185);
        config.put("AND08-VM6",6186);
        config.put("AND08-VM7",6187);
        config.put("AND08-VM8",6188);

        config.put("AND09-VM1",6191);
        config.put("AND09-VM2",6192);
        config.put("AND09-VM3",6193);
        config.put("AND09-VM4",6194);
        config.put("AND09-VM5",6195);
        config.put("AND09-VM6",6196);
        config.put("AND09-VM7",6197);
        config.put("AND09-VM8",6198);

        config.put("AND10-VM1",61101);
        config.put("AND10-VM2",61102);
        config.put("AND10-VM3",61103);
        config.put("AND10-VM4",61104);
        config.put("AND10-VM5",61105);
        config.put("AND10-VM6",61106);
        config.put("AND10-VM7",61107);
        config.put("AND10-VM8",61108);

        config.put("AND11-VM1",61111);
        config.put("AND11-VM2",61112);
        config.put("AND11-VM3",61113);
        config.put("AND11-VM4",61114);
        config.put("AND11-VM5",61115);
        config.put("AND11-VM6",61116);
        config.put("AND11-VM7",61117);
        config.put("AND11-VM8",61118);

        config.put("AND12-VM1",61121);
        config.put("AND12-VM2",61122);
        config.put("AND12-VM3",61123);
        config.put("AND12-VM4",61124);
        config.put("AND12-VM5",61125);
        config.put("AND12-VM6",61126);
        config.put("AND12-VM7",61127);
        config.put("AND12-VM8",61128);

        return config.get(VM);
    }

}

 /*  java.util.Properties config = new java.util.Properties();

        Map<String,String> example = new HashMap<String,String>();
        config.put("COS01-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS01-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS01-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS01-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS02-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS02-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS02-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS02-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS03-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS03-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS03-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS03-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS04-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS04-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS04-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS04-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS05-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS05-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS05-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS05-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS06-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS06-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS06-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS06-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS07-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS07-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS07-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS07-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS08-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS08-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS08-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS08-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS09-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS09-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS09-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS09-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS10-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS10-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS10-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS10-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS11-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS11-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS11-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS11-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS12-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS12-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS12-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS12-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS13-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS13-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS13-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS13-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS14-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS14-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS14-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS14-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS15-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS15-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS15-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS15-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS16-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS16-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS16-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS16-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS17-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS17-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS17-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS17-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS18-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS18-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS18-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS18-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS19-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS19-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS19-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("COS19-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");


        config.put("HAL01-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL01-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL02-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL02-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL03-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL03-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL04-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL04-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL05-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL05-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL06-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL06-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL07-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL07-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL08-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL08-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL09-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL09-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL10-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL10-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL11-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL11-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL12-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL12-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("HAL13-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("HAL13-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND01-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND01-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND02-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND02-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND03-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND03-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND04-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND04-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND05-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND05-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND06-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND06-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND07-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND07-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND08-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND08-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND09-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND09-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND10-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND10-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND11-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND11-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");

        config.put("AND12-VM1","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM2","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM3","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM4","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM5","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM6","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM7","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");
        config.put("AND12-VM8","ssh tomiatti@ANDromeda.lasdpc.icmc.usp.br:2110");


        return config.getProperty(VM);*/
  /*  HashMap <String, Integer> config = new HashMap <String, Integer>();

        config.put("COS01-VM1", "http://"+VM+":8080/"+service+"");
        config.put("COS01-VM2", "http://"+VM+":8080/"+service);
        config.put("COS01-VM3", "http://"+VM+":8080/"+service);
        config.put("COS01-VM4", "http://"+VM+":8080/"+service);
        config.put("COS02-VM1", "http://"+VM+":8080/"+service);
        config.put("COS02-VM2", "http://"+VM+":8080/"+service);
        config.put("COS02-VM3", "http://"+VM+":8080/"+service);
        config.put("COS02-VM4", "http://"+VM+":8080/"+service);
        config.put("COS03-VM1", "http://"+VM+":8080/"+service);
        config.put("COS03-VM2", "http://"+VM+":8080/"+service);
        config.put("COS03-VM3", "http://"+VM+":8080/"+service);
        config.put("COS03-VM4", "http://"+VM+":8080/"+service);
        config.put("COS04-VM1", "http://"+VM+":8080/"+service);
        config.put("COS04-VM2", "http://"+VM+":8080/"+service);
        config.put("COS04-VM3", "http://"+VM+":8080/"+service);
        config.put("COS04-VM4", "http://"+VM+":8080/"+service);
        config.put("COS05-VM1", "http://"+VM+":8080/"+service);
        config.put("COS05-VM2", "http://"+VM+":8080/"+service);
        config.put("COS05-VM3", "http://"+VM+":8080/"+service);
        config.put("COS05-VM4", "http://"+VM+":8080/"+service);
        config.put("COS06-VM1", "http://"+VM+":8080/"+service);
        config.put("COS06-VM2", "http://"+VM+":8080/"+service);
        config.put("COS06-VM3", "http://"+VM+":8080/"+service);
        config.put("COS06-VM4", "http://"+VM+":8080/"+service);
        config.put("COS07-VM1", "http://"+VM+":8080/"+service);
        config.put("COS07-VM2", "http://"+VM+":8080/"+service);
        config.put("COS07-VM3", "http://"+VM+":8080/"+service);
        config.put("COS07-VM4", "http://"+VM+":8080/"+service);
        config.put("COS08-VM1", "http://"+VM+":8080/"+service);
        config.put("COS08-VM2", "http://"+VM+":8080/"+service);
        config.put("COS08-VM3", "http://"+VM+":8080/"+service);
        config.put("COS08-VM4", "http://"+VM+":8080/"+service);
        config.put("COS09-VM1", "http://"+VM+":8080/"+service);
        config.put("COS09-VM2", "http://"+VM+":8080/"+service);
        config.put("COS09-VM3", "http://"+VM+":8080/"+service);
        config.put("COS09-VM4", "http://"+VM+":8080/"+service);
        config.put("COS10-VM1", "http://"+VM+":8080/"+service);
        config.put("COS10-VM2", "http://"+VM+":8080/"+service);
        config.put("COS10-VM3", "http://"+VM+":8080/"+service);
        config.put("COS10-VM4", "http://"+VM+":8080/"+service);
        config.put("COS11-VM1", "http://"+VM+":8080/"+service);
        config.put("COS11-VM2", "http://"+VM+":8080/"+service);
        config.put("COS11-VM3", "http://"+VM+":8080/"+service);
        config.put("COS11-VM4", "http://"+VM+":8080/"+service);
        config.put("COS12-VM1", "http://"+VM+":8080/"+service);
        config.put("COS12-VM2", "http://"+VM+":8080/"+service);
        config.put("COS12-VM3", "http://"+VM+":8080/"+service);
        config.put("COS12-VM4", "http://"+VM+":8080/"+service);
        config.put("COS13-VM1", "http://"+VM+":8080/"+service);
        config.put("COS13-VM2", "http://"+VM+":8080/"+service);
        config.put("COS13-VM3", "http://"+VM+":8080/"+service);
        config.put("COS13-VM4", "http://"+VM+":8080/"+service);
        config.put("COS14-VM1", "http://"+VM+":8080/"+service);
        config.put("COS14-VM2", "http://"+VM+":8080/"+service);
        config.put("COS14-VM3", "http://"+VM+":8080/"+service);
        config.put("COS14-VM4", "http://"+VM+":8080/"+service);
        config.put("COS15-VM1", "http://"+VM+":8080/"+service);
        config.put("COS15-VM2", "http://"+VM+":8080/"+service);
        config.put("COS15-VM3", "http://"+VM+":8080/"+service);
        config.put("COS15-VM4", "http://"+VM+":8080/"+service);
        config.put("COS16-VM1", "http://"+VM+":8080/"+service);
        config.put("COS16-VM2", "http://"+VM+":8080/"+service);
        config.put("COS16-VM3", "http://"+VM+":8080/"+service);
        config.put("COS16-VM4", "http://"+VM+":8080/"+service);
        config.put("COS17-VM1", "http://"+VM+":8080/"+service);
        config.put("COS17-VM2", "http://"+VM+":8080/"+service);
        config.put("COS17-VM3", "http://"+VM+":8080/"+service);
        config.put("COS17-VM4", "http://"+VM+":8080/"+service);
        config.put("COS18-VM1", "http://"+VM+":8080/"+service);
        config.put("COS18-VM2", "http://"+VM+":8080/"+service);
        config.put("COS18-VM3", "http://"+VM+":8080/"+service);
        config.put("COS18-VM4", "http://"+VM+":8080/"+service);
        config.put("COS19-VM1", "http://"+VM+":8080/"+service);
        config.put("COS19-VM2", "http://"+VM+":8080/"+service);
        config.put("COS19-VM3", "http://"+VM+":8080/"+service);
        config.put("COS19-VM4", "http://"+VM+":8080/"+service);


        config.put("HAL01-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL01-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL02-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL02-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL03-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL03-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL04-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL04-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL05-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL05-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL06-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL06-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL07-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL07-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL08-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL08-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL09-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL09-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL10-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL10-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL11-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL11-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL12-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL12-VM8", "http://"+VM+":8080/"+service);

        config.put("HAL13-VM1", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM2", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM3", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM4", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM5", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM6", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM7", "http://"+VM+":8080/"+service);
        config.put("HAL13-VM8", "http://"+VM+":8080/"+service);

        config.put("AND01-VM1", "http://"+VM+":8080/"+service);
        config.put("AND01-VM2", "http://"+VM+":8080/"+service);
        config.put("AND01-VM3", "http://"+VM+":8080/"+service);
        config.put("AND01-VM4", "http://"+VM+":8080/"+service);
        config.put("AND01-VM5", "http://"+VM+":8080/"+service);
        config.put("AND01-VM6", "http://"+VM+":8080/"+service);
        config.put("AND01-VM7", "http://"+VM+":8080/"+service);
        config.put("AND01-VM8", "http://"+VM+":8080/"+service);

        config.put("AND02-VM1", "http://"+VM+":8080/"+service);
        config.put("AND02-VM2", "http://"+VM+":8080/"+service);
        config.put("AND02-VM3", "http://"+VM+":8080/"+service);
        config.put("AND02-VM4", "http://"+VM+":8080/"+service);
        config.put("AND02-VM5", "http://"+VM+":8080/"+service);
        config.put("AND02-VM6", "http://"+VM+":8080/"+service);
        config.put("AND02-VM7", "http://"+VM+":8080/"+service);
        config.put("AND02-VM8", "http://"+VM+":8080/"+service);

        config.put("AND03-VM1", "http://"+VM+":8080/"+service);
        config.put("AND03-VM2", "http://"+VM+":8080/"+service);
        config.put("AND03-VM3", "http://"+VM+":8080/"+service);
        config.put("AND03-VM4", "http://"+VM+":8080/"+service);
        config.put("AND03-VM5", "http://"+VM+":8080/"+service);
        config.put("AND03-VM6", "http://"+VM+":8080/"+service);
        config.put("AND03-VM7", "http://"+VM+":8080/"+service);
        config.put("AND03-VM8", "http://"+VM+":8080/"+service);

        config.put("AND04-VM1", "http://"+VM+":8080/"+service);
        config.put("AND04-VM2", "http://"+VM+":8080/"+service);
        config.put("AND04-VM3", "http://"+VM+":8080/"+service);
        config.put("AND04-VM4", "http://"+VM+":8080/"+service);
        config.put("AND04-VM5", "http://"+VM+":8080/"+service);
        config.put("AND04-VM6", "http://"+VM+":8080/"+service);
        config.put("AND04-VM7", "http://"+VM+":8080/"+service);
        config.put("AND04-VM8", "http://"+VM+":8080/"+service);

        config.put("AND05-VM1", "http://"+VM+":8080/"+service);
        config.put("AND05-VM2", "http://"+VM+":8080/"+service);
        config.put("AND05-VM3", "http://"+VM+":8080/"+service);
        config.put("AND05-VM4", "http://"+VM+":8080/"+service);
        config.put("AND05-VM5", "http://"+VM+":8080/"+service);
        config.put("AND05-VM6", "http://"+VM+":8080/"+service);
        config.put("AND05-VM7", "http://"+VM+":8080/"+service);
        config.put("AND05-VM8", "http://"+VM+":8080/"+service);

        config.put("AND06-VM1", "http://"+VM+":8080/"+service);
        config.put("AND06-VM2", "http://"+VM+":8080/"+service);
        config.put("AND06-VM3", "http://"+VM+":8080/"+service);
        config.put("AND06-VM4", "http://"+VM+":8080/"+service);
        config.put("AND06-VM5", "http://"+VM+":8080/"+service);
        config.put("AND06-VM6", "http://"+VM+":8080/"+service);
        config.put("AND06-VM7", "http://"+VM+":8080/"+service);
        config.put("AND06-VM8", "http://"+VM+":8080/"+service);

        config.put("AND07-VM1", "http://"+VM+":8080/"+service);
        config.put("AND07-VM2", "http://"+VM+":8080/"+service);
        config.put("AND07-VM3", "http://"+VM+":8080/"+service);
        config.put("AND07-VM4", "http://"+VM+":8080/"+service);
        config.put("AND07-VM5", "http://"+VM+":8080/"+service);
        config.put("AND07-VM6", "http://"+VM+":8080/"+service);
        config.put("AND07-VM7", "http://"+VM+":8080/"+service);
        config.put("AND07-VM8", "http://"+VM+":8080/"+service);

        config.put("AND08-VM1", "http://"+VM+":8080/"+service);
        config.put("AND08-VM2", "http://"+VM+":8080/"+service);
        config.put("AND08-VM3", "http://"+VM+":8080/"+service);
        config.put("AND08-VM4", "http://"+VM+":8080/"+service);
        config.put("AND08-VM5", "http://"+VM+":8080/"+service);
        config.put("AND08-VM6", "http://"+VM+":8080/"+service);
        config.put("AND08-VM7", "http://"+VM+":8080/"+service);
        config.put("AND08-VM8", "http://"+VM+":8080/"+service);

        config.put("AND09-VM1", "http://"+VM+":8080/"+service);
        config.put("AND09-VM2", "http://"+VM+":8080/"+service);
        config.put("AND09-VM3", "http://"+VM+":8080/"+service);
        config.put("AND09-VM4", "http://"+VM+":8080/"+service);
        config.put("AND09-VM5", "http://"+VM+":8080/"+service);
        config.put("AND09-VM6", "http://"+VM+":8080/"+service);
        config.put("AND09-VM7", "http://"+VM+":8080/"+service);
        config.put("AND09-VM8", "http://"+VM+":8080/"+service);

        config.put("AND10-VM1", "http://"+VM+":8080/"+service);
        config.put("AND10-VM2", "http://"+VM+":8080/"+service);
        config.put("AND10-VM3", "http://"+VM+":8080/"+service);
        config.put("AND10-VM4", "http://"+VM+":8080/"+service);
        config.put("AND10-VM5", "http://"+VM+":8080/"+service);
        config.put("AND10-VM6", "http://"+VM+":8080/"+service);
        config.put("AND10-VM7", "http://"+VM+":8080/"+service);
        config.put("AND10-VM8", "http://"+VM+":8080/"+service);

        config.put("AND11-VM1", "http://"+VM+":8080/"+service);
        config.put("AND11-VM2", "http://"+VM+":8080/"+service);
        config.put("AND11-VM3", "http://"+VM+":8080/"+service);
        config.put("AND11-VM4", "http://"+VM+":8080/"+service);
        config.put("AND11-VM5", "http://"+VM+":8080/"+service);
        config.put("AND11-VM6", "http://"+VM+":8080/"+service);
        config.put("AND11-VM7", "http://"+VM+":8080/"+service);
        config.put("AND11-VM8", "http://"+VM+":8080/"+service);

        config.put("AND12-VM1", "http://"+VM+":8080/"+service);
        config.put("AND12-VM2", "http://"+VM+":8080/"+service);
        config.put("AND12-VM3", "http://"+VM+":8080/"+service);
        config.put("AND12-VM4", "http://"+VM+":8080/"+service);
        config.put("AND12-VM5", "http://"+VM+":8080/"+service);
        config.put("AND12-VM6", "http://"+VM+":8080/"+service);
        config.put("AND12-VM7", "http://"+VM+":8080/"+service);
        config.put("AND12-VM8", "http://"+VM+":8080/"+service);
*/