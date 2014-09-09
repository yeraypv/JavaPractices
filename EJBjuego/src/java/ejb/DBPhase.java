/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Drawable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yeray
 */
public class DBPhase implements PhaseLoader{

    @Override
    public Object loadPhase(int p) {
        
        String fase = Integer.toString(p);
        
        System.out.println("PhaseBean num: " + p);
        FileInputStream file;
        try {
            Config dir = new Config();
            file = new FileInputStream(dir.dirPhases + fase.concat(".txt"));
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(file);
                try {
                    Object esphase = in.readObject();
                    in.close();
                    return esphase;
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
 
    }
    
}
