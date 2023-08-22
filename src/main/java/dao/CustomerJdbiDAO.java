/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author dyrellumiwes
 */
public interface CustomerJdbiDAO extends CustomerDAO{

    
     @Override
    @SqlUpdate("insert into Customer(Username, FirstName, Surname, EmailAddress,ShippingAddress,Password) values (:username, :firstName, :surname, :emailAddress, :shippingAddress, :password)")
    public void saveCustomer(@BindBean Customer customer);
//    @SqlUpdate("merge into Student(ID, Name, Major, Phone_Number, Address) values (:id, :name, :major, :phoneNumber, :address)")
// CustomerID integer AUTO_INCREMENT (1000) unique,
//    Username varchar(50) not null unique,
//    FirstName varchar(50) not null,
//    Surname varchar(50) not null,
//    EmailAddress varchar(100) not null,
//    ShippingAddress varchar(100) not null,
//    Password varchar(50) not null,
//constraint Customer_PK primary key (customerID)    

    
    
    @Override
    @SqlQuery("select exists (select * from Customer where Username = :username AND Password = :password)")
    public Boolean verificationCheck(@Bind("username")String username, @Bind("password") String password);

   @Override
    @SqlQuery("select * from Customer where Username = :username")
    @RegisterBeanMapper(Customer.class)
    public Customer searchByUserName(@Bind("username")String username);

    @Override
    @SqlUpdate("delete from Customer where Username = :username")
    public void removeCustomer(@BindBean Customer customer);


   
    @Override
    @SqlQuery("select * from Customer")
    @RegisterBeanMapper(Customer.class)
    public Collection<Customer> getCustomers();
    
}
