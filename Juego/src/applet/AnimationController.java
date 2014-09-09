package applet;


import entidades.Boundary;
import entidades.Casilla;
import entidades.Coche;
import entidades.Drawable;
import entidades.Sesion;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author yeray
 */

public class AnimationController extends Thread implements MouseListener{
    private Graphics g;
    private Drawable escena;
    private Boolean parar = false;
    private List<Casilla> lc = new ArrayList();
    private Casilla cas,c;
    private int x = 0;
    private int y = 0;
    private String re;
    private String[][] mapa1 = new String[8][8];
    private Casilla[][] m = null;
    private int pos2 = 0;
    private Boolean parar2 = false;
    private Boolean gameBusy = false;
    private String[] vdir = {"cder.jpg","cizq.jpg","cup.jpg","cdown.jpg"};
    private String[] vflechas = {"fder.jpg","fizq.jpg","fup.jpg","fdown.jpg"};    
    private int[] numArrows = new int[4];
    private int[] arrows;
    private JLabel p1 = new JLabel("0");  
    private JLabel p2 = new JLabel("0");     
    private JLabel p3 = new JLabel("0");  
    private JLabel p4 = new JLabel("0");
    private Juego juego;
    private JPanel panel1;
    private String ruta;
    private int fder,fizq,fup,fdown;
    private JLabel l;
    private int[] flechas;
    private Coche coche;   
    private int pos = 0;
    private Boundary recinto; 
    private JLabel puntuacion;
    private Sesion sesion;
    private int fase, nivel;
     
    //se podra borrar al descargar la partida.
    public void ini(){
        for(int i=0;i<mapa1.length;i++){
            for(int j=0;j<mapa1[i].length;j++){
                mapa1[i][j] = "ces.jpg"; 
            }
        }

       /* mapa1[0][0]="arbol.jpg";
        mapa1[2][1]="arbol.jpg";
        mapa1[3][1]="arbol.jpg";
        mapa1[4][1]="arbol.jpg";
        mapa1[5][1]="arbol.jpg";
        mapa1[7][1]="arbol.jpg";

        
        mapa1[1][3]="arbol.jpg";
        mapa1[1][4]="arbol.jpg";
        mapa1[1][5]="arbol.jpg";
        mapa1[1][6]="agua.jpg";
        mapa1[1][7]="agua.jpg";
        mapa1[1][8]="agua.jpg";

         
        mapa1[1][8]="arbol.jpg";
        mapa1[2][8]="arbol.jpg";
        mapa1[3][8]="arbol.jpg";
        mapa1[4][8]="arbol.jpg";
        mapa1[5][8]="arbol.jpg";
        mapa1[6][8]="arbol.jpg";
        mapa1[7][8]="arbol.jpg";
        
        mapa1[7][3]="arbol.jpg";
        mapa1[7][4]="arbol.jpg";
        mapa1[7][5]="arbol.jpg";
        mapa1[7][6]="agua.jpg";
        mapa1[7][7]="agua.jpg";
        mapa1[7][8]="agua.jpg";
        
        mapa1[0][9]="meta.jpg";
        mapa1[2][4]="bonus1.jpg";
        mapa1[5][0]="bonus1.jpg";
        mapa1[5][4]="bonus1.jpg";
        mapa1[6][5]="bonus1.jpg";
     */
        mapa1[0][0]="agua.jpg";
        mapa1[0][1]="agua.jpg";
        mapa1[0][5]="bonus1.jpg";
        mapa1[1][3]="bonus1.jpg";
        mapa1[1][0]="meta.jpg";
        mapa1[2][1]="agua.jpg";
        mapa1[2][5]="agua.jpg";
        mapa1[2][6]="arbol.jpg";
        mapa1[2][7]="bonus1.jpg";
        mapa1[3][1]="agua.jpg";
        mapa1[3][4]="agua.jpg";
        mapa1[3][5]="agua.jpg";
        mapa1[3][7]="bonus1.jpg";
        mapa1[4][1]="arbol.jpg";
        mapa1[4][6]="bonus1.jpg";
        
        mapa1[5][2]="bonus1.jpg";
        mapa1[5][3]="arbol.jpg";
        mapa1[5][5]="agua.jpg";
        mapa1[6][3]="arbol.jpg";
 
        mapa1[6][5]="agua.jpg";
        mapa1[6][7]="bonus1.jpg";

    }
    
    public String[][] getMatriz(){
        return mapa1;
    }
    
    public void mover(){
       parar2=true;
  
    }
    
    public int getScoreCar(){
        return coche.getScore();
    }
    
