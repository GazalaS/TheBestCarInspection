/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 * Contains information of individual checklist entry along with it price and inspection result
 * 
 * @author GazalaS <gazalafshaikh@gmail.com>
 */

public class InspectionInfoDTO {
    private String inspectionInformation;
    private double price;
    private boolean inspectionResult;
    
   /**
    * 
    * @param inspectionInformation
    * @param price 
    */
    
    public InspectionInfoDTO(String inspectionInformation, double price, boolean inspectionResult){
        this.inspectionInformation = inspectionInformation;
        this.price = price;
        this.inspectionResult = inspectionResult;
    }
    
    /**
     * Returns price for an inspection  
     * @return double
     */
    public double getPrice(){
        return price;
    }
    
   /**
    * Returns information for an inspection  
    * @return 
    */
    public String getInspectionInformation(){
        return inspectionInformation;
    }
    
    /**
     * Returns result for an inspection
     * @return 
     */
    public boolean getInspectionResult(){
        return inspectionResult;
    }
    
    /**
     * Set the result of the inspection
     * @param result true/false 
     */
    public void setInspectionResult(boolean result){
        this.inspectionResult = result;
    }
    
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        InspectionInfoDTO inspectionInfoDTO = (InspectionInfoDTO) o;
        if(!inspectionInformation.equals(inspectionInfoDTO.inspectionInformation)) return false;
        if(price != inspectionInfoDTO.price) return false;
        if(inspectionResult != inspectionInfoDTO.inspectionResult) return false;
        return true;
    }
}
