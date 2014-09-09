/*
 * Fichero: ArrastrarGrafico.java
 * Autor: Chuidiang
 * Fecha: 6/06/07 21:40
 */
package graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import java.util.LinkedList;


/**
 * Ejemplo de gr�fico que se puede arrastrar con el rat�n.
 *
 * @author Chuidiang
 *
 */
public class LienzoParaArrastrarFiguras extends Canvas implements MouseMotionListener
{
    /**
     * serial uid
     */
    private static final long serialVersionUID = -4273648398171436938L;

    /** 
     * Lista de figuras a dibujar.
     */
    private LinkedList<InterfaceFigura> listaFiguras = new LinkedList<InterfaceFigura>();

    /**
     * Si actualmente se est� arrastrando o no el rect�ngulo.
     */
    private InterfaceFigura figuraArrastrandose = null;

    /**
     * x en la que estaba anteriormente el rat�n.
     */
    private int xAnteriorRaton;

    /**
     * y en la que estaba anteriormente el rat�n
     */
    private int yAnteriorRaton;

    /**
     * Crea un nuevo objeto ArrastrarGrafico.
     */
    public LienzoParaArrastrarFiguras()
    {
        addMouseMotionListener(this);
    }

    /**
     * A�ada una figura a la lista de figuras a dibujar
     *
     * @param figura Una nueva figura a dibujar
     */
    public void addFigura(InterfaceFigura figura)
    {
        listaFiguras.add(figura);
    }

    /**
     * Quita la figura en la lista de figuras a dibujar.
     *
     * @param figura figura a quitar de la lista.
     */
    public void removeFigura(InterfaceFigura figura)
    {
        listaFiguras.remove(figura);
    }

    /**
     * Para darle un tama�o por defecto al Canvas de dibujo
     *
     * @return Dimension por defecto.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(500, 500);
    }

    /**
     * Dibuja el rect�ngulo en la posici�n indicada por por xRectangulo e
     * yRectangulo.
     *
     * @param g Graphics con el que dibujar.
     */
    @Override
    public void paint(Graphics g)
    {
        for (InterfaceFigura figura : listaFiguras)
        {
            figura.dibujate(g);
        }
    }

    /**
     * M�todo al que se llama cuando se arrastra el rat�n.
     * Se comprueba con el atributo arrastrando si est� empezando el arrastre o
     * ya se esta en medio del mismo.
     * Si se comienza el arrastre, se guardan las coordenadas del rat�n que
     * vienen en el evento MouseEvent y se cambia el valor del atributo arrastrando.
     * Si se est� en medio de un arrastre, se calcula la nueva posici�n del
     * rect�ngulo y se llama al m�todo repaint() para que se pinte.
     *
     * @param e Evento del rat�n
     */
    public void mouseDragged(MouseEvent e)
    {
        // Si comienza el arrastre ...
        if (figuraArrastrandose == null)
        {
            // Se guardan las posiciones del rat�n
            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();
            // y se marca que ha comenzado el arrastre.
            figuraArrastrandose = dameFigura(e);
        }
        else
        {
            // Si ya hab�a empezado el arrastre, se calculan las nuevas
            // coordenadas del rect�ngulo
            figuraArrastrandose.setPosicion(
                figuraArrastrandose.getX() + (e.getX() - xAnteriorRaton),
                figuraArrastrandose.getY() + (e.getY() - yAnteriorRaton));

            // Se guarda la posici�n del rat�n para el siguiente c�lculo
            xAnteriorRaton = e.getX();
            yAnteriorRaton = e.getY();

            // y se manda repintar el Canvas
            repaint();
        }
    }

    /**
     * Para ver si el rat�n est� dentro del rect�ngulo.
     * Si est� dentro, puede comenzar el arrastre.
     *
     * @param e El evento de rat�n
     *
     * @return true si el rat�n est� dentro del rect�ngulo
     */
    private InterfaceFigura dameFigura(MouseEvent e)
    {
        for (InterfaceFigura figura : listaFiguras)
        {
            if (figura.estaDentro(e.getX(), e.getY()))
            {
                return figura;
            }
        }

        return null;
    }

    /**
     * El rat�n se mueve sin arrastrar. Se marca fin de arrastre.
     *
     * @param e E
     */
    public void mouseMoved(MouseEvent e)
    {
        figuraArrastrandose = null;
    }
}
