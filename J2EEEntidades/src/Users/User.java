package Users;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeray
 */
public class User {

    private final String username, pass, role;
    private final String iduser;

    private String generateSha256(String string) {
        String password = string;
        MessageDigest sha256 = null;
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sha256.update(password.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] digest = sha256.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(String.format("%02x", digest[i]));
        }
        String hash = sb.toString();
        return hash;
    }

    public User(String params[]) throws NoSuchAlgorithmException {
        this.username = params[0];
        this.pass = params[1];
        this.role = params[2];
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        this.iduser = this.generateSha256(username);
    }
}
