/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import javax.ejb.Stateless;
import practica3entidades.Ranking;

/**
 *
 * @author yeray
 */
@Stateless
public class ScoreBean implements ScoreBeanLocal {
    private DBScore puntuacion;

    @Override
    public Ranking saveScore(String id, int score) {
        puntuacion = new DBScore();
        
        puntuacion.saveScore(id, score);
        
        Ranking ra = puntuacion.loadRanking();
        System.out.println(ra);
        return ra;
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
