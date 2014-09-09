/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import entidades.Ranking;
import entidades.Drawable;
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

/**
 *
 * @author yeray
 */
public class ScoreConnection implements ScoreSaver{

    
    @Override
    public Ranking saveScore(String id, int score) {
        try {
            OutputStream outstream = null;
         
            String location = "http://localhost:8080/practicaservlet/ScoreServlet";
                
            URL url = new URL(location);
          
            URLConnection connection = null;
          
            connection = url.openConnection();
         
            connection.setDoInput(true);
          
            connection.setDoOutput(true);
        
            connection.setUseCaches(false);
          
            connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
            
            
            outstream = connection.getOutputStream();
            
            ObjectOutputStream s = new ObjectOutputStream(outstream);
          
            s.writeObject(id);
            
            s.writeObject(String.valueOf(score));
         
            s.flush();
        
            s.close();
            
           
            
            InputStream instream = connection.getInputStream();
           
            ObjectInputStream e = new ObjectInputStream(instream);
            
            Object ran = (Object)e.readObject();

            e.close();
         
            return (Ranking) ran;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScoreConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
