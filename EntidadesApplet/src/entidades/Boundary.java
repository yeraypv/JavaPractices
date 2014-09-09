package entidades;


import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author yeray
 */
public class Boundary implements Drawable{
    private int x;
    private int y;
    private int b_width;
    private int b_height;
    private Color color = Color.WHITE;
    
    //contructor del contorno del recinto donde bota la bola  
    public Boundary(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.b_width = width;
        this.b_height = height;
    }
    
    //contructor del contorno con un color determinado
    public Boundary(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.b_width = width;
        this.b_height = height;
        this.color = color;
    }
    
    public  int getWidth(){
        return b_width;
    }
    public  int getheight(){
        return b_height;
    }

    //colision de las bolas con el contorno
    @Override
    public Drawable colision(Drawable d){
        Ball b = (Ball)d;
        int m_x = b.getX();
        int m_y = b.getY();
        int m_dX = b.getdX();
        int m_dY = b.getdY();
        int MaxWidth = b.getMaxWidth();
        int MaxHeight = b.getMaxHeight();
        
       
        if (m_x < this.x) {                
            b.setPositionX(this.x);           
            b.setdX(-m_dX); 
            
        } else if (m_x >= MaxWidth) { 
            b.setPositionX(MaxWidth);   
            b.setdX(-m_dX);
        }
        
        if (m_y < this.y) {                
            b.setPositionY(this.y);
            b.setdY(-m_dY); 
            
        } else if (m_y >= MaxHeight) { 
            b.setPositionY(MaxHeight);
            b.setdY(-m_dY);
        }
        
        return d;
    }

    @Override
    //pintamos el contorno.
    public void render(Graphics g){
        g.setColor(this.color);
        g.fillRect(x, y, b_width, b_height);
    }

    @Override
    public void add(Drawable d) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Drawable d) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Drawable getChild(int i) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }
}
