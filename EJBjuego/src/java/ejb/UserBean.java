/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Sesion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author yeray
 */
@Stateless
@Remote(UserBeanLocal.class)
public class UserBean implements UserBeanLocal{

    @Override
    public Object verifyUser(Sesion ses) {
        
        FileInputStream file;
        try {
            Config dir = new Config();
            file = new FileInputStream(dir.dirUsers + ses.getUser() + ".txt");
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(file);
                try {
                    Object contenido = (Object) in.readObject();
                    in.close();

                    Sesion se = (Sesion) contenido;
                    if(se.getPass().equals(ses.getPass())){
                        return contenido;
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "invalido";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
