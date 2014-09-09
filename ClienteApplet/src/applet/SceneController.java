package applet;


import entidades.Brick;
import entidades.Drawable;
import entidades.Ranking;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author yeray
 */
public class SceneController{
    private Drawable escena;
    private String fnombre;
    private ConnectionController c;
    private Renderer ren;
    private Controller conc;
    private AnimationController anicontrol;
    private JPanel jpanel;
    
   
    private Graphics g;
    
    private PhaseConnection cphase = new PhaseConnection();
    private Ranking ra;
    private ScoreConnection score;
    private int puntuaciontotal = 0;
    
    public SceneController(Renderer r, Controller conc, AnimationController con, JPanel jpanel, Graphics g, Drawable escena){
      
        this.anicontrol = con;
        this.ren = r;
        this.conc = conc;
        this.jpanel = jpanel;
        this.g = g;
        this.escena = escena;
        
    }
    
    public void detener(){   
        ren.detener();    
        if(conc.isAlive()){
            conc.detener();
        }
        else if(anicontrol.isAlive()){
            anicontrol.detener();
        }
    }
    
    public void siguiente(){
        detener();
        //c = new ConnectionController(fnombre);
        puntuaciontotal += puntuacion();
       // cphase = new PhaseConnection();
        escena = cphase.loadPhase(1);
        ren = new Renderer(g,escena,jpanel);
        ren.start();
        anicontrol = new AnimationController(escena);
        anicontrol.start();
     
    }
    
    public AnimationController Mouse(){
        return anicontrol;
    }

    public int puntuacion(){
        int ite=0;
        int score = 0;
        Drawable elemento = escena.getChild(ite);
        
        Brick b;
        
        while(elemento!=null){
            elemento = escena.getChild(ite);
            if(elemento instanceof Brick){
                b = (Brick)elemento;
                score += b.getScore();
            }
            ite++;
        }
        
        return score;

    }
    
    public String saveScene(Drawable scene) throws MalformedURLException, IOException{
        c = new ConnectionController(fnombre);
        c.sendScene(scene);
        return fnombre;
    }
    
  
    
    public String terminar(String id){
        detener();
        String resul = "Ranking: \n";
        puntuaciontotal += puntuacion();
        cphase.loadPhase(0);
        score = new ScoreConnection();
        Ranking ranki = score.saveScore(id, puntuaciontotal);
        List lresul = ranki.getScores();
        int i=0;
        while(i<lresul.size()){
            if(i%2 == 0){resul+= (String)lresul.get(i) + " ";}
            else{resul += Integer.valueOf(lresul.get(i).toString()) + "\n";}
            i++;
           
        }
        return resul;
        
    }

 
}
