/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.awt.Graphics;

/**
 *
 * @author yeray
 */
public class Score implements CollisionListener,Drawable{
        
    private Integer Score;
    
    public Score(){
        Score = 0;
    }
    
    public Integer getScore(){
        return Score;   
    }

    @Override
    public void onCollision(Integer d) {
       Score += d;
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Drawable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Drawable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable getChild(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable colision(Drawable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
