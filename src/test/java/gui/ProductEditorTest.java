/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gui;

import dao.ProductDAO;
import domain.Product;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dyrellumiwes
 */
public class ProductEditorTest {
    private ProductDAO dao;
	private DialogFixture fixture;
	private Robot robot;
  
    
    @BeforeEach
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();

		// Slow down the robot a little bit - default is 30 (milliseconds).
		// Do NOT make it less than 10 or you will have thread-race problems.
		robot.settings().delayBetweenEvents(75);

		// add some majors for testing with
		Collection<String> categories = new ArrayList<>();
		categories.add("DVD");
		categories.add("Album");

		// create a mock for the DAO
		dao = mock(ProductDAO.class);

		// stub the getMajors method to return the test majors
		when(dao.getCategories()).thenReturn(categories);
    }
    
    @AfterEach
    public void tearDown() {
        		fixture.cleanUp();

    }
    
    @Test
    public void testSave(){
        
        // create the dialog passing in the mocked DAO
                      ProductEditor dialog = new ProductEditor(null, true, dao);
		//StudentEditor dialog = new StudentEditor(null, true);

		// use AssertJ to control the dialog
		fixture = new DialogFixture(robot, dialog);

		// show the dialog on the screen, and ensure it is visible
		fixture.show().requireVisible();

		// click the dialog to ensure the robot is focused in the correct window
		// since it can get confused by multi-monitor and virtual desktop setups
		fixture.click();

		// enter some details into the UI components
		fixture.textBox("txtId").enterText("11111");
		fixture.textBox("txtName").enterText("Tyler");
		fixture.textBox("txtDescription").enterText("Version 2");
                fixture.comboBox("cmbCategory").selectItem("DVD");

		fixture.textBox("txtPrice").enterText("50.00");
                fixture.textBox("txtQuantity").enterText("2");

		// click the save button
		fixture.button("btnSave").click();

		// create a Mockito argument captor to use to retrieve the passed student from the mocked DAO
		ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);

		// verify that the DAO.save method was called, and capture the passed student
		verify(dao).saveProduct(argument.capture());

		// retrieve the passed student from the captor
		Product savedProduct = argument.getValue();

		// test that the student's details were properly saved
		assertThat("Ensure the ID was saved", savedProduct, hasProperty("productId", equalTo("11111")));
		assertThat("Ensure the Name was saved", savedProduct, hasProperty("name", equalTo("Tyler")));
                assertThat("Ensure the Description was saved", savedProduct, hasProperty("description", equalTo("Version 2")));
                assertThat("Ensure the Category was saved", savedProduct, hasProperty("category", equalTo("DVD")));
                assertThat("Ensure the Price was saved", savedProduct, hasProperty("listPrice", equalTo("50.00")));
    		assertThat("Ensure the Quantity In Stock was saved", savedProduct, hasProperty("quantityInStock", equalTo("2")));
		

    
}
    
}
