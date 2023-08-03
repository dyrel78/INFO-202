/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;

/**
 *
 * @author dyrellumiwes
 */
public interface CustomerDAO {
    
    
	Collection<Customer> getCustomers();

        void saveCustomer(Customer customer);

	void removeCustomer(Customer customer);
        
        Customer searchByUserName (String username);
        
        Boolean verificationCheck (String username, String password);

        
}
