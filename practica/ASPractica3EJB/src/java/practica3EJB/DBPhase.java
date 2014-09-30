/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica3entidades.Drawable;

/**
 *
 * @author Jorge
 */
public class DBPhase implements PhaseLoader{

    @Override
    public Drawable loadPhase(int p) {
        
        String name = Integer.toString(p);
        
        FileInputStream file;
        try {
            file = new FileInputStream(name.concat(".txt"));
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(file);
                try {
                    Object esphase = in.readObject();
                    in.close();
                    return (Drawable)esphase;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DBPhase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(DBPhase.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBPhase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