    public void parar(){
        parar2 = false;
    }

    public void detener(){
        parar = true;
    }
    
    
    public AnimationController(Drawable escena, JPanel panel1, String ruta, Juego j, Sesion se){
            ini();
            this.juego = j;
            this.sesion = se;
            this.escena = escena;
            this.ruta = ruta;
            this.panel1 = panel1;
            fase = sesion.getFase();
            nivel = sesion.getNivel();
            puntuacion = new JLabel(String.valueOf(sesion.getScore()));
            recinto = new Boundary(0,0,(8*70),(8*70),ruta);
            fder = 0;
            fizq = 0;
            fup = 0;
            fdown = 0;
            
            Image f1 = j.getImage("flechas/1.jpg");
            JLabel l1 = new JLabel(new ImageIcon(f1));

            Image f2 = j.getImage("flechas/2.jpg");
            JLabel l2 = new JLabel(new ImageIcon(f2));

            Image f3 = j.getImage("flechas/3.jpg");
            JLabel l3 = new JLabel(new ImageIcon(f3));

            Image f4 = j.getImage("flechas/4.jpg");
            JLabel l4 = new JLabel(new ImageIcon(f4));

            panel1.add(puntuacion,BorderLayout.EAST);
            panel1.add(l1,BorderLayout.EAST);
            panel1.add(p1,BorderLayout.EAST);
            panel1.add(l2,BorderLayout.EAST);
            panel1.add(p2,BorderLayout.EAST);
            panel1.add(l3,BorderLayout.EAST);
            panel1.add(p3,BorderLayout.EAST);
            panel1.add(l4,BorderLayout.EAST);
            panel1.add(p4,BorderLayout.EAST);
            int[] flechas = new int[4];
            flechas[0] = 2;
            flechas[1] = 2;
            flechas[2] = 2;
            flechas[3] = 2;
            coche = recinto.initCar(2, 7,"cder.jpg");
            m = recinto.iniciarMapa(mapa1);
            recinto.setArrows(flechas);
            System.out.println(recinto.getWidth());
            this.escena.add(recinto);
            arrows = recinto.getArrows();
            initArrowsLabels();
            
    }
    
    public void recomenzar(Drawable e){
        parar2 = false;
        puntuacion = new JLabel(String.valueOf(sesion.getScore()));
        this.escena = e;
        int i= 0;
        Drawable objeto = e.getChild(i);
        while (objeto != null){
            if (objeto instanceof Boundary){
                recinto = (Boundary)objeto;
            }
            objeto = e.getChild(i);
            i++;
        }

        fder = 0;
        fizq = 0;
        fup = 0;
        fdown = 0;
        
        int[] flechas = new int[4];
        flechas[0] = 2;
        flechas[1] = 2;
        flechas[2] = 2;
        flechas[3] = 1;
        m = recinto.getMatriz();    
         
        arrows = recinto.getArrows();
        inicializeCount();                     
        initArrowsLabels();    
        countArrowsMatrix(); 
        this.escena.add(recinto);
    }
    
    public void initArrowsLabels(){
        p1.setText(String.valueOf(arrows[0]));
        p2.setText(String.valueOf(arrows[1]));
        p3.setText(String.valueOf(arrows[2]));      
        p4.setText(String.valueOf(arrows[3]));
    }
    
    public void inicializeCount(){
        for(int i=0; i<numArrows.length;i++){
            numArrows[i] = 0;
        }
    }
    
