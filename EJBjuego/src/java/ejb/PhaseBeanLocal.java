/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author yeray
 */
@Remote
public interface PhaseBeanLocal {
    abstract Object nextPhase(int currentPhase);
    abstract void finish();
}
