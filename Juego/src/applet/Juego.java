/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import entidades.Composite;
import entidades.Drawable;
import entidades.Sesion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *
 * @author yeray
 */
public class Juego extends JApplet implements MouseListener {
    private Graphics g;
    private Drawable escena;
    private AnimationController c;
    private Renderer ren;
    private JPanel panel1;
    private Container con;
    private String rutajuego;
    private SceneController scene;
    private int fas = 0;
    private JLabel puntuacion;
    private IniciarSesion isesion;
    private int nivel, fase, score;
    private Sesion sesion;
    private PhaseConnection phase = new PhaseConnection();

    public int getNivel(){
        return nivel;
    }
    
    public int getFase(){
        return fase;
    }
    
    public void setSesion(Sesion s){
        this.sesion = s;
    }
    
    public Sesion getSesion(){
        return this.sesion;
    }
    
    
    public void juego(String ruta){
       // this.fase = sesion.getFase();
       // this.nivel = sesion.getNivel();
 
        this.score = sesion.getScore();
        
        System.out.println("fase y Nivel: " + fase + "," + nivel);
        
        escena = new Composite();
        
        g = getGraphics();
        con = getContentPane();
        con.setSize(1000, 1000);
        panel1 = new JPanel();
        resize(1400,900);
        Image image = getImage(getDocumentBase(), "fondos/fondo3.jpg");
        JLabel puntua = new JLabel("Puntuación: ");
        panel1.add(puntua);
        JLabel l = new JLabel(new ImageIcon(image));
        con.add(l);
        con.setVisible(true);
        super.paint(g);
        ren = new Renderer(g,escena,panel1);
        ren.start();
        c = new AnimationController(escena,panel1,ruta,this,sesion);
        c.start();
        crearEscena(panel1); //crea el jpanel y el menu con los botones
        addMouseListener(c);
        scene = new SceneController(ren,c,panel1,g,escena,puntuacion);
    }
    
    public void siguiente(){
        fase++;
        scene.siguiente(fase);
        con.setVisible(true);
    }
 
    public void crearEscena(JPanel panel1){
     con = getContentPane();
     //Botones
     JButton bant = new JButton("Anterior");
     JButton jButton1 = new JButton("Empezar");
     JButton jButton2 = new JButton("Guardar");
     JButton bsig = new JButton("Siguiente");
     JButton terminar = new JButton("Terminar");
     panel1.add(bant);
     panel1.add(jButton2);
     panel1.add(jButton1);
     panel1.add(bsig);
     panel1.add(terminar);

     con.add(panel1,BorderLayout.PAGE_END);
     con.setVisible(true);
     
     //anterior
     final Fases fases = new Fases(fase,rutajuego,this);
     bant.addActionListener(new java.awt.event.ActionListener() {
         @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                 c.detener();
                 ren.detener();
                 con.removeAll();
                 con.setVisible(false);
                 escena = new Composite();
                 escena = null;
                 con.add(fases.getContainer());
                 con.setVisible(true);

            }
        });
     
