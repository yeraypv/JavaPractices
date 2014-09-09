package applet;


import entidades.Ball;
import entidades.Boundary;
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

public class AnimationController extends Thread implements MouseListener{
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
      
    public AnimationController(Drawable e){
        this.escena = e;
        int i= 0;
        Drawable objeto = e.getChild(i);
        while (objeto != null){
            if (objeto instanceof Ball){
                listaBall.add((Ball)objeto);
            }
            objeto = e.getChild(i);
            i++;
        }
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
