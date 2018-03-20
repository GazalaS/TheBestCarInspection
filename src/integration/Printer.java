package integration;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * This class will print the receipt and the inspection result
 * @author Abdullah.
 *
 */
public class Printer {

    public Printer() {
    }

    /**
     * This method will print the car register number, date and the inspection cost.
     * @param receipt hold all the receipt information.
     */
    public void printReceipt(ReceiptDTO receipt) {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("RegNumber:" + receipt.getRegNumber());
        System.out.println("ReceiptDate:" + formatter.format(receipt.getReceiptDate()));
        System.out.println("Cost:" + receipt.getCost());
      
    }

    /**
     *
     * @param inspectionResult this parameter will hold the inspection results.
     */
    public void printInspectionResult(List<InspectionInfoDTO> inspectionResult) {
        System.out.println("Inspection results:");
        for (InspectionInfoDTO ins : inspectionResult) {
            System.out.println(ins.getInspectionInformation() + ":" + (ins.getInspectionResult() ? "pass" : "fail"));
        }
    }

}
