/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;

/**
 *
 * @author dyrellumiwes
 */
public interface CustomerJdbiDAO extends CustomerDAO{

    @Override
    public Boolean verificationCheck(String username, String password);

    @Override
    public Customer searchByUserName(String username);

    @Override
    public void removeCustomer(Customer customer);

    @Override
    
    public void saveCustomer(Customer customer);

    @Override
    public Collection<Customer> getCustomers();
    
}
