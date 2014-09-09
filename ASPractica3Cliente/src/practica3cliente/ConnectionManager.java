/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3cliente;

import practica3entidades.Drawable;

/**
 *
 * @author jorge
 */
public interface ConnectionManager{
    abstract void sendScene(Drawable scene);
    abstract Drawable receiveScene();
}
