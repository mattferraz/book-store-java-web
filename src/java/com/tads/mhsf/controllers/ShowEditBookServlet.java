/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tads.mhsf.controllers;
import com.tads.mhsf.models.business.Book;
import com.tads.mhsf.models.repositories.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author mtshs
 */
@WebServlet(name = "ShowEditBookServlet", urlPatterns = {"/ShowEditBookServlet"})
public class ShowEditBookServlet extends HttpServlet {

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
        
        Book currentBook = BookRepository.getBook(Integer.parseInt(request.getParameter("id")));
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditBookServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edit Book</h1>");
            out.println("<form method='post' action='PerformEditBookServlet'>");
            out.println("<input type='hidden' name='id' value='"+ currentBook.getId() + "'/><br>");
            out.println("Title: <input type='text' name='title' value='"+ currentBook.getTitle() + "'/><br>");
            out.println("Description: <input type='text' name='description' value='"+ currentBook.getDescription() + "'/><br>");
            out.println("Author: <input type='text' name='author' value='"+ currentBook.getAuthor() + "'/><br>");
            out.println("Price: <input type='text' name='price' value='"+ currentBook.getPrice() + "'/><br>");
            out.println("Copies: <input type='text' name='copies' value='"+ currentBook.getAvailableCopies()+ "'/><br>");
            out.println("<input type='submit' value='Save'");
            out.println("</form>");
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
