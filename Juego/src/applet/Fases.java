package applet;


import entidades.Sesion;
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
public class Fases extends JApplet{
     private Juego j;
     private Container con;
     private JPanel panel3;
     private String rutajuego;
     private Sesion sesion;
     
     public Fases(int nivel, final String rutajuego, final Juego j){
            this.j = j;
             
            sesion = j.getSesion();
        
            con = getContentPane();
            panel3 = new JPanel();
            this.rutajuego = rutajuego;
            JButton bant = new JButton("Anterior");
            panel3.add(bant);
            Image image = j.getImage("fondos/fondo3.jpg");
            JLabel l = new JLabel(new ImageIcon(image));
            con.add(l);
            Image imabuton;
            JButton botones[] = new JButton[4];
            String ruta = "";

            for(int i = 0; i< botones.length;i++){

                ruta = "fases/nivel"+ nivel +"/" + i + ".jpg";
                imabuton = j.getImage(ruta);
                botones[i] = new JButton(new ImageIcon(imabuton));
                //panel3.add(botones[i]);
            }
            panel3.add(botones[0]);
            if(sesion.getFase() > 1){
                panel3.add(botones[1]);
                if(sesion.getFase() > 2){
                    panel3.add(botones[2]);
                    if(sesion.getFase() > 3){
                        panel3.add(botones[3]);
                    }
                }
            }
            
            con.add(panel3,BorderLayout.SOUTH);
             //anterior
            bant.addActionListener(new java.awt.event.ActionListener() {
                @Override
                   public void actionPerformed(java.awt.event.ActionEvent evt) {  

                        con.removeAll();
                        con.setVisible(false);
                       // niveles();
                        
                        Niveles nivel = new Niveles(j);
                             
                        
                          
                        con.add(nivel.getContainer());
                             
                          
                        con.setVisible(true);

                   }
               });

            //fase1
            botones[0].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    con.removeAll();
                    con.setVisible(false);
                    j.juego(rutajuego);
                    j.setJuego(sesion.getNivel(), sesion.getFase());
                    
                   
                    
                }
            });

            //fase2 
            botones[1].addActionListener(new java.awt.event.ActionListener() {    
                @Override 
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                     con.removeAll();
                    con.setVisible(false);
                    //juego(rutajuego);
                    j.juego(rutajuego);
                    j.setJuego(sesion.getNivel(), sesion.getFase());
                   
                   
                }

            });

            //fase3
            botones[2].addActionListener(new java.awt.event.ActionListener() {
                @Override 
                public void actionPerformed(java.awt.event.ActionEvent evt) { 
                     con.removeAll();
                    con.setVisible(false);
                    //juego(rutajuego);
                     j.juego(rutajuego);
                    j.setJuego(sesion.getNivel(), sesion.getFase());
                
                   
                }
            });

            //fase4
            botones[3].addActionListener(new java.awt.event.ActionListener() {
                @Override 
                public void actionPerformed(java.awt.event.ActionEvent evt) { 
                    con.removeAll();
                    con.setVisible(false);
                    // juego(rutajuego);
                    j.juego(rutajuego);
                    j.setJuego(sesion.getNivel(), sesion.getFase());
                  
                }
            });
 }
     
     public Container getContainer(){
         return con;
     }
    
}
