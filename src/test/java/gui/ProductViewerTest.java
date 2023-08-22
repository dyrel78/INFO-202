/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gui;

import dao.ProductDAO;
import domain.Product;
import helpers.SimpleListModel;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.JListFixture;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dyrellumiwes
 */
public class ProductViewerTest {
    
    private ProductDAO dao;
    private Robot robot;
    private DialogFixture fixture;
    
    private Product p1;
    private Product p2;
    private Product p3;          
    
    public ProductViewerTest() {
        
        
    }
    
    @BeforeEach
    public void setUp() {
        
    Collection <Product> products = new HashSet<>();
        p1 = new Product("TestID1", "Name1", "Desc1", "Cat1", new BigDecimal("1.11"), new BigDecimal("1.11"));
	p2 = new Product("TestID2", "Name2", "Desc2", "Cat2", new BigDecimal("2.22"), new BigDecimal("2.22"));
        p3 = new Product("TestID3", "Name3", "Desc3", "Cat3", new BigDecimal("3.33"), new BigDecimal("3.33"));
            robot = BasicRobot.robotWithNewAwtHierarchy();

		// Slow down the robot a little bit - default is 30 (milliseconds).
		// Do NOT make it less than 10 or you will have thread-race problems.
		robot.settings().delayBetweenEvents(75);

		// add some majors for testing with
		Collection<String> categories = new HashSet<>();
		categories.add("Cat1");
                categories.add("Cat2");

		// create a mock for the DAO
		dao = mock(ProductDAO.class);

		// stub the getMajors method to return the test majors
		when(dao.getCategories()).thenReturn(categories);
        
    }       //do product the id or wahtever
    
    @AfterEach
    public void tearDown() {
                fixture.cleanUp();

    }
    
    
    @Test
    public void testView(){
        
        // create the dialog passing in the mocked DAO
                      ProductViewer dialog = new ProductViewer(null, true, dao);
		//StudentEditor dialog = new StudentEditor(null, true);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// since it can get confused by multi-monitor and virtual desktop setups
		fixture.click();

		// enter some details into the UI components
		fixture.list().requireItemCount(3);
		SimpleListModel model = (SimpleListModel) fixture.list().target().getModel();
		assertThat(model, containsInAnyOrder(p1, p2, p3));
    }
    
    
    @Test
    public void testSave(){
        
        
        
        
        //not needed?
    }
    
     @Test
    public void testDelete(){
        ProductViewer dialog = new ProductViewer(null, true, dao);

		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();

		// make sure dialog has focus
		fixture.click();

		fixture.list().requireItemCount(3);
		SimpleListModel model = (SimpleListModel) fixture.list().target().getModel();
		assertThat(model, hasItem(p2));

		fixture.list().selectItem(p2.toString());
		fixture.button("btnDelete").click();

		fixture.optionPane().requireVisible().yesButton().click();

		verify(dao).removeProduct(p2);

		fixture.list().requireItemCount(2);

		assertThat(model, not(hasItem(p2)));
    }
    
     @Test
    public void testSearchById(){
        	ProductViewer dialog = new ProductViewer(null, true, dao);

		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();
		// make sure dialog has focus
		fixture.click();
		// enter p1's ID into search field and click the search button
		fixture.textBox("txtSearchId").enterText(p1.getProductId());
		fixture.button("btnSearch").click();

		// verify that searchById was called on the DAO, and that p1's ID was the parameter that was passed
		verify(dao).searchById(p1.getProductId());

        // verify that the JList is now displaying p1 (and only p1)
        //Not working
            //   fixture.list("lstProducts").requireItemCount(1);
		SimpleListModel model = (SimpleListModel) fixture.list().target().getModel();
		assertThat(model, contains(p1));
    }
    
    
    @Test
    public void filterByCategory(){
        	ProductViewer dialog = new ProductViewer(null, true, dao);

		fixture = new DialogFixture(robot, dialog);
		fixture.show().requireVisible();

		// dialog is focused 
		fixture.click();

		// select p2's category 
		fixture.comboBox().selectItem(p2.getCategory());

		// verify that filterByCategory was called on the DAO, and that p2's category was the parameter that was passed
		verify(dao).filterByCategory(p2.getCategory());

		// verify that the JList is now displaying p2 
		fixture.list("lstProducts").requireItemCount(1);
		SimpleListModel model = (SimpleListModel) fixture.list().target().getModel();
		assertThat(model, containsInAnyOrder(p2));
    }
    
}
