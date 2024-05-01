package com.ERPsoftware.newERP.Model;

import jakarta.persistence.Entity;

import java.util.List;

public class DataResponse {
    private List<RawData> rawDataList;
    private List<Shift> shiftList;

    public DataResponse(List<RawData> rawDataList, List<Shift> shiftList) {
        this.rawDataList = rawDataList;
        this.shiftList = shiftList;
    }

    public List<RawData> getRawDataList() {
        return rawDataList;
    }

    public void setRawDataList(List<RawData> rawDataList) {
        this.rawDataList = rawDataList;
    }

    public List<Shift> getShiftList() {
        return shiftList;
    }

    public void setShiftList(List<Shift> shiftList) {
        this.shiftList = shiftList;
    }
// Add getters and setters
}

