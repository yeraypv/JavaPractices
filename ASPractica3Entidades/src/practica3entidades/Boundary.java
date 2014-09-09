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

/* Clase Boundary para dibujar el contorno y calcular la colision con las pelotas*/
public class Boundary extends Composite implements Drawable{
    
    private int x, y;
    private int alto, ancho;
    
    public Boundary(int x, int y, int alto, int ancho){
        
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;

    }
    
    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.white);
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.black);
        g.drawRect(x, y, ancho, alto);

        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /* Calcula la posicion de la pelota y comprueba si puede o no superar los
     limites del contorno */
    @Override
    public Drawable colision(Drawable item) {
        
        Ball ball = (Ball) item;
        
        int dx = ball.getDx();
        int dy = ball.getDy();
        
        
        if (ball.getX() > ancho-ball.getRadio()*2 || ball.getX()-ball.getRadio() < x) {
            ball.setDx(dx*=-1);
        }
        
        if (ball.getY() > alto-ball.getRadio()*2 || ball.getY()-ball.getRadio() < y) {
            ball.setDy(dy*=-1);
        }
        
        return item;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
