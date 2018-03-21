/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for Vehicle DB Handler
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class VehicleDBHandlerTest {

    public VehicleDBHandlerTest() {
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
     * Test of getInspectionChecklist method, of class VehicleDBHandler.
     */
    @Test
    public void testGetInspectionChecklistCheckData() throws Exception {
        String regNumber = "testGetABC123";
        VehicleDBHandler instance = new VehicleDBHandler();

        List<InspectionInfoDTO> expResult = new ArrayList<InspectionInfoDTO>();
        InspectionInfoDTO info1 = new InspectionInfoDTO(
                "Check Oil",
                160.50,
                true);
        expResult.add(info1);
        
        InspectionInfoDTO info2 = new InspectionInfoDTO(
                "Check HeadLights",
                200,
                true);
        expResult.add(info2);

        List<InspectionInfoDTO> result = instance.getInspectionChecklist(regNumber);

        assertEquals(expResult,result);
    }

    /**
     * Test of saveInspectionChecklist method, of class VehicleDBHandler.
     */
    @Test
    public void testSaveInspectionChecklistSaveData() throws Exception {
        String regNumber = "testSaveABC123";

        List<InspectionInfoDTO> inspectionChecklist = new ArrayList<InspectionInfoDTO>();
        InspectionInfoDTO info1 = new InspectionInfoDTO(
                "Check Oil",
                160.50,
                false);
        inspectionChecklist.add(info1);
        
        InspectionInfoDTO info2 = new InspectionInfoDTO(
                "Check HeadLights",
                200,
                false);
        inspectionChecklist.add(info2);
        
        VehicleDBHandler instance = new VehicleDBHandler();
        boolean expResult = true;
        boolean result = instance.saveInspectionChecklist(regNumber, inspectionChecklist);
        assertEquals(expResult, result);
    }

    /**
     * If regNumber is valid it will return List <code>{@link InspectionInfoDTO}</code> object for
     * particulare regNumber
     * @throws Exception 
     */
    @Test
    public void testGetInspectionChecklistValidRegNumber() throws Exception {
        String regNumber = "testABC123";
        VehicleDBHandler instance = new VehicleDBHandler();
        List<InspectionInfoDTO> result = instance.getInspectionChecklist(regNumber);
        assertNotNull(result);
    }
    
    /**
     * If regNumber is valid it will return and empty list
     * @throws Exception 
     */
    @Test
    public void testGetInspectionChecklistInvalidRegNumber() throws Exception {
        String regNumber = "testABCDE12345";
        VehicleDBHandler instance = new VehicleDBHandler();
        int expResult = 0;    
        List<InspectionInfoDTO> result = instance.getInspectionChecklist(regNumber);
        assertEquals(expResult,result.size());
    }
}
