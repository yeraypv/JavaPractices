/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ranking;
import javax.ejb.Remote;

/**
 *
 * @author yeray
 */
@Remote
public interface ScoreBeanLocal {
    abstract Ranking saveScore(String id, int score); 
}
