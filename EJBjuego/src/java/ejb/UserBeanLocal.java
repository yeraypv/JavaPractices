package ejb;
import entidades.Sesion;
import javax.ejb.Remote;

/**
 *
 * @author yeray
 */
@Remote
public interface UserBeanLocal {
    abstract Object verifyUser(Sesion ses);
}