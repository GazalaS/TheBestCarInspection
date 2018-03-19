package model;

public class InspectionManager {
	private List<InspectionInfoDTO> inspectionCheckList;
	private VehicleDBHandler vehicleDB;
	private Printer printer;

	public InspectionManager(Printer printer) {
		vehicleDB = new VihicleDBHandler();
		this.printer = new Printer();
		inspectionCheckList = new ArrayList<>();
	}
	
	public double getInspectionCost(String regNumber) {
		return 0.00; //TODO
	}
	
	private void getInspectionCheckList(String regNumber) {
		//TODO
	}
	
	private void CalculateInspectionCost() {
		
	}
	
	public boolean hasNextInspection() {
		return true;//TODO
	}
	
	public void getNextInspection() {
		//TODO
	}
	
	public void enterInspectionResult(String result) {
		//TODO
	}
	
	public void saveInspectionResult(String regNumber) {
		//TODO
	}
	
	public void printInspectionResult() {
		//TODO
	}
	
}
