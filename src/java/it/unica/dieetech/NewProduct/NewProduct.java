/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package it.unica.dieetech.NewProduct;

import it.unica.dieetech.exceptions.InvalidParamException;
import it.unica.dieetech.model.Immagine;
import it.unica.dieetech.model.ImmagineFactory;
import it.unica.dieetech.model.ProdottoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.unica.dieetech.utils.Utils;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


/**
 *
 * @author ricle
 */
@WebServlet(name = "NewProduct", urlPatterns = {"/NewProduct"})
@MultipartConfig
public class NewProduct extends HttpServlet {

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
        
        response.setContentType("multipart/form-data");
        
        HttpSession session = request.getSession(false);
        
        String product = request.getParameter("product_p");
        String quantity = request.getParameter("quantity_p");
        String software = request.getParameter("software_p");
        String price = request.getParameter("prezzo_p");
        String description = request.getParameter("description_p");
        String utente_id = (String) session.getAttribute("username");
        String webpage = "login.jsp";
        String url;
        String Nome_file;
        
        Part file = request.getPart("image_p");
        
        
        try(InputStream contenutoFile = file.getInputStream()){
            Utils.checkString(product, 1, 20);
            Utils.checkInteger(quantity, 1, 1000 );
            Utils.checkFloat(price, 0, 999999);
            Utils.checkString(software, 1, 20);
            Utils.checkString(description, 1, 1000);
            
            int quantita = Integer.parseInt(quantity);
            float prezzo = Float.parseFloat(price);
            
            
            
            if(file.getSubmittedFileName().isEmpty()){
                url = "img/DT_bk.png";
                Nome_file = "immagine stock";
                }
            
            else{

            File fileDaSalvare = new File("C:/Users/andre/Documents/NetBeansProjects/DieeTech Test Servlet/web/uploads/" + file.getSubmittedFileName());
            Files.copy(contenutoFile,fileDaSalvare.toPath(),StandardCopyOption.REPLACE_EXISTING);
            url = "http://localhost:8080/DieeTech_Test_Servlet/uploads/" + file.getSubmittedFileName();
            Nome_file = file.getSubmittedFileName();
            }

            if(ImmagineFactory.getInstance().addImmagine(new Immagine (request.getParameter("name"), Nome_file , url))){
            
                    ProdottoFactory.getInstance().setProdotto(product, description, quantita, software, prezzo, utente_id, url);
                    response.sendRedirect("prodottoInserito.jsp");
            	}
            }catch(InvalidParamException e){
                    request.setAttribute("webpage", webpage);
                    request.setAttribute("errorMessage",e.getMessage());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
            
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
