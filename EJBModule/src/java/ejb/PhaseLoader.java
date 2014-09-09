/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Drawable;

/**
 *
 * @author yeray
 */
public interface PhaseLoader {
    abstract Drawable loadPhase(int p);
}
