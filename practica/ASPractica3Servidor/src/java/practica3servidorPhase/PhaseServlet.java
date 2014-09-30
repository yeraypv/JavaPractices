/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3servidorPhase;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import practica3EJB.PhaseBeanLocal;
import practica3entidades.Drawable;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "PhaseServlet", urlPatterns = {"/PhaseServlet"})
public class PhaseServlet extends HttpServlet {

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
            
            HttpSession s = request.getSession(true);
            //getAttribute extrae el valor de una variaable previamente registrada
            PhaseBeanLocal bean = (PhaseBeanLocal) s.getAttribute("PhaseBean");
            
            if(bean == null){
                InitialContext con = new InitialContext();
                bean = (PhaseBeanLocal) con.lookup("java:global/ASPractica3Servidor/PhaseBean");
                //setAttribute registra variable dentro dentro de la sesion
                s.setAttribute("PhaseBean", bean);    
            }
            
            InputStream instream = request.getInputStream();
            ObjectInputStream e = new ObjectInputStream(instream);
            String idphase = (String) e.readObject();
            e.close();

            OutputStream outstream;
            outstream = response.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outstream);
            
            if(!idphase.equals("0")){
                Drawable escena = bean.nextPhase();
                out.writeObject(s.getId());
                out.writeObject(escena);
            }else{
                bean.finish();
                out.writeObject("Termina");
            }
            
            out.flush();
            out.close();
            
        } catch (NamingException ex) {
            Logger.getLogger(PhaseServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhaseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
