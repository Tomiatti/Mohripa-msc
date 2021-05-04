package MonitorAPI.LogServer;

import java.io.IOException;

public class LoggerTimer {

    /*Metodo para pegar o tempo das classes especificas*/

    public static long getStartClass(String classname) throws IOException {
        long start = 0; /* Inicia variavel de start com 0*/

        PermissionLogger pl = new PermissionLogger(); /* Instacia a classe de permissão de log*/
        String properties = pl.getpermissionClass(classname); /* Repassa o nome da classe para pegar a permissão de execução*/

        if (properties.contains("ENABLE")) { /* Verifica se a propriedade contem permissão, caso haja colhe o tempo*/
            start = System.nanoTime(); /* Pega tempo em nanosegundos*/
        }

        return start;
    }

    public static long getEndClass(String classname) throws IOException {
        long end = 0; /* Inicia variavel de end com 0*/

        PermissionLogger pl = new PermissionLogger(); /* Instacia a classe de permissão de log*/
        String properties = pl.getpermissionClass(classname); /* Repassa o nome da classe para pegar a permissão de execução*/

        if (properties.contains("ENABLE")) { /* Verifica se a propriedade contem permissão, caso haja colhe o tempo*/
            end = System.nanoTime(); /* Pega tempo em nanosegundos*/
        }

        return end;
    }


    /*Metodos para pegar o tempo para metodos especificos*/

    public static long getStartMethod(String method) throws IOException {
        long start = 0; /* Inicia variavel de start com 0*/

        PermissionLogger pl = new PermissionLogger(); /* Instacia a classe de permissão de log*/
        String properties = pl.getpermissionMethod(method); /* Repassa o nome do metodo para pegar a permissão de execução*/

        if (properties.contains("ENABLE")) { /* Verifica se a propriedade contem permissão, caso haja colhe o tempo*/
            start = System.nanoTime(); /* Pega tempo em nanosegundos*/
        }


        return start;
    }

    public static long getEndMethod(String method) throws IOException {
        long end = 0; /* Inicia variavel de end com 0*/

        PermissionLogger pl = new PermissionLogger(); /* Instacia a classe de permissão de log*/
        String properties = pl.getpermissionMethod(method); /* Repassa o nome do metodo para pegar a permissão de execução*/

        if (properties.contains("ENABLE")) { /* Verifica se a propriedade contem permissão, caso haja colhe o tempo*/
            end = System.nanoTime(); /* Pega tempo em nanosegundos*/
        }

        return end;
    }

    public static long getStartTimer() throws IOException {
        long start = 0; /* Inicia variavel de start com 0*/

            start = System.nanoTime(); /* Pega tempo em nanosegundos*/

        return start;
    }

    public static long getEndTimer() throws IOException {
        long end = 0; /* Inicia variavel de end com 0*/

            end = System.nanoTime(); /* Pega tempo em nanosegundos*/

        return end;
    }


}
