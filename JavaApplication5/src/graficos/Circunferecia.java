/*
 * Fichero: Circulo.java
 * Autor: Chuidiang
 * Fecha: 8/06/07 17:58
 */
package graficos;

import java.awt.Color;
import java.awt.Graphics;


/**
 * Figura Circulo para dibujarlo en LienzoParaArrastrarFiguras
 *
 * @author Chuidiang
 *
  */
public class Circunferecia implements InterfaceFigura
{
    /** 
     * x del centro de la circunferencia
     */
    private int x;

    /** 
     * y del centro de la circunferencia
     */
    private int y;

    /** 
     * color de la circunferencia
     */
    private Color color;

    /** 
     * radio de la circunferencia
     */
    private int radio;

    /**
     * Crea un nuevo objeto Circunferencia.
     *
     * @param x del centro
     * @param y del centro
     * @param radio radio
     * @param color color
     */
    public Circunferecia(int x, int y, int radio, Color color)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.radio = radio;
    }

    /**
     * Se dibuja una circunferencia en el Graphics que se le pasa
     *
     * @param g Graphics con el que dibujar
     */
    public void dibujate(Graphics g)
    {
        g.setColor(color);
        g.drawOval(x - radio, y - radio, 2 * radio, 2 * radio);
    }

    /**
     * Devuelve true si el punto est� contenido dentro de la circunferencia,
     * false en caso contrario
     *
     * @param x x del punto a ver si esta dentro.
     * @param y y del punto a ver si esta dentro.
     *
     * @return true si esta dentro.
     */
    public boolean estaDentro(int x, int y)
    {
        if (
            Math.sqrt(
                    ((this.x - x) * (this.x - x)) +
                    ((this.y - y) * (this.y - y))) < radio)
        {
            return true;
        }

        return false;
    }

    /**
     * Fija el centro de la circunferencia
     *
     * @param x nueva x del centro.
     * @param y nueva y del centro.
     */
    public void setPosicion(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Devuelve la x del centro.
     *
     * @return x del centro
     */
    public int getX()
    {
        return x;
    }

    /**
     * Devuelve la y del centro.
     *
     * @return y del centro
     */
    public int getY()
    {
        return y;
    }
}
