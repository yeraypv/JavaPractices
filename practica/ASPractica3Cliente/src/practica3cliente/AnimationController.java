/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import practica3entidades.Ball;
import practica3entidades.Boundary;
import practica3entidades.Brick;
import practica3entidades.Drawable;

/**
 *
 * @author jorge
 */
public class AnimationController extends Thread implements MouseListener{
    
    /* Atributos  */
    
    private boolean stopping;
    
    private ArrayList<Ball> listaBalls = new ArrayList();
    private Ball nuevaBall;
    
    //ArrayList<Drawable> listaBricks = new ArrayList();
    
    private Drawable escena;
    
    /* Metodos */
    
    /* Como vamos a manejar varias pelotas, nos ayudamos de una lista para 
     llamar al metodo move() de cada una (siendo el movimiento), la colision
     con el contorno, obstaculos y otras pelotas */
    @Override
    public void run(){
        while(!stopping){
            try{
                sleep(20);
                for(int i=0;i<listaBalls.size();i++){   
                    listaBalls.get(i).move();
                    escena.colision(listaBalls.get(i));
                }
            }catch(InterruptedException ex){}
        }
    }
    
    AnimationController(Drawable escena, String flag){
        Drawable item;
        this.escena = escena;
        if(flag.equals("Cargar")){
            int cont = 0;
            item = escena.getChild(cont);
            if(item!=null){
                do{
                    item = escena.getChild(cont);
                    if(item instanceof Ball){
                        listaBalls.add((Ball)item);
                    }
                    cont++;
                }while(item!=null);
            }
        }else{
            nuevaBall = new Ball(600, 300, 4, 4, 10);
            listaBalls.add(nuevaBall);
        
            Boundary boundary = new Boundary(0, 0, 500, 1200);
        
            this.escena.add(boundary);
            this.escena.add(nuevaBall);
        
            Brick brick = new Brick(100, 100, 100, 200);
            this.escena.add(brick);
            
        }
    }
    
    public void AcabarHilo(){
        stopping = true;
    }
    
    /* Metodos interfaz MouseListener  */
    
    @Override //Cuando se hace un clic sobre el panel se crea una nueva bola
    public void mouseClicked(MouseEvent e) {
        
        if(e.getX()<1200-10 && e.getY()<500-10){
            Random colorRandom = new Random();
            nuevaBall = new Ball(e.getX(), e.getY(), 4, 4, 10);
            nuevaBall.setColor(new Color(colorRandom.nextInt(256), colorRandom.nextInt(256), colorRandom.nextInt(256)));
            listaBalls.add(nuevaBall);
            escena.add(nuevaBall);
        }
        //throw new UnsupportedOperationException("Not supported yet.");
        
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
