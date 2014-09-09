package entidades;


import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Coche implements Drawable{
    
    private int m_x = 0;           
    private int m_y = 0;
    private int dX = 0;   
    private int dY = 0;
    private int m_width = 0;  
    private int m_height = 0;
    private String id = "";
    private int tam = 70;
    private Score score = new Score();

    
    //constructor de la pelota, coordenadas x,y de inicio y direccion de la bola.
    public Coche(int x, int y, int dX, int dY, String id) {
        this.m_x = x * tam;
        this.m_y = y * tam;
        this.dX = dX;
        this.dY = dY;
        this.id = id;
        

    }
    
    //movimiento de la bola y de rebote contra el recinto.
    public void move() {
        if("cder.jpg".equals(this.id)){
            m_x++;
        }
        if("cizq.jpg".equals(this.id)){
            m_x--;
        }
        if("cup.jpg".equals(this.id)){
            m_y--;
        }
        if("cdown.jpg".equals(this.id)){
            m_y++;
        }
    }

    //obtener datos
    //ancho maximo    
    public int getMaxWidth(){return m_width;}
    
    //alto maximo
    public int getMaxHeight(){return m_height;}

    public String getId(){
        return id;
    }

    public void setScore(int s){
        this.score.onCollision(s);
    }
    
    public int getScore(){
        return score.getScore();
    }
    
    //obtengo la coordenada de x
    public int  getX(){ return m_x;}
    
    //obtengo la coordenada de y
    public int  getY(){ return m_y;}
    
    //obtengo la direccion de x
    public int getdX(){ return dX;}
    
    //obtengo la direccion de y
    public int getdY(){ return dY;}

    //configuracion
    
    //Configurar posicion inicial de la bola x.
    public void setPositionX (int x) {
        this.m_x = x;
    }
    //Configurar posicion inicial de la bola y
    public void setPositionY (int y){
        this.m_y = y;
    }
    //Configurar la direccion de x
    public void setdX (int dx) {
        this.dX = dx;
    }
    //Configurar la direccion de y
    public void setdY (int dy){
        this.dY = dy;
    }
    
    public void setId(String id){
        this.id = id;
    }
 
    public int getTam(){
        return tam;
    }
    

    @Override
    public void render(Graphics g){
        if(g!=null){
            try {
                //Image imagenInterna = new ImageIcon(getClass().getResource(id)).getImage();
                     
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                    
                Image imagenInterna = toolkit.getImage(new URL("http://localhost:8080/ServidorJuego/imagenes/"+id));
                g.drawImage(imagenInterna, m_x, m_y, null);
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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

    

    @Override
    public Drawable colision(Drawable d) {
        return d;
    }
         
}

