
package integration;

import java.util.List;

/**
 * 
 * this class will print the receipt and the inspection result

**/
public class Printer {
    
    
    public Printer(){
    }
   
    /**
     * 
     * @param receipt hold all the receipt information.
     */
    public void printReceipt(ReceiptDTO receipt){
    System.out.println("receipt");
    }
    /**
     * 
     * @param inspectionResult this parameter will hold the inspection results. 
     */
    public void printInspectionResult(List<InspectionInfoDTO> inspectionResult){
    System.out.println(inspectionResult);
    }
    
}
