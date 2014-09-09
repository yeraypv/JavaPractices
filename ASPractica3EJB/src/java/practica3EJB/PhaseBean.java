/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3EJB;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import practica3entidades.Drawable;

/**
 *
 * @author Jorge
 */
@Stateful
@Remote(PhaseBeanLocal.class)
public class PhaseBean implements PhaseBeanLocal {
    
    private int currentPhase = 1;
    private DBPhase dbphase = new DBPhase();

    @Override
    public Drawable nextPhase() {
        Drawable phase;

        if(currentPhase <5){
            currentPhase = currentPhase+1;
        }else{
            currentPhase = 1;
        }
        System.out.print("Mi fase:");
        System.out.print(currentPhase);
        
        phase = dbphase.loadPhase(currentPhase);
        return phase;
    }

    @Override
    @Remove
    public void finish() {
        System.out.print("Termina sesion Bean");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
