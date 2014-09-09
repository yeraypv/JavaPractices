/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import java.awt.Graphics;
import javax.swing.JPanel;
import practica3entidades.Drawable;

/**
 *
 * @author jorge
 */
public class Renderer extends Thread{
    
    /* Atributos  */
    
    private boolean stopping;
    private Drawable escena;
    private Graphics g;
    private JPanel MyPanel;
    
    /* Metodos */
    
    /*Como la clase composite se encargara de llamar a todos los render de sus
    clases hijas, pero para que puedan ser llamados continuamente debe ser
    con escena.render(g) dentro de este hilo */
    
    @Override
    public void run(){
        while(!stopping){
            try{
                sleep(15);
                escena.render(g);
                MyPanel.repaint();
            }catch(InterruptedException ex){}
        }
    }
     
    Renderer(Graphics g, Drawable escena, JPanel MyPanel){
        this.g = g;
        this.escena = escena;
        this.MyPanel = MyPanel;
    }
    
    public void AcabarHilo(){
        stopping = true;
    }
    
}
