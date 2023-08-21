/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author dyrellumiwes
 */
public class DaoFactory {
    
    
    public static CustomerDAO getCustomerDAO() {
	return JdbiDaoFactory.getCustomerDAO();
	// return new StudentCollectionsDAO();
}
    
      public static ProductDAO getProductDAO() {
	return JdbiDaoFactory.getProductDAO();
	// return new StudentCollectionsDAO();
}
}
