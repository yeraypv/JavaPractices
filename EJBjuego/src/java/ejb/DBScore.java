package ejb;

import entidades.Ranking;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */
public class DBScore implements ScoreManager{

    private void salvar(List lista) throws FileNotFoundException, IOException{
        Config dir = new Config();
        FileOutputStream file = new FileOutputStream(dir.dirScore + "Ranking.txt");
            
         ObjectOutputStream out = null;
         
        try {
            out = new ObjectOutputStream (file);
        } catch (IOException ex) {
            Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         System.out.println("Fichero guardado:"+file.toString());
        try {
            out.writeObject(lista); 
        } catch (IOException ex) {
            Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         out.close();
    }

    @Override
    public Ranking loadRanking() {
        try {
            Config dir = new Config();
            String fileNameDir = dir.dirScore + "Ranking.txt";
            
            FileInputStream file = new FileInputStream(fileNameDir);
            
            ObjectInputStream in = new ObjectInputStream(file);

            Object obj1  = in.readObject();
            in.close();
            List li = (List)obj1;
            Ranking ran = new Ranking(li);
            return ran;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBPhase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBPhase.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public void saveScore(String id, Integer score) {
        Ranking ran;
        List  listaid = new ArrayList();
        List listascore = new ArrayList();
        List lresul = new ArrayList();
        List lista = new ArrayList();
        
        ran = loadRanking();
        lista = ran.getScores();
        if(ran!=null){
        if (lista.isEmpty()){
            lresul.add(id);
            lresul.add(score);
            try {
                System.out.println("Lista Salvada");
                salvar(lresul);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            //obtengo las listas
            int cont = 0;
            listaid.clear();
            listascore.clear();
            Object objeto = new Object();
            while(cont < lista.size()){
                objeto = lista.get(cont);
                if(objeto instanceof String){
                    listaid.add(objeto);
                }
                else{
                    listascore.add(objeto);
                }
                cont++;
            }
            
            //ordenamos
            cont = 0;
            Integer r;
            lresul.clear();
            boolean flag = false;
            while(cont<listascore.size()){
                r = (Integer) listascore.get(cont);
                if(score > r && flag==false){
                    lresul.add(id);
                    lresul.add(score);
                    lresul.add((Object)listaid.get(cont));
                    objeto = listascore.get(cont);
                    lresul.add(objeto);
                    flag = true;
                }
                else{
                    lresul.add((Object)listaid.get(cont));
                    objeto = listascore.get(cont);
                    lresul.add(objeto);
                }
                cont++;
            }
            if(flag==false){
                lresul.add(id);
                lresul.add(score);
            }
            
            try {
                salvar(lresul);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }else{
        
        List l = new ArrayList();
        l.add(id);
        l.add(score);
        try {
            salvar(l);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBScore.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        
    }
    
}
