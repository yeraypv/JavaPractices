package applet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.Drawable;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * 
 * @author yeray
 */
public class Renderer extends Thread{

    private boolean parar = false;
    private Drawable escena;
    private Graphics g;
    private JPanel panel;

    
    public Renderer(Graphics g, Drawable escena, JPanel panel){
        
        this.g = g;
        this.escena = escena;
        this.panel = panel;
    }
    
    public void detener(){
        parar = true;
    }

        
    public void iniciar(){
        parar = false;
    }
    
    @Override
    public void run(){
        while(!parar){
            try {
                sleep(15);
                escena.render(g);
                panel.repaint();
            } catch (InterruptedException ex) { }
        }
    }
   
  


}
