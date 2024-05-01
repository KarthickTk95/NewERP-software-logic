package com.ERPsoftware.newERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MergedTableInShift {

    @Id
    private Long id;
    private Long eid;
    private String direction_in;
    private String captureTime_in;
    private String status_in;
    private String capturedevice_in;
    private String direction_out;
    private String captureTime_out;
    private String status_out;
    private String capturedevice_out;
    private String in_time;
    private String out_time;
    private String shiftname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }

    public String getDirection_in() {
        return direction_in;
    }

    public void setDirection_in(String direction_in) {
        this.direction_in = direction_in;
    }

    public String getCaptureTime_in() {
        return captureTime_in;
    }

    public void setCaptureTime_in(String captureTime_in) {
        this.captureTime_in = captureTime_in;
    }

    public String getStatus_in() {
        return status_in;
    }

    public void setStatus_in(String status_in) {
        this.status_in = status_in;
    }

    public String getCapturedevice_in() {
        return capturedevice_in;
    }

    public void setCapturedevice_in(String capturedevice_in) {
        this.capturedevice_in = capturedevice_in;
    }

    public String getDirection_out() {
        return direction_out;
    }

    public void setDirection_out(String direction_out) {
        this.direction_out = direction_out;
    }

    public String getCaptureTime_out() {
        return captureTime_out;
    }

    public void setCaptureTime_out(String captureTime_out) {
        this.captureTime_out = captureTime_out;
    }

    public String getStatus_out() {
        return status_out;
    }

    public void setStatus_out(String status_out) {
        this.status_out = status_out;
    }

    public String getCapturedevice_out() {
        return capturedevice_out;
    }

    public void setCapturedevice_out(String capturedevice_out) {
        this.capturedevice_out = capturedevice_out;
    }

    public String getIn_time() {
        return in_time;
    }

    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }
}
