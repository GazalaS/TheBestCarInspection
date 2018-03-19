/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class VehicleDBHandler {
    
    private List<InspectionInfoDTO> inspectionChecklist;
    private static String INSPECTION_CHECKLIST_FILE = "inspectionchecklist.txt";
    
    /**
     * 
     */
    public VehicleDBHandler(){
        inspectionChecklist = new ArrayList<InspectionInfoDTO>();        
    }
    
    /**
     * Reads the inspection Checklist 
     * @return
     * @throws IOException 
     */
    public List<InspectionInfoDTO> getInspectionChecklist(String regNumber)throws IOException {
        // Make sure the file can be found.
        INSPECTION_CHECKLIST_FILE = regNumber + INSPECTION_CHECKLIST_FILE;
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(INSPECTION_CHECKLIST_FILE);
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String details;
            while((details = reader.readLine()) != null) {
                String[] sections = details.split(",");
                InspectionInfoDTO inspectionInfo = new InspectionInfoDTO(
                                                     sections[0],
                                                     Double.parseDouble(sections[1]),
                                                      Boolean.parseBoolean(sections[2]));
                inspectionChecklist.add(inspectionInfo);
                details = reader.readLine();
            }
        }
        
        catch(FileNotFoundException e) {
            System.err.println("Unable to open " + INSPECTION_CHECKLIST_FILE);
        }
        catch(IOException e) {
            System.err.println("A problem was encountered reading " +
                               INSPECTION_CHECKLIST_FILE);
        }
    
        return inspectionChecklist;
    }
    
    /**
     * Saves the inspection list
     * @param inspectionChecklist
     * @throws IOException 
     */
    public void saveInspectionChecklist(String regNumber, List<InspectionInfoDTO> inspectionChecklist) throws IOException{
        INSPECTION_CHECKLIST_FILE = regNumber + INSPECTION_CHECKLIST_FILE;
        Path resultsFile = Paths.get(INSPECTION_CHECKLIST_FILE).toAbsolutePath();
        FileWriter writer = new FileWriter(resultsFile.toString());
        for(InspectionInfoDTO details : inspectionChecklist) {
            writer.write(details.getInspectionInformation()+","+details.getPrice()+","+details.getInspectionResult());
            writer.write('\n');
        }
        writer.close();
    }  
}

