/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author yeray
 */
public interface CollisionListener extends Serializable {
    abstract void onCollision(Integer d);
}
