package MonitorAPI.LogServer;

public class GetMethodname{

    public String getNamemethod(){
        return Thread.currentThread().getStackTrace()[2].getMethodName();  /* Retorna o nome do metodo do contexto atual que foi invocado*/
    }
}
