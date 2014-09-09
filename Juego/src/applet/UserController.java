package applet;

import entidades.Sesion;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */
public class UserController implements UserManager{
    private Sesion sesionuser;
    @Override
    public Sesion verifyUser(Sesion ses, String info) {
        try {
            String location = "http://localhost:8080/ServidorJuego/Userservlet";
            URL url = new URL(location);
            URLConnection connection1 = url.openConnection();         
            connection1.setDoInput(true);
            connection1.setDoOutput(true);
            connection1.setUseCaches(false);
            connection1.setRequestProperty("Content-Type", "application/x-java-serialized-object");
            
            OutputStream outstream = connection1.getOutputStream();
            ObjectOutputStream s = new ObjectOutputStream(outstream);
            
            System.out.println("Envio de Sesion y ordenes");
            
                s.writeObject(ses);
                s.writeObject(info);
                s.flush(); 
                s.close();

                InputStream input = connection1.getInputStream();           
                ObjectInputStream s2 = new ObjectInputStream(input);
                this.sesionuser = (Sesion)s2.readObject();
                System.out.println(sesionuser);
                s2.close();

                if(sesionuser.getPass().equals(ses.getPass())){
                    return sesionuser;
                }
                return null;

            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
       }
        return null;
    }  
}
