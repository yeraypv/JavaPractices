/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import practica3entidades.Brick;
import practica3entidades.Drawable;
import practica3entidades.Ranking;
import practica3entidades.Score;

/**
 *
 * @author jorge
 */
public class SceneController implements ActionListener{
    private Renderer renderer;
    private AnimationController animationcontroller;
    private PhaseConnection phaseconnection;
    private ScoreConnection scoreconnection;
    private Score score;
    private Graphics graphics;
    private Drawable escena;
    private JPanel panelBotones;
    private String filename, username;
    private int total = 0;
    
    public SceneController(Graphics graphics, Drawable escena, 
            JPanel panelBotones, Renderer renderer, AnimationController animationcontroller) throws MalformedURLException, IOException{
        this.graphics = graphics;
        this.escena = escena;
        this.panelBotones = panelBotones;
        this.renderer = renderer;
        this.animationcontroller = animationcontroller;
        phaseconnection = new PhaseConnection();
        scoreconnection = new ScoreConnection();
    }
            
    public Drawable loadScene() throws MalformedURLException, IOException{
        ConnectionController coneccion = new ConnectionController(filename);
        Interrupcion();
        return coneccion.receiveScene();
    }
    
    public String saveScene(Drawable scene) throws MalformedURLException, IOException{
        ConnectionController coneccion = new ConnectionController(filename);
        coneccion.sendScene(scene);
        return filename;
    }
    
    public void Interrupcion() {
        renderer.AcabarHilo();
        animationcontroller.AcabarHilo();
    }
    
    public void Recomenzar() throws MalformedURLException, IOException{
        renderer = new Renderer(graphics, escena, panelBotones);
        renderer.start();
        animationcontroller = new AnimationController(escena, "Cargar");
        animationcontroller.start();
        EventoMouse();
    }
    
    /*public Drawable loadSceneBean(int flag) throws MalformedURLException, IOException{
        Interrupcion();
        Calcular();
        return phaseconnection.loadPhase(flag);
    }*/
    
    public void nextPhaseBean() throws MalformedURLException, IOException{
        Interrupcion();
        Calcular();
        escena = phaseconnection.loadPhase(1);
        renderer = new Renderer(graphics, escena, panelBotones);
        renderer.start();
        animationcontroller = new AnimationController(escena, "Cargar");
        animationcontroller.start();
        EventoMouse();
    }
    
    public String saveScoreBean() throws MalformedURLException, IOException{
        String resultranking = "Ranking\n"+"..................\n";
        int i=0;
        Interrupcion();
        Calcular();
        phaseconnection.loadPhase(0);
        //System.out.print(total);
        Ranking ranking = scoreconnection.saveScore(username, total);
        List listranking = ranking.getScores();
        
        while(i<listranking.size()){
            if(i%2!=0){
                resultranking = resultranking +  Integer.valueOf(listranking.get(i).toString()) + "\n";
            }else{
                resultranking = resultranking + (String) listranking.get(i) + " ";
            }
            i++;
        }
        resultranking = resultranking + "..................";
        return resultranking;
    }
    
    public void Calcular(){
        Drawable item;
        int cont = 0;
        item = escena.getChild(cont);
        if(item!=null){
            do{
                item = escena.getChild(cont);
                if(item instanceof Brick){
                    Brick brick = (Brick) escena.getChild(cont);
                    score = brick.getScore();
                    total = total + score.getScore();
                }
                cont++;
            }while(item!=null);
        }
    }
    
    public void getFileName(String filename){
        this.filename = filename;
    }
    
    public void getUserName(String username){
        this.username = username;
    }
    
    public int getPoints(){
        return total;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("next")){
            try {
                Recomenzar();
            } catch (MalformedURLException ex) {
                Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public AnimationController EventoMouse() {
        return animationcontroller;
    }

}