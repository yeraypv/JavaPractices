package yeraysshshutdown;

import com.jcraft.jsch.UserInfo;

/**
 *
 * @author yeray
 */
/**
 * Contiene los datos se autenticacion del Usuario
 */
public class SesionUsuario implements UserInfo {

    private final String password;
    private final String passPhrase;

    public SesionUsuario(String password, String passPhrase) {
        this.password = password;
        this.passPhrase = passPhrase;
    }

    @Override
    public String getPassphrase() {
        return passPhrase;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean promptPassphrase(String arg0) {
        return true;
    }

    @Override
    public boolean promptPassword(String arg0) {
        return false;
    }

    @Override
    public boolean promptYesNo(String arg0) {
        return true;
    }

    @Override
    public void showMessage(String arg0) {
        System.out.println("SUserInfo.showMessage()");
    }

}
