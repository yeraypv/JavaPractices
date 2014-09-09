/*
 * Fichero: InterfaceFigura.java
 * Autor: Chuidiang
 * Fecha: 8/06/07 18:02
 */
package graficos;

import java.awt.Graphics;


/**
 * Interface comun para todas las figuras que se pueden dibujar y arrastrar con 
 * el rat�n en LienzoParaArrastrarFiguras.
 *
 * @author Chuidiang
 * 
  */
public interface InterfaceFigura
{
    /**
     * Debe devolver true si x,y est� dentro de la figura, false en caso contrario
     *
     * @param x 
     * @param y 
     *
     * @return true si x,y est� dentro de la figura
     */
    public boolean estaDentro(int x, int y);

    /**
     * Fija la posici�n en la que se debe dibujar la figura
     *
     * @param x 
     * @param y 
     */
    public void setPosicion(int x, int y);

    /**
     * Devuelve la x en la que se dibuja la figura
     *
     * @return x de la figura
     */
    public int getX();

    /**
     * Devuelve la y en la que se dibuja la figura
     *
     * @return y de la figura
     */
    public int getY();

    /**
     * Dibuja la figura en el Graphics que se le pasa, en la posicion x,y que se
     * indico por medio de setPosicion()
     *
     * @param g Graphics con el que dibujar.
     */
    public void dibujate(Graphics g);
}
