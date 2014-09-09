package applet;

import entidades.Sesion;

/**
 *
 * @author yeray
 */
public interface UserManager{ 
        public abstract Sesion verifyUser(Sesion ses, String info);
}
