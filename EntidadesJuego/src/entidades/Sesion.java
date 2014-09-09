/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
/**
 *
 * @author yeray
 */
public class Sesion implements Sesiones{
    private String user,pass;
    private int fase;
    private int nivel;
    private int puntuacion;
    
    public Sesion(String user, String pass){
        this.user = user;
        this.pass = pass;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getPass(){
        return pass;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public int getFase(){
        return fase;
    }
    
    public void setScore(int p){
        this.puntuacion = p;
    }
    
    public int getScore(){
        return this.puntuacion;
    }
    
    public void setFase(int fase){
        this.fase = fase;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    @Override
    public void userVerify(String user, String pass) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
  
}
