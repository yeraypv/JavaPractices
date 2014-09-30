/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3entidades;

import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author jorge
 */
/* Interfaz que usara Composite y sus clases hijas */
public interface Drawable extends Serializable{
    abstract void render(Graphics item);
    abstract void add(Drawable item);
    abstract void removed (Drawable item);
    abstract Drawable getChild(int target);
    abstract Drawable colision(Drawable item);
}
