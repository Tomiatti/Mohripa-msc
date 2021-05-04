package Webservice;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class httpRequest {

    public static String GetAvaliblehost(int service) throws IOException {
        // supposed this is your FirstController url.
        String url = "http://localhost:8070/gethost/" + service;
        //  String url = "http://10.1.1.110:8080/gethost/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);


        return content;
    }


    public static String clusterload(int service) throws IOException {
        // supposed this is your FirstController url.

        String bound= "";

        if (service == 1) {
            bound = "cpubound";
        }
        if (service == 2) {
            bound = "memorybound";
        }
        if (service == 3) {
            bound = "hybridbound";
        }

       // String url = "http://10.1.1.11:8080/"+bound;
        String url = "http://localhost:8060/"+bound;


        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);


        return content;
    }



    public static String GetAvaliblehostInternal(int service) throws IOException {
        // supposed this is your FirstController url.
        String url = "http://localhost:8090/gethost/" + service;
        //  String url = "http://10.1.1.110:8080/gethost/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);


        return content;
    }

    public static String GetAvalibleVM(String host) throws IOException {
        // supposed this is your FirstController url.
        String url = "http://localhost:8070/getvm/" + host;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }

    public static String GetAvalibleVMInternal(String host) throws IOException {
        // supposed this is your FirstController url.
        String url = "http://localhost:8070/getvm/" + host;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }

    public static String GetAvalibleVMfromAlocateInternal(int service) throws IOException {
        // supposed this is your FirstController url.
       // String url = "http://localhost:8090/getVmfromServiceOLD/" + service;
        String url = "http://localhost:8090/getVmfromAlocateHashRefresh/" + service;
        // String url = "http://10.1.1.110:8080/getVmfromService/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }

    public static String GetAvalibleVMfromAlocateExternal(int service) throws IOException {
        // supposed this is your FirstController url.
       // String url = "http://localhost:8070/getVmfromAlocateHashRefresh/" + service;
         //String url = "http://10.1.1.110:8080/getVmfromAlocateHashRefresh/"+service;
        String url = "http://localhost:8070/getAvalibleVmWithoutHost/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }


    public static String getAvalibleVmWithoutHost(int service) throws IOException {
        // supposed this is your FirstController url.
        // String url = "http://localhost:8070/getVmfromAlocateHashRefresh/" + service;
        //String url = "http://10.1.1.110:8080/getVmfromAlocateHashRefresh/"+service;
        String url = "http://localhost:8070/getAvalibleVmWithoutHost/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }



    public static String GetAvalibleVMfromServiceInternal(int service) throws IOException {
        // supposed this is your FirstController url.
        String url = "http://localhost:8070/getVmfromServiceListScheduling/" + service;
        //   String url = "http://localhost:8090/getVmfromServiceHashrefresh/" + service;
        // String url = "http://10.1.1.110:8080/getVmfromService/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }

    public static String GetAvalibleVMfromServiceExternal(int service) throws IOException {
        // supposed this is your FirstController url.
          String url = "http://localhost:8070/getVmfromAlocateListScheduling/" + service;
     //    String url = "http://localhost:8070/getVmfromServiceHashrefresh/" + service;
        // String url = "http://10.1.1.110:8080/getVmfromServiceHashrefresh/"+service;
        // String url = "http://localhost:8060/"+service;
        // create request.
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        // execute your request.
        HttpResponse response = client.execute(request);

        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);

        return content;
    }

}
