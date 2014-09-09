package applet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */
  
public interface SceneSaver{ 
        public abstract Object load(String name);
        public abstract Boolean write(String name, Object obj);
}

    
