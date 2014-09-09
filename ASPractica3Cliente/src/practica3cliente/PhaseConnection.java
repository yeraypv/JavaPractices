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
 * @author Jorge
 */
public class PhaseConnection implements PhaseLoader{
    
    private String jsessionid = null;

    @Override
    public Drawable loadPhase(int p) {
        
        System.out.println(jsessionid);

        Drawable phase = null;
        OutputStream outstream;
        
        String location = "http://localhost:8080/ASPractica3Servidor/PhaseServlet";
        URL url = null;
        try {
            url = new URL(location);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PhaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        URLConnection connection;
        try {
            
            connection = url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
            connection.setRequestProperty("Cookie", "JSESSIONID="+jsessionid);
            
            try {
            outstream = connection.getOutputStream();
            try (ObjectOutputStream s = new ObjectOutputStream(outstream)) {
                s.writeObject(String.valueOf(p));
                s.flush();
                s.close();
            }
            
            InputStream instream = connection.getInputStream();
            try (ObjectInputStream e = new ObjectInputStream(instream)) {
                if(p!=0){
                    jsessionid = (String) e.readObject();
                    phase = (Drawable) e.readObject();
                    System.out.println(phase);
                    System.out.println(jsessionid);
                }else{
                    String mensaje = (String) e.readObject();
                    System.out.println(mensaje);
                }
                
                e.close();
            }
            
            } catch (ClassNotFoundException | IOException ex) {
                Logger.getLogger(PhaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(PhaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return phase;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
