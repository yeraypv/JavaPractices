/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class FileSaver implements SceneSaver{
    
    /* Lectura del fichero */
    @Override
    public Object load(String name) {
        FileInputStream file;
        try {
            file = new FileInputStream(name);
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(file);
                try {
                    Object scene = in.readObject();
                    in.close();
                    return scene;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;

        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /* Escritura del fichero */
    @Override
    public Boolean write(String name, Object obj) {   
        FileOutputStream file;
        try {
            file = new FileOutputStream(name);
            ObjectOutputStream out;
            
            try {
                out = new ObjectOutputStream (file);
                out.writeObject(obj);
                out.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
