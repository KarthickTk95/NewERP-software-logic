package com.ERPsoftware.newERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InData {

    @Id
    private int id;
    private int eid;
    private String direction;
    private String captureTime;
    private int status;
    private String captureDevice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCaptureDevice() {
        return captureDevice;
    }

    public void setCaptureDevice(String captureDevice) {
        this.captureDevice = captureDevice;
    }
}
