package practica3entidades;

import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */

/* Clase Ball para dibujar la pelota y calcula colision con otras pelotas */
public class Ball extends Composite implements Drawable{
    
    private float x, y;
    private int dx, dy;
    private float radio;
    private Color color;
    
    public Ball(float x, float y, int dx, int dy, float radio){
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.dx = dx;
        this.dy = dy;
    }
    
    public void move(){
        x += dx;
        y += dy;
    }
    
    public float getX(){ 
        return x;
    }
    
    public float getY(){ 
        return y;
    }
    
    public float getRadio(){ 
        return radio;
    }
    
    public int getDx(){
        return dx;
    }
    
    public int getDy(){
        return dy;
    }
    
    public void setDx(int dx){
        this.dx = dx;
    }
    
    public void setDy(int dy){
        this.dy = dy;
    }
    
    public void setColor(Color c){
        color = c;
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int)(x-radio), (int)(y-radio), (int)radio*2, (int)radio*2);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /* Calcula la colision teniendo en cuenta la posicion y radio de la pelota, 
     con el resto. Se hace uso del punto medio y se invierte los desplazamientos
     de las bolas que colisionan */
    @Override
    public Drawable colision(Drawable item) {
        
        Ball ball = (Ball) item;
        
        int desx = ball.getDx();
        int desy = ball.getDy();
        
        float calculo, resta1, resta2;
        
        resta1 = Math.abs(this.getX()-ball.getX());
        resta1 *= resta1;
        resta2 = Math.abs(this.getY()-ball.getY());
        resta2 *= resta2;
        
        calculo = (float) Math.sqrt(resta1+resta2);
        
        if(calculo <= radio*2){
            ball.setDx(this.dx);
            ball.setDy(this.dy);
            
            this.dx = desx;
            this.dy = desy;
        }
        
        return item;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}