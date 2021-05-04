package MonitorAPI.Tools.Dstat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class ProcessBuilderDstat {


  /*  public static void main(String[] args) throws IOException, InterruptedException {
      //  ExecuteScript();
        cpuMetrics(); //tudo certo

       //   memMetrics(); // tudo certo

         // diskMetrics(); // tudo certo

        //  networkMetrics(); //tudo certo
    }*/

    public static void cpuMetrics() {
        try {
            Process pr = Runtime.getRuntime().exec("dstat -c 1 0 --float"); /*Executa o processbuilder para execução de comando no cmd  */
            AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>(); /*Converter buffered para variavel atomica */
            buf.set(new BufferedReader(new InputStreamReader(pr.getInputStream())));  /*Atribui o buffread de execução do processbuildes */
            String line = ""; /*Inicia variavel que carregara as linhas do buffread*/

            while ((line = buf.get().readLine()) != null) {  /*verifica se o buffread se encontra vazio*/
                //System.out.println(line);  /*apenas para testes*/
                String Metrics = line.trim(); /*Atribui a variavel de linha do buffread com o tratamento de espaços desnecessarios*/
                String[] strArray = Metrics.split("  "); /*realiza tratamento de dividir string por espaço em um vetor*/

                if (!Metrics.contains("usr sys idl wai hiq siq") && !Metrics.contains("[7l----total-cpu-usage----")) { /*Tratamento de string tirando os header que vem com o buffreader */
                    for (int i = 0; i < strArray.length; i++) { /*laço para imprimir o string de array após tratamento da string */
                        //  System.out.println( "position" + i + ":" + strArray[i] );
                    }

                    /* Atribui as posições do array list a variaveis*/
                    String usr = strArray[0].trim();
                    String sys = strArray[1].trim();
                    String idl = strArray[2].trim();
                    String wai = strArray[3].trim();
                    String hiq = strArray[4].trim();
                    String siq = strArray[5].trim();

                    /* Atribui as variaveis tratadas para o construtor de metricas do dstat*/
                    DstatMetrics dm = new DstatMetrics();
                    dm.setUsr(Float.parseFloat(usr));
                    dm.setSys(Float.parseFloat(sys));
                    dm.setIdl(Float.parseFloat(idl));
                    dm.setWai(Float.parseFloat(wai));
                    dm.setHiq(Float.parseFloat(hiq));
                    dm.setSiq(Float.parseFloat(siq));

                  /* System.out.println( usr );
                    System.out.println( sys );
                    System.out.println( idl );
                    System.out.println( wai );
                    System.out.println( hiq );
                    System.out.println( siq );/**/

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void memMetrics() {
        try {
            Process pr = Runtime.getRuntime().exec("dstat -m 1 0 --float"); /*Executa o processbuilder para execução de comando no cmd  */
            AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>(); /*Converter buffered para variavel atomica */
            buf.set(new BufferedReader(new InputStreamReader(pr.getInputStream())));  /*Atribui o buffread de execução do processbuildes */
            String line = ""; /*Inicia variavel que carregara as linhas do buffread*/

            while ((line = buf.get().readLine()) != null) { /*verifica se o buffread se encontra vazio*/
                //System.out.println(line);  /*apenas para testes*/
                String Metrics = line; /*Atribui a variavel de linha do buffread */
                String[] strArray = Metrics.split("  | "); /*realiza tratamento de dividir string por espaço em um vetor*/

                if (!Metrics.contains("used  buff  cach  free") && !Metrics.contains("[7l------memory-usage-----")) { /*Tratamento de string tirando os header que vem com o buffreader */
                    for (int i = 0; i < strArray.length; i++) { /*laço para imprimir o string de array após tratamento da string */
                        //   System.out.println("position" + i + ":" + strArray[i]);
                    }

                    /* Atribui as posições do array list a variaveis*/
                    String used = strArray[0].replace('M', ' ').trim();
                    String buff = strArray[1].replace('M', ' ').trim();
                    String cach = strArray[2].replace('M', ' ').trim();
                    String free = strArray[3].replace('M', ' ').trim();

                    /* Atribui as variaveis tratadas para o construtor de metricas do dstat*/
                    DstatMetrics dm = new DstatMetrics();
                    dm.setUsed(Float.parseFloat(used));
                    dm.setBuff(Float.parseFloat(buff));
                    dm.setCach(Float.parseFloat(cach));
                    dm.setFree(Float.parseFloat(free));

                   /* System.out.println(used);
                    System.out.println(buff);
                    System.out.println(cach);
                    System.out.println(free);/**/
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void diskMetrics() {
        try {
            Process pr = Runtime.getRuntime().exec("dstat -d 1 0 --float"); /*Executa o processbuilder para execução de comando no cmd  */
            AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>(); /*Converter buffered para variavel atomica */
            buf.set(new BufferedReader(new InputStreamReader(pr.getInputStream())));  /*Atribui o buffread de execução do processbuildes */
            String line = ""; /*Inicia variavel que carregara as linhas do buffread*/

            while ((line = buf.get().readLine()) != null) { /*verifica se o buffread se encontra vazio*/
                //System.out.println(line); /*apenas para testes*/
                String Metrics = line.trim(); /*Atribui a variavel de linha do buffread com o tratamento de espaços desnecessarios*/
                String[] strArray = Metrics.split("  "); /*realiza tratamento de dividir string por espaço em um vetor*/

                if (!Metrics.contains("read  writ") && !Metrics.contains("[7l-dsk/total-")) { /*Tratamento de string tirando os header que vem com o buffreader */
                    for (int i = 0; i < strArray.length; i++) { /*laço para imprimir o string de array após tratamento da string */
                        //  System.out.println( "position" + i + ":" + strArray[i] );
                    }

                    /* Atribui as posições do array list a variaveis*/
                    String read = strArray[0].replace('k', ' ').trim();
                    String writ = strArray[1].replace('k', ' ').trim();

                    /* Atribui as variaveis tratadas para o construtor de metricas do dstat*/
                    DstatMetrics dm = new DstatMetrics();
                    dm.setRead(Float.parseFloat(read));
                    dm.setWrit(Float.parseFloat(writ));

                /*   System.out.println(read);
                   System.out.println(writ);/**/
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void networkMetrics() {
        try {
            Process pr = Runtime.getRuntime().exec("dstat -n 1 0 --float"); /*Executa o processbuilder para execução de comando no cmd  */
            AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>(); /*Converter buffered para variavel atomica */
            buf.set(new BufferedReader(new InputStreamReader(pr.getInputStream())));  /*Atribui o buffread de execução do processbuildes */
            String line = ""; /*Inicia variavel que carregara as linhas do buffread*/

            while ((line = buf.get().readLine()) != null) { /*verifica se o buffread se encontra vazio*/
                // System.out.println(line); /*apenas para testes*/
                String Metrics = line.trim(); /*Atribui a variavel de linha do buffread com o tratamento de espaços desnecessarios*/
                String[] strArray = Metrics.split("   "); /*realiza tratamento de dividir string por espaço em um vetor*/

                if (!Metrics.contains("recv  send") && !Metrics.contains("[7l-net/total-")) { /*Tratamento de string tirando os header que vem com o buffreader */
                    for (int i = 0; i < strArray.length; i++) { /*laço para imprimir o string de array após tratamento da string */
                        //   System.out.println("position" + i + ":" + strArray[i]);
                    }

                    /* Atribui as posições do array list a variaveis*/
                    String recv = strArray[0].trim();
                    String send = strArray[1].trim();

                    /* Atribui as variaveis tratadas para o construtor de metricas do dstat*/
                    DstatMetrics dm = new DstatMetrics();
                    dm.setRecv(Integer.parseInt(recv.trim()));
                    dm.setSend(Integer.parseInt(send.trim()));

                    /*System.out.println(recv);
                    System.out.println(send);/**/
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static String ExecuteScript() throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        String line = "";

        Runnable task = new Runnable() {

            public void run() {
                Process pr = null;
                String line = "";

                try {
                    pr = Runtime.getRuntime().exec("dstat -n 1 0");
                    AtomicReference <BufferedReader> buf = new AtomicReference <BufferedReader>();
                    buf.set(new BufferedReader(new InputStreamReader(pr.getInputStream())));
                    //String line = buf.get().readLine();
                    while ((line = buf.get().readLine()) != null) {
                        System.out.println(line);
                    }
                    // System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        };
        executor.submit(task);
        // }

        executor.shutdown();

        return line;
    }
}
