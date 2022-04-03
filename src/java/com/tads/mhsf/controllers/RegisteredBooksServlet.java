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
import java.util.List;

/**
 *
 * @author mtshs
 */
@WebServlet(name = "RegisteredBooksServlet", urlPatterns = {"/RegisteredBooksServlet"})
public class RegisteredBooksServlet extends HttpServlet {

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
        
        List<Book> books = BookRepository.getAllBooks();
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registered Books</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Registered Books</h1>");
            out.println("<a href='ShowAddBookServlet'>Add a new book</a>");
            out.println("<table border='1'>");
            out.print("<tr>");
            out.print("<th>Title</th>");
            out.print("<th>Author</th>");
            out.print("<th>Quantity</th>");
            out.print("<th>Unit price</th>");
            out.print("<th>Operations</th>");
            out.print("</tr>");
            
            for (Book book : books) {
                out.println("<tr>");
                out.println("<td>" + book.getTitle() + "</td>");
                out.println("<td>" + book.getAuthor() + "</td>");
                out.println("<td>" + book.getAvailableCopies()+ "</td>");
                out.println("<td>R$" + book.getPrice()+ "</td>");
                out.println("<td>");
                out.println("<a href='PerformReadBookServlet?id=" 
                        + book.getId() + "'>Details</a>");
                out.println("<a href='ShowEditBookServlet?id=" 
                        + book.getId() + "'>Edit</a>");
                out.println("<a href='PerformDeleteBookServlet?id=" 
                        + book.getId() + "'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
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
