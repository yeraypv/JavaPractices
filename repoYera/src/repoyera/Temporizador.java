package repoyera;

import java.io.File;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temporizador {

    public String getDates() {
        Calendar calendario = Calendar.getInstance();
        return calendario.get(Calendar.DAY_OF_MONTH) + "_" + calendario.get(Calendar.MONTH) + "_" + calendario.get(Calendar.YEAR);
    }

    public String getHours() {
        Calendar calendario = Calendar.getInstance();
        return calendario.get(Calendar.HOUR_OF_DAY) + "_" + calendario.get(Calendar.MINUTE) + "_" + calendario.get(Calendar.SECOND);
    }

    public void copiaHora() {
        FilesCopyRepository f = new FilesCopyRepository();
        File o = new File("C:/repositorio");
        File d = new File("H:/copias/horas/" + this.getDates() + "/copia_" + this.getHours());
        d.mkdirs();
        System.out.println("Copia por horas iniciado");
        try {
            f.CopiarDirectorio(o, d);
        } catch (Exception ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void copiaRegresiva() {
        FilesCopyRepository f = new FilesCopyRepository();
        File o = new File("C:/repositorio");
        String dir = "H:/copias/regresivas/" + this.getDates() + "/copia_" + this.getHours();
        File d = new File(dir);
        d.mkdirs();
        System.out.println("Copia regresiva iniciado");
        try {
            f.CopiarDirectorio(o, d);
        } catch (Exception ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
