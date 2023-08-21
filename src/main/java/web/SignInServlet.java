/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import dao.CustomerCollectionsDAO;
import dao.CustomerDAO;
import dao.DaoFactory;
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
import javax.servlet.http.HttpSession;
import net.sf.oval.Validator;

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
         HttpSession session = request.getSession();

//         try{
 
           //  CustomerDAO dao = new CustomerCollectionsDAO();
        CustomerDAO dao = DaoFactory.getCustomerDAO();

        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        boolean result = dao.verificationCheck(userName, password);
        Customer checkUser = dao.searchByUserName(userName);
        
//         new Validator().assertValid(checkUser);

         if (result) {
            Customer customer = dao.searchByUserName(userName);
            customer.setPassword(null);
            request.getSession().setAttribute("customer", customer);
            response.sendRedirect("index.jsp");
        } else {

            request.getSession().setAttribute("error-messages", "<p>Incorrect username/password</p>");
            response.sendRedirect("sign-in.jsp");
        }
//save the product
//        response.sendRedirect("index.jsp");
        
//     }catch(NumberFormatException e) {
//           
//          session.setAttribute("validation", "You have entered an invalid ID ");
//          response.sendRedirect("create-account.jsp");
//            
//          
//          
//        }
    }

}
