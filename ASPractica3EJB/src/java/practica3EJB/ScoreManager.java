/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import practica3entidades.Ranking;

/**
 *
 * @author Jorge
 */
public interface ScoreManager {
    public abstract void saveScore(String id, Integer score);
    public abstract Ranking loadRanking();
}
