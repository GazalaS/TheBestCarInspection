
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.InspectionInfoDTO;
import integration.Printer;
import model.InspectionManager;

class InspectionManagerTest {
	private Printer printer;
	private InspectionManager inspectionManger;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		printer = new Printer();
		inspectionManger = new InspectionManager(printer);
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
		printer = null;
		inspectionManger = null;
		System.setOut(System.out);
	}

	@Test
	void testGetInspectionCostWithValidRegistrationNumber() throws IOException {
		String regNumber = "ABC123";
		double inspectionCost = inspectionManger.getInspectionCost(regNumber);
		final double EXPECTED_RESULT = 360.5;
		assertEquals(EXPECTED_RESULT, inspectionCost);
	}
	
	@Test
	void testGetInspectionCostWithInvalidRegistrationNumber() throws IOException {
		String regNumber = "AB123";
		double inspectionCost = inspectionManger.getInspectionCost(regNumber);
		final double EXPECTED_RESULT = 0;
		assertEquals(EXPECTED_RESULT, inspectionCost);
	}

	@Test
	void testHasNextInspectionWithEmptyList() {
		boolean actualResult = inspectionManger.hasNextInspection();
		boolean expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testHasNextInspectionWithOneItemInTheList() {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		boolean actualResult = inspectionManger.hasNextInspection();
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void testGetNextInspectionWithhOneItemInTheList() {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		String actualResult = inspectionManger.getNextInspection();
		String expectedResult = "check gear";
		assertEquals(expectedResult, actualResult);
		boolean hasNext = inspectionManger.hasNextInspection();
		boolean expected = false;
		assertEquals(expected, hasNext);
	}
	
	@Test
	void testGetNextInspectionWithhEmptyList() {
		assertThrows(IndexOutOfBoundsException.class, () -> {inspectionManger.getNextInspection();});
	}

	@Test
	void testEnterInspectionResult() {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		inspectionManger.getNextInspection();
		inspectionManger.enterInspectionResult("pass");
		assertEquals(true, inspectionChecklist.get(0).getInspectionResult());
	}

	@Test
	void testSaveInspectionResult() throws IOException {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		InspectionInfoDTO anotherInspectionItem = new InspectionInfoDTO("check egine oil", 100.0, false);
		inspectionChecklist.add(anotherInspectionItem);
		inspectionManger.getNextInspection();
		inspectionManger.enterInspectionResult("pass");
		String regNumber = "ZCE123";
		inspectionManger.saveInspectionResult(regNumber);
		Path filePath = Paths.get(regNumber + "inspectionchecklist.txt");
		boolean actualResult = Files.exists(filePath);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
		double inspectionCost = inspectionManger.getInspectionCost(regNumber);
		double expectedCost = 100.0;
		Files.delete(filePath);
		assertEquals(expectedCost, inspectionCost);
	}

	@Test
	void testPrintInspectionResultWithOneFailItem() {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		inspectionManger.printInspectionResult();
		assertEquals("Inspection results:\ncheck gear:fail\n", outContent.toString());
	}
	
	@Test
	void testPrintInspectionResultWithAllPass() {
		List<InspectionInfoDTO> inspectionChecklist = inspectionManger.getInspectionChecklist();
		InspectionInfoDTO inspectionItem = new InspectionInfoDTO("check gear", 200.0, false);
		inspectionChecklist.add(inspectionItem);
		inspectionManger.getNextInspection();
		inspectionManger.enterInspectionResult("pass");
		inspectionManger.printInspectionResult();
		assertEquals("Passed all inspections\n", outContent.toString());
	}
}
