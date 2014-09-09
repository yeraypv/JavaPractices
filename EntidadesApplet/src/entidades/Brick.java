package entidades;


import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author yeray
 */
public class Brick implements Drawable{
    private int width, height, X, Y;
    private Color color;
    private Score pu = new Score();
   
    
    public Brick(int w, int h, int x, int y, Color c){
        this.width = w;
        this.height = h;
        this.X = x;
        this.Y = y;
        this.color = c;
        
    }
    
    public int getX(){return X;}
    public int getY(){return Y;}
    public int width(){return width;}
    public int height(){return height;}
    public Color getColor(){return color;}
    
    public int getScore(){
        return pu.getScore();
    }
    
    @Override
    public void render(Graphics g) {
        //throw new UnsupportedOperationException("Not supported yet.");
        g.setColor(color);
        g.fillRect(X, Y, width, height);
    }

    @Override
    public void add(Drawable d) {
        //throw new UnsupportedOperationException("Not supported yet.");
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

    
   
    //colision de la bola con los briks.
    @Override
    public Drawable colision(Drawable d) {
        Ball b = (Ball)d;
       
        if ((b.getX() + b.getDiameter()>= this.X && b.getX()- b.getDiameter() <= this.X + this.width)&&
            (b.getY()+ b.getDiameter() >= this.Y && b.getY()- b.getDiameter() <= this.Y + this.height)){
            
            if(b.getY() + b.getDiameter() >= this.Y && b.getY() <= this.Y + this.height){
                b.setdY(-b.getdY());
                pu.onCollision(5);
            }
            
            if(b.getX() + b.getDiameter() >= this.X && b.getX() <= this.X + this.width){
                b.setdX(-b.getdX());
                pu.onCollision(5);
            }
        }
        
        //pu.onCollision(1);
        
    
        return d;
    }




}


