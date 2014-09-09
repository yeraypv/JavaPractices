/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applet;

import entidades.Ranking;

/**
 *
 * @author yeray
 */
public interface ScoreSaver {
    public abstract Ranking saveScore(String id, int score);
}
