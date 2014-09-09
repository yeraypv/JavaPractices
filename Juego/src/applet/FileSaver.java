package applet;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class FileSaver implements SceneSaver {

    @Override
    public Object load(String name) {
        //throw new UnsupportedOperationException("Not supported yet.");
        FileInputStream file = null;
        try {
            file = new FileInputStream(name);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(file);
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object obj1 = null;
        try {
            obj1 = in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj1;
    }

    /**
     *
     * @param name
     * @param obj
     * @return
     */
    @Override
    public Boolean write(String name, Object obj) {
        try {
            FileOutputStream file = new FileOutputStream(name);
            ObjectOutputStream out = new ObjectOutputStream (file);
            out.writeObject(obj); 
            out.close();

        return true;
        
        } catch (IOException ex) {
            Logger.getLogger(FileSaver.class.getName()).log(Level.SEVERE, null, ex);
    }
        return false;
    }
    
}
