package entidades;

import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */

    public interface Sesiones extends Serializable{
         public abstract void userVerify(String user, String pass);  

}
