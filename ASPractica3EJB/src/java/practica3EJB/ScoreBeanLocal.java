/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import javax.ejb.Remote;
import practica3entidades.Ranking;

/**
 *
 * @author Jorge
 */
@Remote
public interface ScoreBeanLocal {
    abstract Ranking saveScore(String id, int score); 
}
