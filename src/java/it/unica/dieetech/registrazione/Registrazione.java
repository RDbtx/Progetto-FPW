/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.unica.dieetech.registrazione;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import it.unica.dieetech.exceptions.InvalidParamException;
import it.unica.dieetech.model.UtenteFactory;
import it.unica.dieetech.utils.Utils;

/**
 *
 * @author user
 */
@WebServlet(name = "Registrazione", urlPatterns = {"/registrazione"})
public class Registrazione extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        response.setContentType("text/html;charset=UTF-8");
        
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String username = request.getParameter("username");
        String email = request.getParameter("e_mail");
        String citta = request.getParameter("citta");
        String password = request.getParameter("password");
        String pswrepet = request.getParameter("psw_repeat");
        String webpage = "login.jsp";
        
        
        try{
            Utils.checkString(name, 1, 20);
            Utils.checkString(surname, 1, 20);
            Utils.checkString(username, 3, 20);
            Utils.checkString(citta, 2, 50);
            Utils.checkString(email, 10, 50);
            Utils.checkString(password, 5, 25);
            Utils.checkString(pswrepet, 5, 25);
            
            UtenteFactory.getInstance().setUtente(username, name, surname, email, password, citta, "placeholder.jpg");
            
            
            response.sendRedirect("utenteRegistrato.jsp");//redirect alla nuova jsp user (areaPersonale)
            
      
        } catch(InvalidParamException e){
            
            request.setAttribute("webpage", webpage);
            request.setAttribute("errorMessage",e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
          
        }
        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrazione</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrazione at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
