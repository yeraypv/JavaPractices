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

    public void recomenzar(Drawable escena){
        this.escena = escena;
    }
        
    public void iniciar(){
        parar = false;
    }
    int x=0;
    int y = 0;
    
    @Override
    public void run(){
        while(!parar){
            try {
                sleep(5);
                escena.render(g);
                panel.repaint();
            } catch (InterruptedException ex) { }
        }
    }


}
