/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import dao.CustomerCollectionsDAO;
import dao.CustomerDAO;
import domain.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dyrellumiwes
 */
@WebServlet(name = "SignInServlet", urlPatterns = {"/sign-in"})
public class SignInServlet extends HttpServlet {

    
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
         //Checking for SQL injections?
             CustomerDAO dao = new CustomerCollectionsDAO();
   
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        Customer checkUser = dao.searchByUserName(userName);
        
        if(dao.verificationCheck(checkUser.getUsername(), checkUser.getPassword())){
            response.sendRedirect("index.jsp");
            
        } else{
            return; //Add in lab 5
        }
        
      
        // save the student
        
        
        
        response.sendRedirect("index.jsp");
        
    }

}
