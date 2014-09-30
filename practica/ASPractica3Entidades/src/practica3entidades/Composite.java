/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3entidades;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge 
 */
public class Composite implements Drawable{
    
    private List<Drawable> componentes = new ArrayList();

    /* Se encarga de llamar al render de todos los componentes de la lista,
     siendo contorno, pelota y obstaculo */
    @Override
    public void render(Graphics g) {
        for(int i=0; i<componentes.size(); i++){
            componentes.get(i).render(g);
            if(i==0){g.setColor(Color.red);}
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Drawable item) {
        componentes.add(item);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removed(Drawable item) {
        componentes.remove(item);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable getChild(int target) {
        if(target<componentes.size()){
            return componentes.get(target);
        }else{
            return null;
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /* Se encarga de llamar a colision de todos los componentes de la lista,
     siendo contorno, pelota y obstaculo */
    @Override
    public Drawable colision(Drawable item) {
        for(int i=0; i<componentes.size(); i++){
            componentes.get(i).colision(item);
        }
        return item;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
