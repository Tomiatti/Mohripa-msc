package Alocador;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class ComandChannel {
    static Logger log = Logger.getLogger(ComandChannel.class);

    public static String CommandDispatcher(Session session, String Command, String vm) throws IOException, JSchException {
        if (session == null || !session.isConnected()) {
            log.fatal(InetAddress.getLocalHost().getHostName() + "No Session");
            System.out.print("deu BO!!! sem sessão");
            return null;
        }

        ChannelExec channelExec = ( ChannelExec ) session.openChannel("exec");
        channelExec.setCommand(Command + " " + vm);
        channelExec.connect(10000);
      //  System.out.println("Channel 1 opened!");


        InputStream in = channelExec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        int index = 0;

        while ((line = reader.readLine()) != null) {
            System.out.println(++index + " : " + line);
            //        log.info(InetAddress.getLocalHost().getHostName()+ line);
        }/**/ //leitor de linhas que aparecem na maquina


        channelExec.disconnect();

        return line;

    }



}
