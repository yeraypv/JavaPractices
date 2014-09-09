package applet;


import entidades.Casilla;
import entidades.Drawable;
import entidades.Ranking;
import entidades.Score;
import java.awt.Graphics;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.JLabel;
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
    private AnimationController conc;
    private AnimationController anicontrol;
    private JPanel jpanel;
    private Graphics g;
    private PhaseConnection cphase = new PhaseConnection();
    private Ranking ra;
    private ScoreConnection score;
    private int puntuaciontotal = 0;
    private JLabel puntuacion;
    private Score scores;
    
    public SceneController(Renderer r, AnimationController con, JPanel jpanel, Graphics g, Drawable escena,JLabel puntuacion){
      
        this.anicontrol = con;
        this.ren = r;
        //this.conc = conc;
        this.jpanel = jpanel;
        this.g = g;
        this.escena = escena;
        this.puntuacion = puntuacion;
        
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
    
    public void siguiente(int nf){
        //detener();
        //c = new ConnectionController(fnombre);
        //puntuaciontotal += scores.getScore();
       // cphase = new PhaseConnection();
        escena = cphase.loadPhase(nf);
        System.out.println(escena);
        anicontrol.recomenzar(escena);
        ren.recomenzar(escena);
        //ren = new Renderer(g,escena,jpanel);
        //ren.start();
        //anicontrol = new AnimationController(escena,puntuacion);
        //anicontrol.start();
     
    }
    
    public AnimationController Mouse(){
        return anicontrol;
    }


    
    public String saveScene(Drawable scene) throws MalformedURLException, IOException{
        c = new ConnectionController(fnombre);
        c.sendScene(scene);
        return fnombre;
    }
    
  
    
    public String terminar(String id){
       String resul = "Ranking: \n";
        
       if(!"Visualizar".equals(id)){
        
           detener();
        
           puntuaciontotal += scores.getScore();
        
           cphase.loadPhase(0);
       }
       puntuaciontotal = 0;
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
