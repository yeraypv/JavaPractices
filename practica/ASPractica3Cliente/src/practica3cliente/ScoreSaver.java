/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import practica3entidades.Ranking;

/**
 *
 * @author Jorge
 */
public interface ScoreSaver {
    abstract Ranking saveScore(String id, int score);
}
