package com.ERPsoftware.newERP.Controller;

import com.ERPsoftware.newERP.Service.MergedTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MergedTableController {

    @Autowired
    private MergedTableService mergedTableService;

    /*@PostMapping("/insert")
    public void insertIntoMergedTable() {
        mergedTableService.insertIntoMergedTable();
    }*/

    @PostMapping("/insert")
    public String insertIntoMergedTable() {
        boolean success = mergedTableService.insertIntoMergedTable();
        if (success) {
            return "Data inserted into merged table successfully.";
        } else {
            return "Failed to insert data into merged table.";
        }
    }


    @GetMapping("/updateShiftData")
    public String updateShiftData() {
        try {
            mergedTableService.insertShiftData();
            return "Shift data updated successfully!";
        } catch (DataAccessException e) {
            // Handle exception appropriately
            return "Failed to update shift data: " + e.getMessage();
        }
    }
}
