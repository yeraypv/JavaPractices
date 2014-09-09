/*
 * Fichero: AppletEjemplo.java
 * Autor: Chuidiang
 * Fecha: 8/06/07 18:07
 */
package graficos;

import java.awt.Color;

import javax.swing.JApplet;


/**
 * Applet de ejemplo con un LienzoParaArrastrarFiguras con tres rectangulos y tres
 * circunferencias.
 *
 * @author Chuidiang
 *
  */
public class AppletEjemplo extends JApplet
{
    /**
     * serial uid
     */
    private static final long serialVersionUID = -883268879068691460L;

    /**
     * Construye el applet, metiendo el lienzo con las figuras.
     */
    public void init()
    {
        LienzoParaArrastrarFiguras c = new LienzoParaArrastrarFiguras();
        c.addFigura(new Rectangulo(2, 3, 50, 33, Color.RED));
        c.addFigura(new Rectangulo(7, 22, 150, 10, Color.GREEN));
        c.addFigura(new Rectangulo(11, 44, 20, 100, Color.CYAN));
        c.addFigura(new Circunferecia(6, 8, 34, Color.YELLOW));
        c.addFigura(new Circunferecia(34, 8, 55, Color.WHITE));
        c.addFigura(new Circunferecia(64, 8, 22, Color.BLUE));
        add(c);
    }
}
