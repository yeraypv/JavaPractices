package entidades;



import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author yeray
 */
public class Composite implements Drawable {
    //lista de los elementos drawable.
    private List<Drawable> listaDrawable = new ArrayList();
    
    @Override
    //pintamos todos los elementos.
    public void render(Graphics g) {
        //recorrer la lista de los objetos añadidos a la escena y los pinta llamando a todos los renders.
        for(int k=0;k<listaDrawable.size();k++){
            listaDrawable.get(k).render(g);
        }
    }

    @Override
    //añadimos elementos
    public void add(Drawable d) {
        listaDrawable.add(d);
    }

    @Override
    public void remove(Drawable d) {
        listaDrawable.remove(d);
    }

    @Override
    public Drawable getChild(int i) {
        if(i<listaDrawable.size()){
            return listaDrawable.get(i);
        }
        return null;
    }

    @Override
    public Drawable colision(Drawable d) {
        //recorrer la lista de los objetos añadidos a la escena y llama a todos colision.
        for(int k=0;k<listaDrawable.size();k++){
            listaDrawable.get(k).colision(d);
        }
        return d;
    }
    
}
