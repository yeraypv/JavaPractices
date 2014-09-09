package entidades;


import java.awt.*;

public class Ball implements Drawable{
    
    private int diametro;
    private int m_x;           
    private int m_y;
    private int dX;   
    private int dY;
    private int m_width;  
    private int m_height;
    private Color colory;
    
    //constructor de la pelota, coordenadas x,y de inicio y direccion de la bola.
    public Ball(int x, int y, int dX, int dY, int diametro) {
        this.m_x = x;
        this.m_y = y;
        this.dX = dX;
        this.dY = dY;
        this.diametro = diametro;
    }
    
    //movimiento de la bola y de rebote contra el recinto.
    public void move() {
            m_x += dX;
            m_y += dY;
    }

    //obtener datos
    //ancho maximo    
    public int getMaxWidth(){return m_width;}
    
    //alto maximo
    public int getMaxHeight(){return m_height;}

    //obtengo el diametro de la bola
    public int  getDiameter() { return diametro;}
    
    //obtengo la coordenada de x
    public int  getX(){ return m_x;}
    
    //obtengo la coordenada de y
    public int  getY(){ return m_y;}
    
    //obtengo la direccion de x
    public int getdX(){ return dX;}
    
    //obtengo la direccion de y
    public int getdY(){ return dY;}

    //configuracion
    
    //ancho y alto del recinto valido donde rebota la bola.
    public void setBoundaryBall(int width, int height) {
        m_width  = width  - diametro;
        m_height = height - diametro;
    }
    
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
    
    //Configurar color de la bola.
    public void setColor(Color c){
        this.colory = c;
    }
    
    //Configurar diametro de la bola
    public void setDiameter(int d){
        this.diametro = d;
    }
    

    //Interfaz drawable.
    //pinta la bola en la escena con un color determinado.
    @Override
    public void render(Graphics g){
        g.setColor(colory);
        g.fillOval(m_x, m_y, diametro, diametro);
        
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

    //Colision entre bolas.
    @Override
    public Drawable colision(Drawable d) {
        Ball b = (Ball)d;
        //distancia entre dos puntos
        double pmx = this.m_x - b.getX();
        double pmy = this.m_y - b.getY();
        
        //sqrt((x2-x1)^2 + (y2-y1)^2)
        double distancia = Math.sqrt((pmx*pmx)+(pmy*pmy));

        if(distancia < (diametro/2)){
            b.setdX(-b.dX);
            b.setdY(-b.dY);
            this.setdY(-this.getdY());
            this.setdX(-this.getdX());
        }

        return null;
    }

         
}

