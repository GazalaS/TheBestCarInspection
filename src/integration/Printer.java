package integration;

import java.util.List;

/**
 *
 * this class will print the receipt and the inspection result
 *
 *
 */
public class Printer {

    public Printer() {
    }

    /**
     *
     * @param receipt hold all the receipt information.
     */
    public void printReceipt(ReceiptDTO receipt) {
        System.out.println("RegNumber:" + receipt.getRegNumber());
        System.out.println("ReceiptDate:" + receipt.getReceiptDate());
        System.out.println("Cost:" + receipt.getCost());
        System.out.println("Amount:" + receipt.getAmount());
        System.out.println("Change:" + receipt.getChange());
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
