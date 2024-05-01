package com.ERPsoftware.newERP.Controller;

import com.ERPsoftware.newERP.Model.DataResponse;
import com.ERPsoftware.newERP.Model.RawData;
import com.ERPsoftware.newERP.Model.Shift;
import com.ERPsoftware.newERP.Service.NewService;
import com.ERPsoftware.newERP.Service.YourServiceClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private NewService newService;

    @Autowired
    private YourServiceClassName yourServiceClassName;





    @GetMapping("/records")
    public List<RawData> getAllRecords() {
        return newService.getAllRecords();
    }

    @GetMapping("/shiftRecords")
    public List<Shift> getAllShiftRecords() {
        return newService.getAllShiftRecords();
    }


    @GetMapping("/data")
    public DataResponse getAllData() {
        return yourServiceClassName.getAllData();
    }

  /*  @PostMapping("/insert-combined-data")
    public String insertCombinedData() {
        try {
            yourServiceClassName.insertCombinedData();
            return "Data inserted successfully into combined_table.";
        } catch (DataAccessException e) {
            return "Failed to insert data into combined_table: " + e.getMessage();
        }
    }

    @PostMapping("/update-combined-data")
    public String updateCombinedData() {
        try {
            yourServiceClassName.updateCombinedData();
            return "Data updated successfully in combined_table.";
        } catch (DataAccessException e) {
            return "Failed to update data in combined_table: " + e.getMessage();
        }
    }*/

    @PostMapping("/update-in-data")
    public String updateInData() {
        try {
            yourServiceClassName.insertInData();
            return "Data updated successfully in combined_table.";
        } catch (DataAccessException e) {
            return "Failed to update data in combined_table: " + e.getMessage();
        }
    }

    @PostMapping("/update-out-data")
    public String updateOutData() {
        try {
            yourServiceClassName.insertOutData();
            return "Data updated successfully in combined_table.";
        } catch (DataAccessException e) {
            return "Failed to update data in combined_table: " + e.getMessage();
        }
    }


}
