/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3entidades;

import java.awt.Graphics;

/**
 *
 * @author Jorge
 */
public class Score implements CollisionListener, Drawable{
    
    private int score = 0;
    
    public int getScore(){
        return score;
    }

    @Override
    public void onCollision(Integer d) {
        score = d;
        //System.out.println(score);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Drawable item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removed(Drawable item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable getChild(int target) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable colision(Drawable item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
