/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.CreditCardDTO;
import integration.Garage;
import integration.ReceiptDTO;
import model.InspectionManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tmp-sda-1172
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of startNewInspection method, of class Controller.
     */
  @Test
    public void testStartNewInspection() throws Exception {
        System.out.println("startNewInspection");
        Controller instance = new Controller();
        Garage gar = new Garage();
        instance.startNewInspection();
        
        assertEquals(0,gar.getQueueNumberDisplay());
        assertEquals("The door is closed",gar.getDoorStateLabel().getText());

    }
    
   
    
    /**
     * Test of getInspectionCost method, of class Controller.
     */
    @Test
    public void testGetInspectionCost() throws Exception {
        String regNumber = "ABC123";
        Controller instance = new Controller();
       
        double expResult = 360.5;
        double result = instance.getInspectionCost(regNumber);
        assertEquals(expResult, result, 0.0);        
    }

    /**
     * Test of authorizePayment method, of class Controller.
     */
    @Ignore
    public void testAuthorizePayment() {
        System.out.println("authorizePayment");
        CreditCardDTO creditCard = null;
        double cost = 0.0;
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.authorizePayment(creditCard, cost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextInspection method, of class Controller.
     */
    @Ignore
    public void testGetNextInspection() {
        System.out.println("getNextInspection");
        Controller instance = new Controller();
        String expResult = "";
        String result = instance.getNextInspection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterInspectionResult method, of class Controller.
     */
     @Ignore
    public void testEnterInspectionResult() {
        System.out.println("enterInspectionResult");
        String result_2 = "";
        Controller instance = new Controller();
        instance.enterInspectionResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printReceipt method, of class Controller.
     */
     @Ignore
    public void testPrintReceipt() {
        System.out.println("printReceipt");
        ReceiptDTO receipt = null;
        Controller instance = new Controller();
        instance.printReceipt(receipt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasNextInspection method, of class Controller.
     */
    @Ignore
    public void testHasNextInspection() {
        System.out.println("hasNextInspection");
        Controller instance = new Controller();
        boolean expResult = false;
        boolean result = instance.hasNextInspection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInspectionResult method, of class Controller.
     */
     @Ignore
    public void testSaveInspectionResult() throws Exception {
        System.out.println("saveInspectionResult");
        String regNumber = "";
        Controller instance = new Controller();
        instance.saveInspectionResult(regNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printResult method, of class Controller.
     */
     @Ignore
    public void testPrintResult() {
        System.out.println("printResult");
        Controller instance = new Controller();
        instance.printResult();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   
}
