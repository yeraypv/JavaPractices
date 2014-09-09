package ejb;
import javax.ejb.Remote;

/**
 *
 * @author yeray
 */
@Remote
public interface UserBeanInterface {
    abstract Object verifyUser(String user, String password);
}