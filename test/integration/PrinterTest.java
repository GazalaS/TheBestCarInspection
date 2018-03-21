/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class PrinterTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    public PrinterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUpStream() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStream() {
        outContent = null;
        System.setOut(originalSysOut);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of printReceipt method, of class Printer.
     */
    @Test
    public void testPrintReceipt() {
        String regNumber = "ABC123";
        Date date = new Date();
        double cost = 360.5;
        ReceiptDTO receipt = new ReceiptDTO(cost, date, regNumber);
        Printer instance = new Printer();
        instance.printReceipt(receipt);
        String result = outContent.toString();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String expResult = "Registration Number: " + regNumber
                + "\nReceipt Date: " + formatter.format(date)
                + "\nCost: " + cost+"\n";
        
        assertEquals(expResult,result );
    }

    /**
     * Test of printInspectionResult method, of class Printer.
     */
    @Test
    public void testPrintInspectionResult() {
    
        List<InspectionInfoDTO> inspectionResult = new ArrayList<InspectionInfoDTO>();
        InspectionInfoDTO info1 = new InspectionInfoDTO(
                "Check Oil",
                160.50,
                true);
        inspectionResult.add(info1);
        Printer instance = new Printer();
        instance.printInspectionResult(inspectionResult);
        String result = outContent.toString();
        
        String expResult ="Inspection results:"
                    +"\n"+inspectionResult.get(0).getInspectionInformation()
                    +":"+(inspectionResult.get(0).getInspectionResult() ? "pass" : "fail")
                    +"\n";
        assertEquals(expResult, result);      
    }

}
