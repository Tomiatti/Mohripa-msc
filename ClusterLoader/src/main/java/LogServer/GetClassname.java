package LogServer;

public class GetClassname extends SecurityManager {

    public String getNameClass() {
        return getClassContext()[1].getSimpleName(); /* Retorna o nome da classe que esse metodo seja chamado, ou seja o contexto atual que foi invocado*/
    }

}
