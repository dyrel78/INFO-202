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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
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
    
}
