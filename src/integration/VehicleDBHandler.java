/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Populates and saves Inspection Details into DB(in this case a file)
 *
 * @author GazalaS <gazalafshaikh@gmail.com>
 */
public class VehicleDBHandler {
   
    private final static String INSPECTION_CHECKLIST_FILE = "inspectionchecklist.txt";

    /**
     * Gets Inspection Checklist from DB for a particulare regNumber
     *
     * @param regNumber Registration number of the specify vehicle.
     * @return List <code>{@link InspectionInfoDTO}</code> object for
     * particulare regNumber
     * @throws IOException
     */
    public List<InspectionInfoDTO> getInspectionChecklist(String regNumber) throws IOException {
        // Make sure the file can be found.
        List<InspectionInfoDTO> inspectionChecklist = new ArrayList<InspectionInfoDTO>();
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(regNumber + INSPECTION_CHECKLIST_FILE);
        if (Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}))
        {
            BufferedReader reader = Files.newBufferedReader(path, charset);
            String details;
            while ((details = reader.readLine()) != null) {
                String[] sections = details.split(",");
                InspectionInfoDTO inspectionInfo = new InspectionInfoDTO(
                        sections[0],
                        Double.parseDouble(sections[1]),
                        Boolean.parseBoolean(sections[2]));
                inspectionChecklist.add(inspectionInfo);
                
            }   
        } 
        return inspectionChecklist;
    }

    /**
     * Saves the inspection list
     *
     * @param regNumber Registration number of the specify vehicle. List
     * <code>{@link InspectionInfoDTO}</code> object for particulare regNumber.
     * @return boolean if file exist and data is saved.
     * @throws IOException
     */
    public boolean saveInspectionChecklist(String regNumber, List<InspectionInfoDTO> inspectionChecklist) throws IOException {
        Path resultsFile = Paths.get(regNumber + INSPECTION_CHECKLIST_FILE).toAbsolutePath();
        FileWriter writer = new FileWriter(resultsFile.toString());
        for (InspectionInfoDTO details : inspectionChecklist) {
            writer.write(details.getInspectionInformation() + "," + details.getPrice() + "," + details.getInspectionResult());
            writer.write('\n');
        }
        writer.close();

        File file = new File(regNumber + INSPECTION_CHECKLIST_FILE);
        return file.exists();
    }
}
