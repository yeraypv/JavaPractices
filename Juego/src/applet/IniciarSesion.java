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
import javax.swing.JTextField;

/**
 *
 * @author yeray
 */
public class IniciarSesion extends JApplet {
    private Container con;
    private JPanel panelini;
    private Juego j;
    /**
     *
     * @param con
     * @param panelini
     */
    public IniciarSesion(final Juego j){
            this.j = j;
            this.con = getContentPane();
            panelini = new JPanel();

            Image image = j.getImage("fondos/fondo2.jpg");
            JLabel l = new JLabel(new ImageIcon(image));
            con.add(l);
            
            final JLabel label = new JLabel("Identificación de Usuario");
            
            final JTextField usuario = new JTextField("yeray");
             
            final JTextField password = new JTextField("yeray1234");
              
            JButton ace = new JButton("Aceptar");
                 
            JButton can = new JButton("Cancelar");
             
            panelini.add(label);
            
            panelini.add(usuario);
                 
            panelini.add(ace);
                 
            panelini.add(password);
                 
            panelini.add(can);
                 
            con.add(panelini,BorderLayout.SOUTH);
                 
            ace.addActionListener(new java.awt.event.ActionListener() {
                     @Override
                     public void actionPerformed(java.awt.event.ActionEvent evt) {   
                         UserController u = new UserController();
                         Sesion s = new Sesion(usuario.getText(), password.getText()); 
                         //Sesion se = u.verifyUser(s,"verificar");
                         Sesion se = s;
                         System.out.println("Nivel ="  + se.getNivel());
                         System.out.println("Fase ="  + se.getFase());
                         System.out.println("Puntuacion ="  + se.getScore());
                         if(se != null){
                             j.setSesion(se);
                             con.removeAll();
                             con.setVisible(false);
                             Niveles nivel = new Niveles(j);
                             con.add(nivel.getContainer());
                             con.setVisible(true);
                             
                         }
                         else{
                            label.setText("El usuario o la contraseña no existen, vuelva a intentarlo");
                             
                         }
                     }
                 });

    
    }
    public Container getContainer(){
        return this.con;
    }
    
    public JPanel getJPanel(){
        return panelini;
    }
    
}
