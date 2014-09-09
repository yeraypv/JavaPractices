/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Drawable;
import javax.ejb.Remote;

/**
 *
 * @author yeray
 */
@Remote
public interface PhaseBeanLocal {
    abstract Drawable nextPhase();
    abstract void finish();
}
