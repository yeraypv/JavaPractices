package phaseserver;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import config.Config;
import server.FileSaver;
import entidades.Drawable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeray
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
            throws ServletException, IOException, SQLException {
        try {   
            /*response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet SceneServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("</body>");
                out.println("</html>");
                out.close();*/
                FileSaver f = new FileSaver();
                
                InputStream input = request.getInputStream();
                ObjectInputStream s = new ObjectInputStream(input);
                Object orden = (Object)s.readObject();
               
                System.out.println(orden);
                //salvar
                if("Guardar".equals((String)orden)){
                    String fn = (String)s.readObject();
                    Drawable es = (Drawable)s.readObject();
                    System.out.println("nombre:"+fn);
                    Config dir = new Config();
                    f.write(dir.dirScene + fn, es); 
                    
                    OutputStream resp2 = response.getOutputStream();
                    ObjectOutputStream output = new ObjectOutputStream(resp2);
                    output.writeObject("Guardado");
                    output.flush();
                    output.close();
                    s.close();
                }
                else{
                   //cargar
                    String fn = (String)s.readObject();
                    System.out.println(fn);
                    Drawable esc = (Drawable)f.load(fn);  
                    OutputStream resp = response.getOutputStream();
                    ObjectOutputStream s2 = new ObjectOutputStream(resp);
                    s2.writeObject(esc); 
                    s2.flush();
                    s2.close();
                    s.close();
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
        try {
             processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SceneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }


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
        try {

             processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(SceneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

         
      
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
