/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import practica3entidades.Ranking;
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
 * @author Jorge
 */
public class ScoreConnection implements ScoreSaver{
    
    private String location = "http://localhost:8080/ASPractica3Servidor/ScoreServlet";
    private URL url = new URL(location);
    private URLConnection connection = url.openConnection();

    public ScoreConnection() throws MalformedURLException, IOException{
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type","application/x-java-serialized-object");
    }

    @Override
    public Ranking saveScore(String id, int score) {
        Ranking rank = null;
        OutputStream outstream;
        try {
            
            outstream = connection.getOutputStream();
            try (ObjectOutputStream s = new ObjectOutputStream(outstream)) {
                s.writeObject(id);
                s.writeObject(String.valueOf(score));
                s.flush();
                s.close();
            }

            InputStream instream = connection.getInputStream();
            try (ObjectInputStream e = new ObjectInputStream(instream)) {
                rank = (Ranking) e.readObject();
                String mensaje = (String) e.readObject();
                System.out.print(mensaje);
                e.close();
            }

            //throw new UnsupportedOperationException("Not supported yet.");
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(ScoreConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rank;
    }
    
}
