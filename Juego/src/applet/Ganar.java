package applet;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */
public class Ganar extends JApplet {
    private Juego j;
    private Container con;
    private JPanel panelini;
    
    public Ganar(final Juego j, final String ruta){
            this.j = j;
            this.con = getContentPane();
            panelini = new JPanel();

            Image image = j.getImage("fondos/win.jpg");
            JLabel l = new JLabel(new ImageIcon(image));
            con.add(l);
            
            JButton repetir = new JButton("Repetir");
                 
            JButton sig = new JButton("Siguiente");
             
            panelini.add(repetir);
            
            panelini.add(sig);
                
            con.add(panelini,BorderLayout.SOUTH);

            
            sig.addActionListener(new java.awt.event.ActionListener() {    
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    con.removeAll();
                    con.setVisible(false);
                    j.juego(ruta);
                    j.siguiente();
                }
                 
            });
            
                        
            repetir.addActionListener(new java.awt.event.ActionListener() {    
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    j.juego(ruta);
                    
                }
                 
            });
            
            
            
        
    }
    public Container getContainer(){
        return con;
    }
}
