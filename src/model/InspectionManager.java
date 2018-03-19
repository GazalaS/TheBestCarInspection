package model;

import java.util.List;
import java.util.stream.Collectors;
import integration.InspectionInfoDTO;
import integration.VehicleDBHandler;
import integration.Printer;

/**
 * Inspection Manger manage tasks related to the inspection of a vehicle. An
 * inspection manager object will manager inspection cost, updating the
 * inspection result and providing inspection report details.
 * 
 * @author aaronsum
 *
 */
public class InspectionManager {
	private List<InspectionInfoDTO> inspectionCheckList;
	private VehicleDBHandler vehicleDB;
	private Printer printer;
	private double inpsectionCost;
	private int inspectionCheckListIndexTracker;

	/**
	 * Initialize a inspection manager object.
	 * 
	 * @param printer
	 *            Printer object for printing of receipt and inspection report.
	 */
	public InspectionManager(Printer printer) {
		vehicleDB = new VihicleDBHandler();
		this.printer = printer;
		inspectionCheckListIndexTracker = 0;
	}

	/**
	 * Get the inspection cost for a particular vehicle.
	 * 
	 * @param regNumber
	 *            Registration number of the specify vehicle.
	 * @return The inspection cost for the specify vehicle.
	 */
	public double getInspectionCost(String regNumber) {
		inspectionCheckList = vehicleDB.getInspectionCheckList(regNumber);
		calculateInspectionCost();
	}

	private void calculateInspectionCost() {
		inspectionCost = inspectionCheckList.stream().map(item -> item.getPrice()).reduce(0, Double::sum);
	}

	/**
	 * Check if there is inspection to be done for a vehicle.
	 * 
	 * @return True if there is inspection to be done.
	 */
	public boolean hasNextInspection() {
		if (inspectionCheckListIndexTracker < inspectionCheckList.size()) {
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
		String nextInspectionItem = inspectionCheckList.get(inspectionCheckListIndexTracker);
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
		boolean isPass = (result.toLowerCase().equals(result.toLowerCase())) ? true : false;
		inspectionCheckList.get(inspectionCheckListIndexTracker - 1).setInspectionResult(isPass);
	}

	/**
	 * Save the inspection result of a vehicle to database after inspection was
	 * carried out.
	 * 
	 * @param regNumber
	 *            Registration number of the vehicle.
	 */
	public void saveInspectionResult(String regNumber) {
		vehicleDB.saveInspectionCheckList(regNumber, inspectionCheckList);
	}

	/**
	 * Provide an inspection report which include all items that are fail in the
	 * inspection.
	 */
	public void printInspectionResult() {
		List<InspectionInfoDTO> inpsectionResult = inspectionCheckList.stream()
				.filter(item -> item.getInspectionResult() == false).collect(Collectors.toList());
		printer.printInspectionResult(inpsectionResult);
	}
}
