/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practica3entidades.Drawable;

/**
 *
 * @author jorge
 */
@WebServlet(name = "SceneServlet", urlPatterns = {"/SceneServlet"})
public class SceneServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            /************ Escena y fichero ********/

            Drawable scene;
            FileSaver f = new FileSaver();
            String filename;

            /************ RECIBE ******************/

            //String FileName = "datos";

            InputStream instream = request.getInputStream();
            ObjectInputStream e = new ObjectInputStream(instream);
            Object orden = (Object) e.readObject();
            filename = (String) e.readObject();
            if(orden.equals("salvar")){
                scene = (Drawable) e.readObject();


                f.write(filename.concat(".txt"), scene);

                /************ ENVIA *******************/
                OutputStream outstream;
                outstream = response.getOutputStream();
                ObjectOutputStream s = new ObjectOutputStream(outstream);

                s.writeObject("Enviando respuesta del servidor");
                s.flush();
                s.close();

                e.close();

            }else{
                scene = (Drawable) f.load(filename.concat(".txt"));

                OutputStream outstream;
                outstream = response.getOutputStream();
                ObjectOutputStream s = new ObjectOutputStream(outstream);

                s.writeObject(scene);
                s.flush();
                s.close();
                e.close();
            }


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SceneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
