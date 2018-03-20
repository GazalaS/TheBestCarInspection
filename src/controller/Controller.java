package controller;

import integration.CreditCardDTO;
import integration.CreditCardProcessingUnit;
import integration.ReceiptDTO;
import integration.Printer;
import integration.Garage;
import java.io.IOException;
import model.InspectionManager;

public class Controller {

    private Garage garage;
    private InspectionManager inspectionManager;
    private Printer printer;
    private CreditCardProcessingUnit creditCardProcessingUnit;

    /**
     * Creates controller andd makes new Garage manager, Printer and passes it
     * to inspectionManager object.
     */
    public Controller() {
        garage = new Garage();
        printer = new Printer();
        inspectionManager = new InspectionManager(printer);
    }

    /**
     * Calls the next customer method from the garage manager, then waits 3 sec
     * and closes the door after the customer is in the garage.
     */
    public void startNewInspection() throws InterruptedException {
        garage.nextCustomer();
        Thread.sleep(3000);
        garage.closeDoor();
    }

    /**
     * Gets cost of the inspection based on the list of inspection that is
     * provided based on the registration number.
     *
     * @param regNumber Registration
     * @return
     */
    public double getInspectionCost(String regNumber) throws IOException {
        return inspectionManager.getInspectionCost(regNumber);
    }

    /**
     * Passes creditCard to credidtCardProcessingUnit to authorisePayment.
     *
     * @param creditCard Customers credit card information.
     * @return
     */
    public boolean authorizePayment(CreditCardDTO creditCard, double cost) {
        CreditCardProcessingUnit creditCardProcessingUnit = new CreditCardProcessingUnit();
        return creditCardProcessingUnit.authorizePayment(creditCard, cost);
    }

    /**
     * Calls inspectionManager to make next inspection.
     *
     * @return Name of the next inspection to be performed.
     */
    public String getNextInspection() {
        return inspectionManager.getNextInspection();
    }

    /**
     * Calls inspetionManager to enter the result of the inspection.
     *
     * @param result The result of the performed inspection.
     */
    public void enterInspectionResult(String result) {
        inspectionManager.enterInspectionResult(result);
    }

    /**
     * Prints the receipt.
     *
     * @param receipt Receipt for the paid inspection.
     */
    public void printReceipt(ReceiptDTO receipt) {
        printer.printReceipt(receipt);
    }

    /**
     * Asks if there is any more inspections to be made.
     *
     * @return If there is any more inspections to be made.
     */
    public boolean hasNextInspection() {
        return inspectionManager.hasNextInspection();
    }

    /**
     * Saves the result of the inspection for the later use.
     *
     * @param regNumber Registration number of the car being inspected.
     */
    public void saveInspectionResult(String regNumber) throws IOException, InterruptedException {
        inspectionManager.saveInspectionResult(regNumber);
        printResult();
        garage.openDoor();
        Thread.sleep(3000);
        garage.closeDoor();
    }

    /**
     * Passes inspection results to the printer for the printing.
     */
    public void printResult() {
        inspectionManager.printInspectionResult();
    }

}
