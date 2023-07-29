/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import domain.Product;
import java.math.BigDecimal;
import java.util.Collection;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author dyrellumiwes
 */
public class ProductCollectionsDAOTest {
    
  private ProductDAO dao;
     private Product product1;
     private Product product2;
     private Product product3;
     
    @BeforeEach
    public void setUp() {
        
        dao = new ProductCollectionsDAO();
        
        
		product1 = new Product();
		product2 = new Product();
		product3 = new Product();
                BigDecimal b1 = new BigDecimal(1);
                BigDecimal b2 = new BigDecimal(2);
                BigDecimal b3 = new BigDecimal(3);


             
                
                product1.setProductId("123");
		product1.setName("IGOR");
		product1.setDescription("Tyler the Creator");
		product1.setCategory("Album");
                product1.setListPrice(b1);
                product1.setQuantityInStock(b1);
		

		product2.setProductId("456");
		product2.setName("An Ideal for Living");
		product2.setDescription("Joy Divison");
		product2.setCategory("EP");
		product2.setListPrice(b2);
                product2.setQuantityInStock(b2);

		product3.setProductId("789");
		product3.setName("Sprinter");
		product3.setDescription("Dave and Central Cee");
		product3.setCategory("Single");
		product3.setListPrice(b3);
                product3.setQuantityInStock(b3);
                
		dao.saveProduct(product1);
		dao.saveProduct(product2);
    }
    
    @AfterEach
    public void tearDown() {
        dao.removeProduct(product1);
	dao.removeProduct(product2);
        dao.removeProduct(product3);
    }

    /**
     * Test of saveProduct method, of class ProductCollectionsDAO.
     */
    @Test
    public void testSaveProduct() {
        
        //Check that product3 hasn't been prematurely saved
        assertThat(dao.searchById(product3.getProductId()), is(nullValue()));
        assertThat(dao.getProducts(), hasSize(2));
        
        dao.saveProduct(product3);
        
        //check save works
        assertThat(dao.searchById(product3.getProductId()), is(product3));
        assertThat(dao.getProducts(), hasSize(3));	//assertThat(dao.getProducts(), hasItem(product3));
    }

    /**
     * Test of removeProduct method, of class ProductCollectionsDAO.
     */
    @Test
    public void testRemoveProduct() {
            dao.removeProduct(product3);
            
        assertThat(dao.searchById(product3.getProductId()), is(nullValue()));
        assertThat(dao.getProducts(), hasSize(2));
        
        assertThat(dao.getProducts(), not(hasItem(product3)));

        
    }

    /**
     * Test of getProducts method, of class ProductCollectionsDAO.
     */
    @Test
    public void testGetProducts() {
        
         Collection<Product> products = dao.getProducts();
        assertThat(products, hasSize(2));
        assertThat(products, hasItem(product1));
        assertThat(products, hasItem(product2));
        
        Product result = products.stream()
                .filter(p -> p.getProductId().equals(product1.getProductId())).findFirst().get();
        assertThat(result, Matchers.samePropertyValuesAs(product1));


    }

    /**
     * Test of getCategories method, of class ProductCollectionsDAO.
     */
    @Test
    public void testGetCategories() {
       assertThat(dao.getCategories(), containsInAnyOrder(product1.getCategory(), product2.getCategory()));

    }

    /**
     * Test of searchById method, of class ProductCollectionsDAO.
     */
    @Test
    public void testSearchById() {
        Product test = dao.searchById(product1.getProductId());
        assertThat(test, is (product1));
        
      assertThat(test, Matchers.samePropertyValuesAs(product1));

    }

    /**
     * Test of filterByCategory method, of class ProductCollectionsDAO.
     */
    @Test
    public void testFilterByCategory() {
        
        assertThat(dao.filterByCategory("Album"), contains(product1));
        assertThat(dao.filterByCategory("EP"), contains(product2));
        assertThat(dao.filterByCategory("Single"), hasSize(0));
        
        
    }

}
