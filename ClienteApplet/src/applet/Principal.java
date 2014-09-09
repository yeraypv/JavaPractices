package applet;

import entidades.Composite;
import entidades.Drawable;
import entidades.Score;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Yeray Perez Valiente
 */
public class Principal extends JApplet implements MouseListener {
    private Graphics g;
    private Drawable escena;
    private Controller c;
    private Renderer ren;
    private AnimationController a; 
    private JPanel panel1;
    private int fase = 0;
    private Score puntuacion = new Score();
    private SceneController scene;

    private Container con;
    
    @Override
    public void init(){
        escena = new Composite();
        g = getGraphics();
        crearEscena();
        super.paint(g);
        ren = new Renderer(g,escena,panel1);
        ren.start();
        c = new Controller(escena);
        c.start();
        addMouseListener(c); 
        scene = new SceneController(ren,c,a,panel1,g,escena);
        this.setSize(800, 600);
                    
    }
  
    public class menu extends JFrame{
        private Drawable escena;
        private String fnombre;
    
        public menu(Drawable scena) {
            this.escena = scena;
            initComponents();
        }
        
   

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

    
            jButton1 = new javax.swing.JButton();
        //    jButton2 = new javax.swing.JButton();
            textField1 = new java.awt.TextField();
            jLabel1 = new javax.swing.JLabel();
            terminar = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jButton1.setText("Salvar");

            //jButton2.setText("Salvar");
            terminar.setText("Terminar");
            
            
            
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        jButton1ActionPerformed(evt);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            /*
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    try {
                        jButton2ActionPerformed(evt);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });*/

            jLabel1.setText("Nombre del Archivo:");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(36, 36, 36)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGap(27, 27, 27))
            );

            pack();
        }// </editor-fold>

        
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, IOException{                                         
            fnombre = textField1.getText();
            /*SceneController s = new SceneController(fnombre);
            Drawable d = s.loadScene();
            detenerHilos(d); */
            ConnectionController guarda = new ConnectionController(fnombre);
            guarda.sendScene(escena);
        }   
       /*
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException, IOException {
            fnombre = textField1.getText();
            SceneController s = new SceneController(fnombre);
            s.saveScene(escena);
        }*/
        
        /**
         * @param args the command line arguments
         */
        public void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //new menu().setVisible(true);
                }
            });
        }
        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel1;
        private java.awt.TextField textField1;
        private javax.swing.JButton terminar;
        // End of variables declaration
    }
    

     
     public void crearEscena(){
         con = getContentPane();
         panel1 = new JPanel();
         
         //Botones
         JButton jButton1 = new JButton("Cargar");
         JButton jButton2 = new JButton("Guardar");
         JButton jButton3 = new JButton("Siguiente");
         JButton terminar = new JButton("Terminar");
         
         //ruta
         JLabel etiqueta = new JLabel("Ruta:");
         final JTextField ruta = new JTextField("id1");
         JLabel etiqueta2 = new JLabel("Id:");
         final JTextField idt = new JTextField("1");
         final JLabel punt = new JLabel("");
         
         
         //panel1.add(etiqueta);
         panel1.add(ruta);
         panel1.add(jButton1);
         panel1.add(jButton2);
         panel1.add(jButton3);
         panel1.add(terminar);
         panel1.add(etiqueta2);
         panel1.add(idt);
         panel1.add(punt);

         con.add(panel1,BorderLayout.SOUTH);
         setVisible(true);
         
                    
        /* jButton1.addActionListener(new java.awt.event.ActionListener() {
             @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) { 
                    String fnombre = ruta.getText();
                    SceneController s = new SceneController(fnombre);
                    Drawable d = s.loadScene();
                    detenerHilos(d);   
                }
            });
            
            */jButton2.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   
                        String fnombre = ruta.getText();
                         //  SceneController s = new SceneController(fnombre);
                        ConnectionController s = new ConnectionController(fnombre);
                        s.sendScene(escena);
                         // s.saveScene(escena);
               
                }
            
                
            }); 
            
            //siguiente        
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
           
                   // scene = new SceneController(ren,c,a,panel1,g,escena);
                    AnimationController as;
                    scene.siguiente();
                    as = scene.Mouse();
                    addMouseListener(as);
                   
                }
            
                
            }); 
            
             //terminar      
            terminar.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   
                   String ranking = scene.terminar(idt.getText());
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
     
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
