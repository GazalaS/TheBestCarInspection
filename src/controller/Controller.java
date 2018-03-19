package controller;

import javafx.print.Printer;
import se.kth.sda.model.GarageManager;
import se.kth.sda.model.InspectionManager;


public class Controller {    
    
    private GarageManager garageManager;
    private InspectionManager inspectionManager;
    private Printer printer;
    private CreditCardProcessingUnit creditCardProcessingUnit;
    
    /**
     * Creates controller andd makes new Garage manager, Ispection manager
     * and Printer objects.
     */    
    public Controller() {
        garageManager = new GarageManager();
        printer = new Printer();
        inspectionManager = new InspectionManager(printer);                      
    }
    
    /**
     * Calls the next customer method from the garage manager, then waits 3 sec
     * and closes the door after the customer is in the garage.
     */
    public void startNewInspection{
        garageManager.nextCustomer();
        Thread.sleep(3000);
        garageManager.closeDoor();
    }
    
    /**
     * Gets cost of the inspection baset on the list of inspection that is 
     * provided based on the registration number.
     * @param regNumber Registration
     * @return 
     */
    public double getInspectionCost(String regNumber){
        return inspectionManager.getInspectionCost();        
    }
    
    /**
     * 
     * @param creditCard
     * @return 
     */
    public boolean authorisePayment(CreditCardDTO creditCard){        
        CreditCardProcessingUnit creditCardProcessingUnit = new CreditCardProcessingUnit;   //???
        return creditCardProcessingUnit.authorisePayment(creditCard);        
    }    
        
    /**
     * 
     * @return 
     */
    public String getNextInspection(){
        return inspectionManager.getNextInspection();        
    }
    
    /**
     * 
     * @param result 
     */
    public void enterInspectionResult(String result){
        inspectionManager.enterInspectionnResult(result);
    }
    
    /**
     * 
     * @param receipt 
     */
    public void printReceipt(ReceiptDTO receipt){
        printer.printReceipt();
    }
    
    /**
     * 
     * @return 
     */
    public boolean hasNextInspection(){        
        return inspectionManager.hasNextInspection();
    }
    
    /**
     * 
     * @param regNumber 
     */
    public void saveInspectionResult(String regNumber){
        inspectionManager.saveInspectionResult(regNumber);
    }
    
    /**
     * 
     */
    public void printResult(){
        printer.printInspectionResult();
    }
}

