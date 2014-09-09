package entidades;
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
    private int row= 0;
    private int col = 0;
    private Graphics g;
    private Casilla[][] mapa = null;
    private int[] vArrows = new int[4];
    private Coche coche;
    private String ruta;

    public Boundary(int x, int y, int width, int height, String ruta){
        this.x = x;
        this.y = y;
        this.b_width = width;
        this.b_height = height;
        this.row= 0;
        this.col = 0;
        this.ruta = ruta;
    }
    
    public Casilla[][] iniciarMapa(String[][] m){
        mapa = new Casilla[m.length][m[0].length];
        Casilla ca = null;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[i].length;j++){
               ca = new Casilla(x, y, i, j, m[i][j].toString(),ruta);   
               mapa[i][j] = ca;
               x+=70;
            }
            x=0;
            y+=70;
        }
        row = mapa.length;
        col = mapa[0].length;
        return mapa;
    }
    
    public String getRuta(){
        return ruta;
    }
    
    public void setRuta(String ruta){
        this.ruta = ruta;
    }
    
    public Coche initCar(int i,int j, String d){
        coche = new Coche(i,j,1,1,d);
        return coche;
    }
     
    public Casilla[][] getMatriz(){
        return mapa;
    }
    
    public Coche getCar(){
        return coche;
    }
    
    public void setCar(Coche c){
        this.coche = c;
    }
  
    public void setArrows(int[] vf){
        this.vArrows = vf;
    }
    
    public Casilla[][] copiarMatriz(Casilla[][] m){
           
        for(int i=0;i<mapa.length;i++){
            for(int j=0;j<mapa[i].length;j++){   
               mapa[i][j] = m[i][j];
               
            }
        }
        return mapa;
    }
     
    public String moveCar(){
        coche.move();
        return "move";
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }

    public  int getWidth(){
        return b_width;
    }
   
    public  int getheight(){
        return b_height;
    }

  
    public int[] getArrows(){
        return this.vArrows;
    }

    //colision de las casillas con el contorno
    @Override
    public Drawable colision(Drawable d){
        Coche b = (Coche)d;
        int m_x = b.getX();
        int m_y = b.getY();
        int MaxWidth = this.b_width;
        int MaxHeight = this.b_height;
        
        if(m_x < 0){
            b.setPositionX(m_x+1);
            b.setId("crash.jpg");
        }
        
        if (m_y < 0){
            b.setPositionY(m_y+1);
            b.setId("crash.jpg");
        }
     
       if (m_x + b.getTam() > MaxWidth) { 
            b.setPositionX(m_x);   
            b.setId("crash.jpg");
        }
          
        if (m_y + b.getTam() > MaxHeight) { 
            b.setPositionY(m_y);
            b.setId("crash.jpg");
        }
        
        return d;
    }

    @Override
    //pintamos el contorno.
    public void render(Graphics g){

            for(int i=0; i< mapa.length;i++){
                for(int j=0; j<mapa[i].length;j++){
                    coche.render(g);
                    mapa[i][j].render(g);
                    
                }
            }

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
