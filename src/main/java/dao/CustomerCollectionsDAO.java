/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Customer;
import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dyrellumiwes
 */
public class CustomerCollectionsDAO implements CustomerDAO {

    private static final Map<String, Customer> customers = new HashMap<>();

    @Override
    public Collection<Customer> getCustomers() {
        return customers.values();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getUsername(), customer);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer.getUsername(), customer);

    }

    @Override
    public Customer searchByUserName(String username) {
        Customer findMe = customers.get(username);
        return findMe;
    }

    @Override
    public Boolean verificationCheck(String username, String password) {
        Customer check = customers.get(username);
         if(check == null) return false;
        return check.getPassword().equals(password);
    }

    
  
}
