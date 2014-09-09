/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import javax.ejb.Remote;
import practica3entidades.Drawable;

/**
 *
 * @author Jorge
 */
@Remote
public interface PhaseBeanLocal {
    abstract Drawable nextPhase();
    abstract void finish();
}
