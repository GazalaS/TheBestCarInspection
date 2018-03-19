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
        inspectionManager = new InspectionManager();
        printer = new Printer();                
    }
    
    /**
     * 
     */
    public void startNewInspection{
        garageManager.nextCustomer();
        
        garageManager.closeDoor();
    }
    
    /**
     * 
     * @param regNumber
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
        return creditCardProcessingUnit.authorisePayment();        
    }    
        
    /**
     * 
     * @return 
     */
    public String getNextInspection(){
        inspectionManager.getNextInspection()
    }
    
    /**
     * 
     * @param result 
     */
    public void enterInspectionResult(String result){
        inspectionManager.enterInspectionnResult();
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
        inspectionManager.saveinspectionResult();
    }
    
    /**
     * 
     */
    public void printResult(){
        printer.printInspectionResult();
    }
}

