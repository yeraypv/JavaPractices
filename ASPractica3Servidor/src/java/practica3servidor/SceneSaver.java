/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3servidor;

/**
 *
 * @author jorge
 */
public interface SceneSaver{
    abstract Object load(String name);
    abstract Boolean write(String name, Object obj);
}
