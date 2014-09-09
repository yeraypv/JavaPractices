/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica3entidades.Drawable;

/**
 *
 * @author jorge
 */
public class ConnectionController implements ConnectionManager{
    
    private String location = "http://localhost:8080/ASPractica3Servidor/SceneServlet";
    private URL url = new URL(location);
    private URLConnection connection = url.openConnection();
    private String filename;

    public ConnectionController(String filename) throws MalformedURLException, IOException{
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
        this.filename = filename;
    }

    @Override
    public void sendScene(Drawable scene){
        OutputStream outstream = null;
        try {
            outstream = connection.getOutputStream();
            ObjectOutputStream s = new ObjectOutputStream(outstream);
            s.writeObject("salvar");
            s.writeObject(filename);
            s.writeObject(scene);
            s.flush();
            s.close();
            InputStream instream = connection.getInputStream();
            ObjectInputStream e = new ObjectInputStream(instream);
            String recibir = (String) e.readObject();
            e.close();
            System.out.println(recibir);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outstream.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Drawable receiveScene() {
        Drawable escena = null;
        OutputStream outstream = null;
        try {
            outstream = connection.getOutputStream();
            ObjectOutputStream s = new ObjectOutputStream(outstream);
            s.writeObject("cargar");
            s.writeObject(filename);
            s.flush();
            s.close();
            InputStream input = connection.getInputStream();
            ObjectInputStream e = new ObjectInputStream(input);
            escena = (Drawable) e.readObject();
            e.close();
            return escena;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outstream.close();
            } catch (IOException ex) {
                Logger.getLogger(ConnectionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return escena;
    }

}