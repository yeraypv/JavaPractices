/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import practica3entidades.*;

/**
 *
 * @author jorge
 */
public class Principal extends JApplet{

    /******************************* ATRIBUTOS ********************************/

    private Graphics g;
    private Drawable escena;
    private JPanel panelBotones;
    private SceneController sc;
    
    /******************************* METODOS **********************************/

    @Override
    public void init () {

        //TamaÃƒÂ±o de la ventana JApplet
        setSize(1250,550);

        /* Inicializar escena que es una lista de Drawable y la clase Composite
         se encargara de manejar dicha lista
         Tambien se inicializa g para despues pasarla a Renderer */

        g = getGraphics();
        escena = new Composite();

        /* Iniciar hilos, nada mas comiencen llamaran al metodo run() de cada
         uno y se iran ejecutando hasta que se detenga la aplicacion, habiendo
         unos milisegundos para detener a cada hilo y se aprecie los cambios
         de la pelota
         addMouseListener(controller) es para que pueda darse uso a los eventos
         del raton que hay en Controller. Como Principal tambien tiene
         implementado MouseListener, si quisieramos dar uso de los eventos del
         raton de la clase Principal, seria addMouseListener(this)
         Se pondria this porque es de la propia clase */

        MenuPanel();
        super.paint(g);
        
        Renderer renderer = new Renderer(g, escena, panelBotones);
        renderer.start();
        
        AnimationController animationcontroller = new AnimationController(escena,"Iniciar");
        animationcontroller.start();
        addMouseListener(animationcontroller);
        try {
            sc = new SceneController(g, escena, panelBotones, renderer, animationcontroller);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public void start(){
        /*if(!renderer.isAlive()) {
            escena = new Composite();
            renderer = new Renderer(g, escena, panelBotones);
            renderer.start();
        }
        if(!animationcontroller.isAlive()) {
            animationcontroller = new AnimationController(escena,"Iniciar");
            animationcontroller.start();
            addMouseListener(animationcontroller);
        }*/
    }

    /* CONFIGURAR GUI de MENUPANEL */
    public void MenuPanel(){
       // obtener panel de contenido
       Container contenedor = getContentPane();
       panelBotones = new JPanel();

       // crear y agregar botones
       JButton save = new JButton("Save");
       JButton load = new JButton("Load");
       final JButton next = new JButton("Next");
       JButton score = new JButton("Finish");

       // aÃƒÂ±adimos un TextField junto a los botones
       final JTextField path = new JTextField("ficherodatos");
       panelBotones.add(save);
       panelBotones.add(path);
       panelBotones.add(load);
       panelBotones.add(next);
       panelBotones.add(score);
       final JTextField userfield = new JTextField("iduser");
       panelBotones.add(userfield);

       contenedor.add( panelBotones, BorderLayout.SOUTH );

       setVisible( true );

       /********************** BOTON SALVAR ***********************************/
       save.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               String filename = path.getText();
               if(filename.isEmpty()){
                   filename = "ficherodatos";
               }
               sc.getFileName(filename);
               try {
                   sc.saveScene(escena);
               } catch (MalformedURLException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });

       /********************* BOTON CARGAR *******************************/
       /*load.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               String filename = path.getText();
               if(filename.isEmpty()){
                   filename = "ficherodatos";
               }
               try {
                   sc.loadScene();
                   sc.getFileName(filename);
               } catch (MalformedURLException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       });*/
       
       /********************* SIGUIENTE FASE *******************************/
       next.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               AnimationController ac;
               //next.addActionListener(sc);
               //next.setActionCommand("next");
               try {
                   sc.nextPhaseBean();
               } catch (MalformedURLException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               }
               ac = sc.EventoMouse();
               addMouseListener(ac);

           }
       });
       
       /********************* TERMINAR FASE *******************************/
       score.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               String username = userfield.getText();
               if(username.isEmpty()){
                   username = "username";
               }
               sc.getUserName(username);
               try {
                   String resultranking = sc.saveScoreBean();
                   JTextArea ranking = new JTextArea(resultranking);
                   JFrame env = new JFrame();
                   env.setSize(300, 300);
                   env.add(ranking);
                   env.setVisible(true);
                   
               } catch (MalformedURLException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       });
    }

}
