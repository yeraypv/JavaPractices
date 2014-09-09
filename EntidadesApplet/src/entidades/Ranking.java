/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author yeray
 */
public class Ranking implements Drawable{
    private List Scores;
    
    public Ranking(List l){
        this.Scores = l;
    }
    
    public List getScores(){
        return Scores;
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
