/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author yeray
 */
public class PhaseConnection implements PhaseLoader{
    
    private String jsessionid = null;

    @Override
    public Drawable loadPhase(int p) {  
        try {
            System.out.println(jsessionid);
            Drawable phase = null;
            
                    OutputStream outstream;
         
                    
                    String location = "http://localhost:8080/practicaservlet/PhaseServlet";
                    URL url = new URL(location);
                    
               
                    URLConnection connection;
                     
                    connection = url.openConnection();
             
                        
                        connection.setDoInput(true);
                        connection.setDoOutput(true);
                        connection.setUseCaches(false);
                        connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
                        connection.setRequestProperty("Cookie", "JSESSIONID="+jsessionid);
                        
                   
                        outstream = connection.getOutputStream();
                       
                        ObjectOutputStream s = new ObjectOutputStream(outstream);
                        s.writeObject(String.valueOf(p));
                        s.flush();
                        s.close();
                        
                        InputStream instream = connection.getInputStream();
                        ObjectInputStream e = new ObjectInputStream(instream);
                            if(p==0){
                                String mensaje = (String) e.readObject();
                                System.out.println(mensaje);
                            }
                            else{
                                jsessionid = (String) e.readObject();
                                phase = (Drawable) e.readObject();
                            }
                            
                            e.close();
           
             
                    
           
                return phase;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PhaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }
    
}
