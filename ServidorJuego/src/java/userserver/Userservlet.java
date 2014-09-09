/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userserver;

import config.Config;
import ejb.UserBeanLocal;
import entidades.Drawable;
import entidades.Sesion;
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
import server.FileSaver;

/**
 *
 * @author yeray
 */
@WebServlet(name = "Userservlet", urlPatterns = {"/Userservlet"})
public class Userservlet extends HttpServlet {

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
            
                  InputStream input = request.getInputStream();   
                  ObjectInputStream obj = new ObjectInputStream(input);  
                  Sesion sesion = (Sesion) obj.readObject();
                  String info = (String) obj.readObject();
                  System.out.println("Respuesta Servlet: ");
                  obj.close();
                  
                  if("salvar".equals(info)){
                      FileSaver file = new FileSaver();
                      Config dir = new Config();
                      file.write(dir.dirUser + sesion.getUser() + ".txt", sesion);

                  }
                  
                    UserBeanLocal userlocal;

                    InitialContext con = new InitialContext();

                    userlocal = (UserBeanLocal)con.lookup("java:global/ServidorJuego/UserBean!ejb.UserBeanLocal");
                    FileSaver f = new FileSaver();
                    Sesion respuesta = (Sesion)userlocal.verifyUser(sesion);
                    System.out.println(respuesta);
                    OutputStream resp = response.getOutputStream();       
                    ObjectOutputStream output = new ObjectOutputStream(resp);
                    output.writeObject(respuesta);     
                    output.flush();
                    output.close();
                  
                  
        } catch (NamingException ex) {
            Logger.getLogger(Userservlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Userservlet.class.getName()).log(Level.SEVERE, null, ex);
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
