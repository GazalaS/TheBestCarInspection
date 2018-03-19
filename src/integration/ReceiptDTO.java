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
   

    /**
     * Instantiates a new Receipt object.
     * @param cost to hold the cost.
     * @param reciptDate to hold the date.
     * @param regNumber to hold the car register number.
     */
    public ReceiptDTO( double cost, Date reciptDate, String regNumber) {
      
        this.cost = cost;
        this.receiptDate = reciptDate;
        this.regNumber = regNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public double getCost() {
        return cost;
    }

    

}
