package entidades;


import java.awt.Graphics;
import java.io.Serializable;
/**
 *
 * @author yeray
 */
public interface Drawable extends Serializable{
    public abstract void render(Graphics g);
    public abstract void add(Drawable d);
    public abstract void remove(Drawable d);  
    public abstract Drawable getChild(int i);
    public abstract Drawable colision(Drawable d);

}
