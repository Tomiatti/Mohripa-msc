package MonitorAPI.LogServer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetData {

    public static String getDatanow() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss:SS");
        Date hora = new Date();
        String Hora = formatador.format(hora);
        // String.valueOf( LocalDateTime.now() );
        return Hora; /* Retorna a horario e data do exato momento que foi invocado*/
    }

}
