package applet;


import entidades.Ball;
import entidades.Boundary;
import entidades.Brick;
import entidades.Drawable;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author yeray
 */

public class Controller extends Thread implements MouseListener{
    private Graphics g;
    private Drawable escena;
    private Boolean parar = false;
    private int radio = 30;
    
    private Boundary recinto = new Boundary(0,0,800,600, Color.BLACK);
    private List<Ball> listaBall = new ArrayList();
    private Random c = new Random();

    //contorno y bola.
  
    public void detener(){
        parar = true;
    }
    @Override
    public void run(){
         while(!parar){
            try {
                
                for(int i=0;i<listaBall.size();i++){   
                    listaBall.get(i).move();
                    escena.colision(listaBall.get(i));
                }

                sleep(20);  // milisegundos
            } catch (InterruptedException ex) { }
        }
    }
      
    public Controller(Drawable escena){
        //construimos los elementos en la escena.
        Brick b1 = new Brick(100,70,130,100,Color.GREEN);
        
        Brick b2 = new Brick(100,70,530,100,Color.RED);
        
        Brick b3 = new Brick(100,70,330,300,Color.ORANGE);
         
        Brick b4 = new Brick(100,70,30,400,Color.YELLOW);
        
        Brick b5 = new Brick(100,70,600,400,Color.MAGENTA);
        
        this.escena = escena; 
        this.escena.add(recinto);
        
        this.escena.add(b1);
        this.escena.add(b2);
       // this.escena.add(b3);
       // this.escena.add(b4);
       // this.escena.add(b5);

    }
            
    public void iniciar(){
        parar = false;
    }
   
    public void destruirListaBolas(){
        listaBall.removeAll(listaBall);
    }
    
    public Color getRandomColor() {
      return new Color(c.nextInt(256), c.nextInt(256), c.nextInt(256));
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        int x = e.getX();
        int y = e.getY();
        if(x <= recinto.getWidth() - radio && y <= recinto.getheight() - radio){
            Ball b = new Ball(x,y,3,3,radio);
            b.setDiameter(radio);
            b.setColor(getRandomColor());
            b.setBoundaryBall(800, 600);
            listaBall.add(b);      
            escena.add(b);
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
