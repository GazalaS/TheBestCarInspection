package model;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import integration.InspectionInfoDTO;
import integration.Printer;
import integration.VehicleDBHandler;

/**
 * Inspection Manger manage tasks related to the inspection of a vehicle. An
 * inspection manager object will manager inspection cost, updating the
 * inspection result and providing inspection report details.
 * 
 */
public class InspectionManager {
	private List<InspectionInfoDTO> inspectionChecklist;
	private VehicleDBHandler vehicleDB;
	private Printer printer;
	private double inspectionCost;
	private int inspectionCheckListIndexTracker;

	/**
	 * Initialize a inspection manager object.
	 * 
	 * @param printer
	 *            Printer object for printing of receipt and inspection report.
	 */
	public InspectionManager(Printer printer) {
		vehicleDB = new VehicleDBHandler();
		this.printer = printer;
		inspectionCheckListIndexTracker = 0;
		inspectionChecklist = new ArrayList<>();
	}

	/**
	 * Get the inspection cost for a particular vehicle.
	 * 
	 * @param regNumber
	 *            Registration number of the specify vehicle.
	 * @return The inspection cost for the specify vehicle.
	 * @throws IOException
	 */
	public double getInspectionCost(String regNumber) throws IOException {
		inspectionChecklist = vehicleDB.getInspectionChecklist(regNumber);
		calculateInspectionCost();
		return inspectionCost;
	}

	private void calculateInspectionCost() {
		inspectionCost = inspectionChecklist.stream().map(item -> item.getPrice()).reduce(0.0, Double::sum);
	}

	/**
	 * Check if there is inspection to be done for a vehicle.
	 * 
	 * @return True if there is inspection to be done.
	 */
	public boolean hasNextInspection() {
		if (inspectionCheckListIndexTracker < inspectionChecklist.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Get the inspection description for the next item for inspection.
	 * 
	 * @return The description of inspection.
	 */
	public String getNextInspection() {
		String nextInspectionItem = inspectionChecklist.get(inspectionCheckListIndexTracker).getInspectionInformation();
		inspectionCheckListIndexTracker++;
		return nextInspectionItem;
	}

	/**
	 * Set the inspection result for an inspection item.
	 * 
	 * @param result
	 *            Result of inspection. eg. "Pass" or "Fail".
	 */
	public void enterInspectionResult(String result) {
		boolean isPass = (result.toLowerCase().equals("pass".toLowerCase())) ? true : false;
		inspectionChecklist.get(inspectionCheckListIndexTracker - 1).setInspectionResult(isPass);
	}

	private List<InspectionInfoDTO> filterFailResult() {
		return inspectionChecklist.stream().filter(item -> item.getInspectionResult() == false)
				.collect(Collectors.toList());
	}

	/**
	 * Save the inspection result of a vehicle to database after inspection was
	 * carried out.
	 * 
	 * @param regNumber
	 *            Registration number of the vehicle.
	 * @throws IOException
	 */
	public void saveInspectionResult(String regNumber) throws IOException {
		vehicleDB.saveInspectionChecklist(regNumber, filterFailResult());
	}

	/**
	 * Provide an inspection report which include all items that are fail in the
	 * inspection.
	 */
	public void printInspectionResult() {
		printer.printInspectionResult(filterFailResult());
	}

	public List<InspectionInfoDTO> getInspectionChecklist() {
		return inspectionChecklist;
	}

}
