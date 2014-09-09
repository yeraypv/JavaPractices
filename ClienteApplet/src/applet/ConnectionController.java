package applet;


import entidades.Drawable;
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
public class ConnectionController implements ConectionManager{
    private String fnombre;
    
    public ConnectionController(String fn){
        this.fnombre = fn;
    }
    
    @Override
    public void sendScene(Drawable scene) {
        try {
            String location = "http://localhost:8080/practicaservlet/SceneServlet";
            URL url = new URL(location);
            URLConnection connection1 = url.openConnection();         
            connection1.setDoInput(true);
            connection1.setDoOutput(true);
            connection1.setUseCaches(false);
            connection1.setRequestProperty("Content-Type", "application/x-java-serialized-object");
            
            OutputStream outstream = connection1.getOutputStream();
            ObjectOutputStream s = new ObjectOutputStream(outstream);
            s.writeObject("Guardar");
            System.out.println(fnombre);
            s.writeObject(fnombre);
            s.writeObject(scene);
            s.flush(); 
            s.close();
            
            InputStream input = connection1.getInputStream();           
            ObjectInputStream s2 = new ObjectInputStream(input);
            String mensaje= (String)s2.readObject();
            System.out.println(mensaje);
            s2.close();
            
            
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    /**
     *
     * @return
     */
    @Override
    public Drawable receiveScene() {
        try {
            Drawable escena = null;
           
                String location = "http://localhost:8080/practicaservlet/SceneServlet";
                URL url = new URL(location);
                URLConnection connection2 = url.openConnection();         
                connection2.setDoInput(true);
                connection2.setDoOutput(true);
                connection2.setUseCaches(false);
                connection2.setRequestProperty("Content-Type", "application/x-java-serialized-object");
                String p = "Cargado";
                OutputStream outstream = connection2.getOutputStream();
                ObjectOutputStream s = new ObjectOutputStream(outstream);
                s.writeObject(p);
                s.writeObject(fnombre);
                s.flush();     
                s.close();
                          
                InputStream input = connection2.getInputStream();     
                ObjectInputStream s3 = new ObjectInputStream(input);   
                escena = (Drawable)s3.readObject();
                System.out.println("Cargado");
                s3.close();
                return escena;
         
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
        
    }
    
}
