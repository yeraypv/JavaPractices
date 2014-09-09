/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Ranking;

/**
 *
 * @author yeray
 */
public interface ScoreManager {
    public abstract void saveScore(String id, Integer score);
    public abstract Ranking loadRanking();
}
