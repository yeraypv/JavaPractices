/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3entidades;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jorge
 */

/* Clase Brick para dibujar obstaculos y calcular la colision */
public class Brick extends Composite implements Drawable{
    
    private int x, y;
    private int alto, ancho;
    Score score = new Score();
    
    public Brick(int x, int y, int alto, int ancho){
        
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;

    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, ancho, alto);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    
    public Score getScore(){
        return score;
    }
    
    /* Teniendo en cuenta las dimensiones del obstaculo con respecto a sus
     puntos de coordenadas, ancho y alto; y despues las coordenadas de la pelota
     y su radio, podemos calcular si colisiona la pelota con el obstaculo */
    @Override
    public Drawable colision(Drawable item) {
        
        Ball ball = (Ball) item;
        
        int dx = ball.getDx();
        int dy = ball.getDy();
        
        //lado superior e inferior
        if( (ball.getX()>=x) && (ball.getX()<=x+ancho) ){
            
            if( (ball.getY()+ball.getRadio()>=y) && (ball.getY()-ball.getRadio()<=y+alto) ){
                ball.setDy(dy*=-1);
                
                score.onCollision(score.getScore()+1);
            }
            
        }
        
        //lado derecho e izquierdo
        if( (ball.getY()>=y) && (ball.getY()<=y+alto) ){
            
            if( (ball.getX()+ball.getRadio()>=x) && (ball.getX()-ball.getRadio()<=x+ancho) ){
                ball.setDx(dx*=-1);
                
                score.onCollision(score.getScore()+1);
            } 
        }
        
        return item;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
