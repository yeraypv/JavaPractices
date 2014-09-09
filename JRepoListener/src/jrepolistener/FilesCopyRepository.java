package jrepolistener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author yeray
 */
public class FilesCopyRepository {

    public FilesCopyRepository() {
    }

    public void actualizarRepositorio() {
        FilesCopyRepository f = new FilesCopyRepository();
        File o = new File("C:/repositorio");
        File d = new File("H:/repositorio");
        d.mkdirs();
        System.out.println("Actualizando Archivos");
        try {
            f.CopiarDirectorio(o, d);
        } catch (Exception ex) {
            Logger.getLogger(FilesCopyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CopiarDirectorio(File dirOrigen, File dirDestino) throws Exception {
        try {
            if (dirOrigen.isDirectory()) {
                if (!dirDestino.exists()) {
                    dirDestino.mkdir();
                }

                String[] hijos = dirOrigen.list();
                for (int i = 0; i < hijos.length; i++) {
                    CopiarDirectorio(new File(dirOrigen, hijos[i]),
                            new File(dirDestino, hijos[i]));
                } // end for
            } else {
                Copiar(dirOrigen, dirDestino);
            } // end if
        } catch (Exception e) {
            throw e;
        } // end try
    } // end CopiarDirectorio

    public void Copiar(File dirOrigen, File dirDestino) throws Exception {

        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {
            in.close();
            out.close();
        } // end ty
    } // end Copiar

    public void Copiar(String dirOrigen, String dirDestino) throws Exception {
        InputStream in = new FileInputStream(dirOrigen);
        OutputStream out = new FileOutputStream(dirDestino);

        byte[] buffer = new byte[1024];
        int len;

        try {
            // recorrer el array de bytes y recomponerlo
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            } // end while
            out.flush();
        } catch (Exception e) {
            throw e;
        } finally {

            in.close();
            out.close();
        } // end ty
    } // end Copiar
}
