package codificatequestions;

import persistenciaenjava.ListaPreguntas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yeray
 */
public class CodificateQuestions {
/*
    private static String normalizador(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public static void generateXml() throws IOException {

        File f = new File("C:/preguntas.txt");
        BufferedReader entrada;
        FileWriter fichero = null;
        PrintWriter pw = null;

        fichero = new FileWriter("d:/questions.xml");
        pw = new PrintWriter(fichero);
        pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.println("<preguntas>");
        int c = 0;
        entrada = new BufferedReader(new FileReader(f));
        String linea;
        pw.println("<pregunta>");
        c = 1;
        while (entrada.ready()) {
            linea = entrada.readLine();
            if (!"".equals(linea)) {
                if (c == 0) {
                    pw.println("<pregunta>");
                }
                if (c == 1) {
                    String lin = "<pregunta nombre=" + '"' + normalizador(linea) + '"' + ">";
                    pw.println(lin);
                }
                if (c == 2) {
                    pw.println("<campo>");
                }
                if (c == 3) {
                    pw.println("<opcion1>" + normalizador(linea) + "</opcion1>");
                }
                if (c == 4) {
                    pw.println("<opcion2>" + normalizador(linea) + "</opcion2>");
                }
                if (c == 5) {
                    pw.println("<opcion3>" + normalizador(linea) + "</opcion3>");
                }
                if (c == 6) {
                    pw.println("<opcion4>" + normalizador(linea) + "</opcion4>");
                }
                if (c == 7) {
                    pw.println("<respuesta></respuesta>");
                    pw.println("</campo>");
                    pw.println("</pregunta");

                }
                if (c == 7) {
                    c = 0;
                } else {
                    c++;
                }
            }
        }
        pw.println("</preguntas>");
        pw.close();
        entrada.close();
    }
*/
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        //generateXml();
        ListaPreguntas lista = new ListaPreguntas();
        lista.generarFicheroPreguntas();
        lista.visualizarFicheroPreguntas();
    }

}
