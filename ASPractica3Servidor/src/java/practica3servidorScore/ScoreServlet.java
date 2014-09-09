/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3servidorScore;

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
import practica3EJB.ScoreBeanLocal;
import practica3entidades.Ranking;

/**
 *
 * @author Jorge
 */
@WebServlet(name = "ScoreServlet", urlPatterns = {"/ScoreServlet"})
public class ScoreServlet extends HttpServlet {

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
            InputStream instream = request.getInputStream();
            ObjectInputStream e = new ObjectInputStream(instream);
            String iduser = (String) e.readObject();
            String score = (String) e.readObject();
            e.close();
            
            ScoreBeanLocal bean;
            InitialContext con = new InitialContext();
            //bean = (ScoreBeanLocal) con.lookup("java:global/ASPractica3Servidor/ScoreBean!practica3EJB.ScoreBeanLocal");
            bean = (ScoreBeanLocal) con.lookup("java:global/ASPractica3Servidor/ScoreBean");
            
            Ranking ranking = bean.saveScore(iduser, Integer.parseInt(score));
            
            OutputStream outstream;
            outstream = response.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outstream);
            
            out.writeObject(ranking);
            out.writeObject("enviando ranking...");
            
            out.flush();
            out.close();
            
        } catch (NamingException ex) {
            Logger.getLogger(ScoreServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScoreServlet.class.getName()).log(Level.SEVERE, null, ex);
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
