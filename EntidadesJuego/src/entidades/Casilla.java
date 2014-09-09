/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yeray
 */
public class Casilla implements Drawable{
    private int x,y,i,j;
  
    private String id;
    private int tam = 70;
     
    private String[] vdir = {"cder.jpg","cizq.jpg","cup.jpg","cdown.jpg"};
    
    private String[] vflechas = {"fder.jpg","fizq.jpg","fup.jpg","fdown.jpg"};
    
    private String[] bonus = {"bonu1.jpg","bonus2.jpg","bonus3.jpg"};
    
    private String[] ebloqueado = {"arbol.jpg","agua.jpg","roca.jpg","bonus1.jpg","meta.jpg"};

    private String rutajuego = "juegos/juego1";
    
    private Score score = new Score();
    
   
    public Casilla(int x, int y, int i, int j, String id,String ruta){
        this.x = x;
        this.y = y;
        this.id = id;
        this.i = i;
        this.j = j;
        this.rutajuego = ruta;
    }
    
    public Boolean esCoche(String n){
        for(int i=0;i<vdir.length;i++){
            if(vdir[i] == n){return true;}
        }
        return false;
    }
    
      
    public Boolean esBonus(String n){
        for(int i=0;i<bonus.length;i++){
            if(bonus[i] == n){return true;}
        }
        return false;
    }
    
    public String getRutaJuego(){
        return rutajuego;
    }
    
    public void setRutaJuego(String ruta){
        this.rutajuego = ruta;
    }
    
    public Boolean esBloqueo(String n){
        for(int i=0;i<ebloqueado.length;i++){
            if(ebloqueado[i] == n){
                return true;
            }
        }
        return false;
    }
    
        
    public Boolean esFlecha(String n){
        for(int i=0;i<vflechas.length;i++){
            if(vflechas[i] == n){return true;}
        }
        return false;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    
    public String getId(){
        return id;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int geti(){
        return i;
    }
    
    public int getj(){
        return j;
    }
    
    public int getTam(){
        return tam;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
     public void setY(int y){
        this.y = y;
    }
    
     public int getScores(){
         return score.getScore();
     }

      
    @Override
    public void render(Graphics g) {
        if(g!=null){
            try {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Image imagenInterna = toolkit.getImage(new URL("http://localhost:8080/ServidorJuego/" + rutajuego + "/" + id));
                //Image imagenInterna = //new ImageIcon(getClass().getResource(id)).getImage();
                g.drawImage(imagenInterna, x, y, null);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Casilla.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
  
    public String evalId(String id, Coche coche){
        if("ces.jpg".equals(id)){
            return coche.getId();
        }
        if("fder.jpg".equals(id)){
            return "cder.jpg";
        }
        if("fizq.jpg".equals(id)){
            return "cizq.jpg";
        }
        if("fup.jpg".equals(id)){
            return "cup.jpg";
        }
        if("fdown.jpg".equals(id)){
            return "cdown.jpg";
        }

        if("arbol.jpg".equals(id)){
            return "crash.jpg";
        }
        
        if("agua.jpg".equals(id)){
            return "splash.jpg";
        }
        
        if("meta.jpg".equals(id)){
            return "ganar";
        }
        return coche.getId();
    }
    
    public String evalCellId(Casilla cell){ 
        String ide = cell.getId();
        if("fder.jpg".equals(ide) || "fizq.jpg".equals(ide) || "fup.jpg".equals(ide) || "fdown.jpg".equals(ide) || "bonus1.jpg".equals(ide) ){
            return "ces.jpg";
        }
        return cell.getId();
    }
    

    @Override
    public Drawable colision(Drawable d) {
        Coche coche = (Coche)d; 
        if( (this.getX()-1 == coche.getX()-1) && (this.getY()-1 == coche.getY()-1) ){
            if("bonus1.jpg".equals(this.id)){
                coche.setScore(1000);
            }
            coche.setId(evalId(this.id,coche));
            this.setId(evalCellId(this));
        }
        return coche;
    }
    
}
