package yeraysshshutdown;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UserInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author yeray
 */
public class YeraySSHShutdown {

    private static final String usuario = "pi";
    private static final String servidor = "192.168.1.35";
    private static final Integer puerto = 22;
    private static final String clave = "raspberry";

    public static void main(String[] args) throws Exception {
        shutdownRemotePc();        
    }

    private static void shutdownRemotePc() throws IOException, JSchException {
        JSch jSSH = new JSch();
        Session session = jSSH.getSession(usuario, servidor, puerto);
        UserInfo ui = new SesionUsuario(clave, null);
        session.setUserInfo(ui);
        session.setPassword(clave);
        session.connect();

        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand("sudo halt");
        channelExec.connect();
        System.out.println("Señal para Apagado de Raspberry pi...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String linea = null;
        int index = 0;

        while ((linea = reader.readLine()) != null) {
            System.out.println(++index + " : " + linea);
        }
        channelExec.disconnect();
        session.disconnect();
    }


}
