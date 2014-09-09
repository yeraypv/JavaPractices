/*
 * Fichero: Rectangulo.java
 * Autor: Chuidiang
 * Fecha: 8/06/07 18:08
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Rectangulo para ser arrastrado en un LienzoParaArrastrarFiguras
 *
 * @author Chuidiang
 *
 */
public class Rectangulo implements InterfaceFigura
{
    /**
     * x del rectangulo, esquina superior izquierda
     */
    private int x;

    /**
     * y del rectangulo, esquina superior izquierda
     */
    private int y;

    /**
     * ancho del rectangulo
     */
    private int ancho;

    /**
     * alto del rectangulo
     */
    private int alto;

    /**
     * color del rectangulo
     */
    private Color color;

    /**
     * Crea un nuevo objeto Rectangulo.
     *
     * @param x de la esquina superior izquierda
     * @param y de la esquina superior izquierda
     * @param alto del rectangulo
     * @param ancho del rectangulo
     * @param color de relleno del del rectangulo
     */
    public Rectangulo(int x, int y, int alto, int ancho, Color color)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    /**
     * Dibuja el rectangulo en el Graphics que se le pasa
     *
     * @param g Graphics en el que dibujar
     */
    public void dibujate(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);
    }

    /**
     * Devuelve true si x,y esta dentro del rectangulo, false en caso contrario
     *
     * @param x del punto que se quiere saber si esta dentro del rectangulo
     * @param y del punto que se quiere saber si esta dentro del rectangulo
     *
     * @return true si x,y esta dentro del rectangulo
     */
    public boolean estaDentro(int x, int y)
    {
        if (
            (x > this.x) && (x < (this.x + ancho)) && (y > this.y) &&
                (y < (this.y + alto)))
        {
            return true;
        }

        return false;
    }

    /**
     * Fija la esquina superior izquierda del rectangulo
     *
     * @param x 
     * @param y 
     */
    public void setPosicion(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Devuelve la x de la esquina superior izquierda del rectangulo
     *
     * @return x de la esquina superior izquierda del rectangulo
     */
    public int getX()
    {
        return x;
    }

    /**
     * Devuelve la y de la esquina superior izquierda del rectangulo
     *
     * @return y de la esquina superior izquierda del rectangulo
     */
    public int getY()
    {
        return y;
    }
}
