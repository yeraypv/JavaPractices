/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3entidades;

import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class Ranking implements Drawable{
    private List scores;
    
    public Ranking(List l){
        scores = l;
    }
    
    public List getScores(){
        return scores;
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
