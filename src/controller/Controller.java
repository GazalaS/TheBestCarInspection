package controller;

import integration.CreditCardDTO;
import integration.CreditCardProcessingUnit;
import integration.ReceiptDTO;
<<<<<<< HEAD
import javafx.print.Printer;
import model.GarageManager;
import model.InspectionManager;
i
=======
import integration.Printer;
import integration.Garage;
import model.InspectionManager;
>>>>>>> 916d23027ba9ff53787bce8a612a7a19dc5387e7


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
<<<<<<< HEAD
    public void startNewInspection () {
        garageManager.nextCustomer();
=======
    public void startNewInspection(){
        garage.nextCustomer();
>>>>>>> 916d23027ba9ff53787bce8a612a7a19dc5387e7
        Thread.sleep(3000);
        garage.closeDoor();
    }
    
    /**
     * Gets cost of the inspection based on the list of inspection that is 
     * provided based on the registration number.
     * @param regNumber Registration
     * @return 
     */
    public double getInspectionCost(String regNumber){
        return inspectionManager.getInspectionCost();        
    }
    
    /**
     * Passes creditCard to credidtCardProcessingUnit to authorisePayment.
     * @param creditCard Customers credit card information.
     * @return 
     */
    public boolean authorisePayment(CreditCardDTO creditCard){
        CreditCardProcessingUnit creditCardProcessingUnit = new CreditCardProcessingUnit;
        return creditCardProcessingUnit.authorisePayment(creditCard);        
    }    
        
    /**
     * Calls inspectionManager to make next inspection.
     * @return Name of the next inspection to be performed.
     */
    public String getNextInspection(){
        return inspectionManager.getNextInspection();        
    }
    
    /**
     * Calls inspetionManager to enter the result of the inspection.
     * @param result The result of the performed inspection.
     */
    public void enterInspectionResult(String result){
        inspectionManager.enterInspectionResult(result);
    }
    
    /**
     * Prints the receipt.
     * @param receipt Receipt for the paid inspection.
     */
    public void printReceipt(ReceiptDTO receipt){
        printer.printReceipt();
    }
    
    /**
     * Asks if there is any more inspections to be made.
     * @return If there is any more inspections to be made.
     */
    public boolean hasNextInspection(){        
        return inspectionManager.hasNextInspection();
    }
    
    /**
     * Saves the result of the inspection for the later use.
     * @param regNumber Registration number of the car being inspected.
     */
    public void saveInspectionResult(String regNumber){
        inspectionManager.saveInspectionResult(regNumber);
    }
    
    /**
     * Passes inspection results to the printer for the printing.
     */
    public void printResult(){
        printer.printInspectionResult();
    }

}

