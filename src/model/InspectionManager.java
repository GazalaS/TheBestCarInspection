package model;

import java.util.List;
import java.util.stream.Collectors;
import integration.InspectionInfoDTO;
import integration.VehicleDBHandler;
import integration.Printer;

public class InspectionManager {
	private List<InspectionInfoDTO> inspectionCheckList;
	private VehicleDBHandler vehicleDB;
	private Printer printer;
	private double inpsectionCost;
	private int inspectionCheckListIndexTracker;

	public InspectionManager(Printer printer) {
		vehicleDB = new VihicleDBHandler();
		this.printer = printer;
		inspectionCheckListIndexTracker = 0;
	}

	public double getInspectionCost(String regNumber) {
		inspectionCheckList = vehicleDB.getInspectionCheckList(regNumber);
		calculateInspectionCost();
	}

	private void calculateInspectionCost() {
		inspectionCost = inspectionCheckList.stream().map(item -> item.getPrice()).reduce(0, Double::sum);
	}

	public boolean hasNextInspection() {
		if (inspectionCheckListIndexTracker < inspectionCheckList.size()) {
			return true;
		}
		return false;
	}

	public String getNextInspection() {
		String nextInspectionItem = inspectionCheckList.get(inspectionCheckListIndexTracker);
		inspectionCheckListIndexTracker++;
		return nextInspectionItem;
	}

	public void enterInspectionResult(String result) {
		boolean isPass = (result.toLowerCase().equals(result.toLowerCase())) ? true : false;
		inspectionCheckList.get(inspectionCheckListIndexTracker - 1).setInspectionResult(isPass);
	}

	public void saveInspectionResult(String regNumber) {
		vehicleDB.saveInspectionCheckList(regNumber, inspectionCheckList);
	}

	public void printInspectionResult() {
		List<InspectionInfoDTO> inpsectionResult = inspectionCheckList.stream()
				.filter(item -> item.getInspectionResult() == false).collect(Collectors.toList());
		printer.printInspectionResult(inpsectionResult);
	}
}