    public boolean verifyWin(){
        for(int i=0;i<m.length;i++){
            for(int k=0;k<m[i].length;k++){
                if("bonus1.jpg".equals(m[i][k].getId())){
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public void run(){
        while(!parar){
            try {   
                sleep(10); 
                if(parar2){
                    gameBusy = true;
                    recinto.moveCar();
                    System.out.println(re);
                    for(int i=0;i<m.length;i++){
                        for(int j=0;j<m[i].length;j++){  
                            coche = (Coche)m[i][j].colision(coche);
                            puntuacion.setText(String.valueOf(sesion.getScore() + coche.getScore()));   
                             if("crash.jpg".equals(coche.getId())){
                                  System.out.println("Perdiste crash");
                                  parar2 = false;
                                  Perder pe = new Perder(juego,ruta);
                                  juego.show(pe.getContainer());
                                  parar = true;
                                  return;
                             }

                             if("splash.jpg".equals(coche.getId())){
                                  System.out.println("Perdiste splash");
                                  parar2 = false;
                                  Perder pe = new Perder(juego,ruta);
                                  juego.show(pe.getContainer());
                                  juego.setVisible(true);
                                  parar = true;
                                  return;
                             }
                              
                             if("ganar".equals(coche.getId())){
                                  System.out.println("ganaste meta");
                                  if(verifyWin()){
                                      Sesion s = new Sesion(sesion.getUser(),sesion.getPass());
                                      fase++;
                                      if(fase > 4){
                                          fase = 1;
                                          nivel++;
                                      }
                                      s.setFase(fase);
                                      s.setNivel(nivel);
                                      s.setScore(Integer.parseInt(puntuacion.getText()) + coche.getScore());
                                      UserController user = new UserController();
                                      user.verifyUser(s, "salvar");
                                      Ganar win = new Ganar(juego,ruta);
                                      
                                      juego.show(win.getContainer());
                                      juego.setVisible(true);
                                      return;
                                      
                                  }
                                  else{
                                      Perder pe = new Perder(juego,ruta);
                                      juego.show(pe.getContainer());
                                      juego.setVisible(true);
                                      return;   
                                  }
                             }
                             System.out.println(coche.getId());
                             recinto.setCar(coche);
                         }
                     }    
                    escena.colision(coche);
                }
            } catch (InterruptedException ex) {}
        }
    }
    
    public void countArrows(String id){

        if("fder.jpg".equals(id)){
            numArrows[0]++;
            p1.setText(String.valueOf(arrows[0] - numArrows[0]));
        }
        if("fizq.jpg".equals(id)){
            numArrows[1]++;
            p2.setText(String.valueOf(arrows[1] - numArrows[1]));
        }
        if("fup.jpg".equals(id)){
            numArrows[2]++;
            p3.setText(String.valueOf(arrows[2] - numArrows[2]));
        }
        if("fdown.jpg".equals(id)){
            numArrows[3]++;
            p4.setText(String.valueOf(arrows[3] - numArrows[3]));
        }
    }
    
    public void countArrowsMatrix(){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){         
                countArrows(m[i][j].getId());
            }   
        }
    }
        
    public int idArrows(int pos){
        if(pos == 0){return fder;}
        if(pos == 1){return fizq;}
        if(pos == 2){return fup;}
        if(pos == 3){return fdown;}
        if(pos == 4){return 4;}
        return -1;
    }
      
    @Override
    public void mouseClicked(MouseEvent e) {
        Casilla[][] m = recinto.getMatriz();
        
        coche = recinto.getCar();
        boolean esCoche = false;
        
        arrows = recinto.getArrows();

        if(pos > 4){pos=0;}
        if(pos2 > 3){pos2=0;}
        
        if(gameBusy == false){  
            if ((coche.getX() <= e.getX() && coche.getY() <= e.getY())
                        && (e.getX() <= coche.getX()+70 && e.getY() <= coche.getY()+70 ) ){
                  coche.setId(vdir[pos2]);
                  recinto.setCar(coche);
                  esCoche = true;
                  pos2++;

            }
            if(!esCoche){
                for(int i=0;i<m.length;i++){
                    for(int j=0;j<m[i].length;j++){
                    c = m[i][j];
                        if ((e.getX() <= c.getX() && e.getY() <= c.getY())
                            ||( e.getX()<=c.getX()+c.getTam() && e.getY()<=c.getY()+c.getTam() ) ){

                                if(c.esFlecha(c.getId()) && pos > 3){   
                                    cas = new Casilla(c.getX(),c.getY(),c.geti(),c.getj(),"ces.jpg",ruta);
                                }
                                else{ 
                                    if(c.esBloqueo(c.getId()) == false && pos > 3){
                                            
                                        pos = 0;     
                                            
                                        cas = new Casilla(c.getX(),c.getY(),c.geti(),c.getj(),vflechas[pos],ruta); 
                                    } 
                                        
                                    else{   
                                            
                                        cas = new Casilla(c.getX(),c.getY(),c.geti(),c.getj(),vflechas[pos],ruta);
                                    }  
                          
                                }

                                if(c.esBloqueo(c.getId())){return;}
                                if(pos < 4 && numArrows[pos] != arrows[pos]){
                                    m[i][j] = cas;
                                    m = recinto.copiarMatriz(m);
                                }
                                else{
                                    if(pos == 4){
                                        m[i][j] = cas;
                                        m = recinto.copiarMatriz(m);
                                    }
                                }
                                pos++; 
                                inicializeCount();
                                initArrowsLabels();
                                countArrowsMatrix();
                                return;
   
                        }
                    }  
                }
            }
            
        }
        
    }       
      
    
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
