/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author yeray
 */
public class Perder extends JApplet{
    private Juego j;
    private Container con;
    private JPanel panelini;
    
    public Perder(final Juego j, final String ruta){
            this.j = j;
            this.con = getContentPane();
            panelini = new JPanel();

            Image image = j.getImage("fondos/lost.jpg");
            JLabel l = new JLabel(new ImageIcon(image));
            con.add(l);
            
            JButton repetir = new JButton("Repetir");
                 
            JButton salir = new JButton("Salir");
             
            panelini.add(repetir);
            
            panelini.add(salir);
                 
            con.add(panelini,BorderLayout.SOUTH);

            
            salir.addActionListener(new java.awt.event.ActionListener() {    
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    j.crearPrincipal();
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
