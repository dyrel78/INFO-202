/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Customer;
import java.util.Collection;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author dyrellumiwes
 */
public class CustomerCollectionsDAOTest {
    
  private CustomerDAO dao;
     private Customer c1;
     private Customer c2;
     private Customer c3;
    
    @BeforeEach
    public void setUp() {
        
      //  dao = new CustomerCollectionsDAO();
         dao = JdbiDaoFactory.getCustomerDAO();
        c1 = new Customer();
        c2 = new Customer();
        c3 = new Customer();
        
        
        
//        public Customer(Integer customerId, String username, String firstName, String surname, String shippingAddress, String emailAddress) {
//		this.customerId = customerId;
//		this.username = username;
//		this.firstName = firstName;
//		this.surname = surname;
//		this.shippingAddress = shippingAddress;
//		this.emailAddress = emailAddress;
//	}

            c1.setCustomerId(111);
            c1.setUsername("test1");
            c1.setFirstName("fName1");
            c1.setSurname("sName1");
            c1.setShippingAddress("address1");
            c1.setEmailAddress("test1@email");
            c1.setPassword("password1");
            
            
            c2.setCustomerId(222);
            c2.setUsername("test2");
            c2.setFirstName("fName2");
            c2.setSurname("sName2");
            c2.setShippingAddress("address2");
            c2.setEmailAddress("test2@email");
            c2.setPassword("password2");
            
            c3.setCustomerId(333);
            c3.setUsername("test3");
            c3.setFirstName("fName3");
            c3.setSurname("sName3");
            c3.setShippingAddress("address3");
            c3.setEmailAddress("test3@email");
            c3.setPassword("password3");
            
            dao.saveCustomer(c1);
            dao.saveCustomer(c2);
            
    }
    
    @AfterEach
    public void tearDown() {
         dao.removeCustomer(c1);
	dao.removeCustomer(c2);
        dao.removeCustomer(c3);
    
    }

    /**
     * Test of getCustomers method, of class CustomerCollectionsDAO.
     */
    @Test
    public void testGetCustomers() {
        
   Collection<Customer> customers = dao.getCustomers();
        assertThat(customers, hasSize(2));
        assertThat(customers, hasItem(c1));
        assertThat(customers, hasItem(c2));
        
        
        
        Customer result = customers.stream()
                .filter(c -> c.getCustomerId().equals(c1.getCustomerId())).findFirst().get();
        assertThat(result, Matchers.samePropertyValuesAs(c1));
    }

    /**
     * Test of saveCustomer method, of class CustomerCollectionsDAO.
     */
    @Test
    public void testSaveCustomer() {
       
        //check save works    
        assertThat(dao.searchByUserName(c3.getUsername()), is(nullValue()));
        assertThat(dao.getCustomers(), hasSize(2));
        
        dao.saveCustomer(c3);
        assertThat(dao.searchByUserName(c3.getUsername()), is(c3));
        assertThat(c3.getUsername() , is("test3"));

        assertThat(dao.getCustomers(), hasSize(3));
        
    }

    /**
     * Test of removeCustomer method, of class CustomerCollectionsDAO.
     */
    @Test
    public void testRemoveCustomer() {
        
        dao.removeCustomer(c3);
        assertThat(dao.searchByUserName(c3.getUsername()), is(nullValue()));
        assertThat(dao.getCustomers(), hasSize(2));
        
    }

    /**
     * Test of searchByUserName method, of class CustomerCollectionsDAO.
     */
    @Test
    public void testSearchByUserName() {
        Customer test = dao.searchByUserName("test1");
        assertThat (test, is (c1));
        assertThat(test,Matchers.samePropertyValuesAs(c1));
        
       assertThat(dao.searchByUserName(c1.getUsername()), is(c1));

    }

    /**
     * Test of verificationCheck method, of class CustomerCollectionsDAO.
     */
    @Test
    public void testVerificationCheck() {
        Customer test = dao.searchByUserName("test1");
        
        String testUserName = test.getUsername();
        String testPassword = test.getPassword();
        
        Boolean flag = dao.verificationCheck(testUserName, testPassword);
        
        assertThat(flag, Matchers.is(true)   );
        
        
    }
    
}
