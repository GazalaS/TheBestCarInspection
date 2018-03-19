//
package integration;

import java.util.Date;
/**
 * 
 * This is a DTO class which hold the receipt information.
 */

public class ReceiptDTO {
    private String regNumber;
    private Date receiptDate;
    private double cost;
    private double amount;
    private double change;
    /**
     * Instantiates a new Receipt object.
     * @param change to hold the money balance.
     * @param amount to hold the money amount
     * @param cost   to hold the cost.
     * @param reciptDate to hold the date. 
     * @param regNumber  to hold the car register number.
     */
    
    public ReceiptDTO(double change,double amount, double cost, Date reciptDate, String regNumber){
    this.change=change;
    this.amount=amount;
    this.cost=cost;
    this.receiptDate=reciptDate;
    this.regNumber=regNumber;
    
    
    } 
    
}
