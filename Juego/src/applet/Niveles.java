/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author yeray
 */
public class Niveles extends JApplet{
    private Container con;
    private JPanel panel2;
    private Juego j;
    private Sesion sesion;
   
    public Niveles(final Juego j){
       
        sesion = j.getSesion();
        
        this.j = j;

     
        con = getContentPane();
     
     
        panel2 = new JPanel();
    

     
        Image image = j.getImage("fondos/fondo3.jpg");
       
     
        JLabel l = new JLabel(new ImageIcon(image));
       
     
        con.add(l);
     
        Image imabuton;
        JButton botones[] = new JButton[4];
        String ruta = "";
        for(int i = 0; i< botones.length;i++){
            ruta = "imanivel/" + i + ".jpg";
            imabuton = j.getImage(ruta);
            botones[i] = new JButton(new ImageIcon(imabuton));
           // panel2.add(botones[i]);
        }

        panel2.add(botones[0]);

        if(sesion.getNivel() >  1){
            panel2.add(botones[1]);
            if(sesion.getNivel() > 2){
                panel2.add(botones[2]);
                if(sesion.getNivel() > 3){
                    panel2.add(botones[3]);
                }
            }
        }
        

        con.add(panel2,BorderLayout.CENTER);
 
     
     //Nivel1
     botones[0].addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent evt) {
             con.removeAll();
             con.setVisible(false);
             //fases(0,"juegos/juego1");
              Fases fases = new Fases(0,"juegos/juego1",j);
              con.add(fases.getContainer());
              con.setVisible(true);
              
         }
     });
     

        //Nivel2 
        botones[1].addActionListener(new java.awt.event.ActionListener() {    
            @Override 
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                   con.removeAll();
                   con.setVisible(false);
                   Fases fases = new Fases(1,"juegos/juego2",j);
                   con.add(fases.getContainer());
                   con.setVisible(true);


            }

        });
          
     //Nivel3
     botones[2].addActionListener(new java.awt.event.ActionListener() {
         @Override 
         public void actionPerformed(java.awt.event.ActionEvent evt) { 
             con.removeAll();
             con.setVisible(false);
            //fases(2,"juegos/juego3");
               Fases fases = new Fases(2,"juegos/juego3",j);
              con.add(fases.getContainer());
              con.setVisible(true);
              
         }
     });

     //Nivel4
     botones[3].addActionListener(new java.awt.event.ActionListener() {
         @Override 
         public void actionPerformed(java.awt.event.ActionEvent evt) { 
             con.removeAll();
             con.setVisible(false);
              Fases fases = new Fases(3,"juegos/juego4",j);
              con.add(fases.getContainer());
              con.setVisible(true);
              
         }
     });
     
     
     
 }
   
    
    public Container getContainer(){
        return con;
    }
 
    
}
