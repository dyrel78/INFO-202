/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import dao.CustomerCollectionsDAO;
import dao.CustomerDAO;
import domain.Customer;
import java.io.IOException;
import static java.lang.System.in;
import java.util.Collection;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;

/**
 *
 * @author dyrellumiwes
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/create-account"})
public class CreateAccountServlet extends HttpServlet {

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
         HttpSession session = request.getSession();
        try{
        CustomerDAO dao = new CustomerCollectionsDAO();
        
         Collection<Customer> custList = dao.getCustomers();
         
         Random rng = new Random();
         int id = rng.hashCode();
         for(Customer cust : custList){
             if(cust.getCustomerId() == id){
                 System.out.println("Already have an account");
                 return ;
             }else return;
             
         }
        
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstname");
        String surname = request.getParameter("surname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        Integer idHashed = Integer.valueOf(id);
        // create the student obj
        Customer customer = new Customer(idHashed,userName, firstName, surname, address, email);
        customer.setPassword(password);

        // save the student
        new Validator().assertValid(customer);
        
        
        dao.saveCustomer(customer);
        session.removeAttribute("validation");

        response.sendRedirect("index.jsp");
        
        }
        
        
        catch (ConstraintsViolatedException ex) {
	// get the violated constraints from the exception
	ConstraintViolation[] violations = ex.getConstraintViolations();
	// create a nice error message for the user
	String msg = "Please fix the following input problems:";
	msg += "<ul>";
	for (ConstraintViolation cv : violations) {
		msg += "<li>" + cv.getMessage() + "</li>";
	}
	msg += "</ul>";
	request.getSession().setAttribute("validation", msg);
	response.sendRedirect("create-account.jsp");
}
        
        
    }
        
        
 }