     //empezar
     jButton1.addActionListener(new java.awt.event.ActionListener() {
         @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                c.mover();
            }
        });
     
     //salvar  
     jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectionController s = new ConnectionController("1.txt");        
                s.sendScene(escena);
                System.out.println("Escena salvada: " + s);
            }
        });

         
     //siguiente        
     bsig.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fase++;
                    scene.siguiente(fase);                    
                }
            }); 
                    
     //terminar      
     terminar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   String ranking = scene.terminar(sesion.getUser());
                   JTextArea ra = new JTextArea(ranking);
                   JPanel panelranking = new JPanel();
                   panelranking.setBounds(0, 0, 800, 600);
                   panelranking.add(ra);
                   con.setVisible(false);
                   Container container2 = getContentPane();
                   container2.add(panelranking, BorderLayout.WEST);
                   container2.setVisible(true);
                }
            }); 
    }

    public void crearPrincipal(){
            con = getContentPane();
            panel1 = new JPanel();
            con.setSize(800, 600);
            panel1.setLayout(null);
               
            Image image = getImage(getDocumentBase(), "fondos/fondo1.jpg");
       
            JLabel l = new JLabel(new ImageIcon(image));
            l.setBounds(0,0,800,600);
            con.add(l);
           
            JButton b1 = new JButton("Iniciar Sesion");
            JButton b2 = new JButton("Registrar");
            JButton b3= new JButton("Ranking");
    
            b1.setBounds(500,100,100,30);
            b2.setBounds(500,150,100,30);
            b3.setBounds(500,200,100,30);
            
            panel1.add(b1);
            panel1.add(b2);
            panel1.add(b3);
            
        
            con.add(panel1);
            con.setVisible(true);
            
            //Iniciar Sesion
            isesion = new IniciarSesion(this);
            b1.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    con.removeAll();
                    con.setVisible(false);
                    con.add(isesion.getContainer());
                    con.setVisible(true);
                }
            });
            
            //Registrar  
            b2.addActionListener(new java.awt.event.ActionListener() {    
            @Override 
            public void actionPerformed(java.awt.event.ActionEvent evt) {
         
                }
               
            });
                 
            //Ranking
            b3.addActionListener(new java.awt.event.ActionListener() {
                @Override 
                public void actionPerformed(java.awt.event.ActionEvent evt) { 
                        
                   scene = new SceneController(ren,c,panel1,g,escena,puntuacion);
                   String ranking = scene.terminar("Visualizar");
                   JTextArea ra = new JTextArea(ranking);
                   JPanel panelranking = new JPanel();
                   
                   panelranking.add(ra);
                   con.setVisible(false);
                   Container container2 = getContentPane();
                   container2.add(panelranking, BorderLayout.WEST);
                   container2.setVisible(true);
                }
            });
    }
 
    public Image getImage(String ruta){
        Image image = getImage(getDocumentBase(), ruta);
        return image;
    }
 
    public void detenerHilos(Drawable e, String ruta){
        this.escena = e;
        ren.detener();
        c.detener();
        c = new AnimationController(e,panel1,ruta,this,sesion);
        addMouseListener(c);
        ren = new Renderer(g,e,panel1);
        ren.start();
        c.start();
    }
 
    public void show(Container co){
        ren.detener();
        c.detener();
        con.removeAll();
        con.setVisible(false);
        con.add(co);
        con.setVisible(true);
 }
    
    public void setJuego(int nivel, int fase){
        if(nivel > 1){
            
            this.rutajuego = "juegos/juego2";
        }
          
        if(nivel > 2){
            fase +=4;
            this.rutajuego = "juegos/juego3";
        }
            
        if(nivel > 3){
            fase +=8;
            this.rutajuego = "juegos/juego4";
        }
        
        this.nivel = nivel;
       
        this.fase = fase;
        
        this.escena = phase.loadPhase(fase);
        scene.siguiente(fase);
        //c.recomenzar(escena);
    }
 
    @Override
    public void init(){
    crearPrincipal();
   // juego("juegos/juego1");
   /*Sesion s = new Sesion("yeray","yeray1234");
    s.setFase(0);
    s.setNivel(1);
    s.setScore(30000);
    FileSaver f = new FileSaver();

    f.write("/Users/gloriav/NetBeansProjects/ServidorJuego/web/usuarios/yeray.txt", s);*/

}

    @Override
    public void mouseClicked(MouseEvent e) {
   // throw new UnsupportedOperationException("Not supported yet.");
}

    @Override
    public void mousePressed(MouseEvent e) {
    //throw new UnsupportedOperationException("Not supported yet.");
}

    @Override
    public void mouseReleased(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {//throw new UnsupportedOperationException("Not supported yet.");}
    
    }
}