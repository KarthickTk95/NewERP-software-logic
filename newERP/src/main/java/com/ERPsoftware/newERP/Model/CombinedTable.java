package com.ERPsoftware.newERP.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "combined_table")
public class CombinedTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Eid")
    private Long Eid;

    @Column(name = "in_direction")
    private String in_direction;

    @Column(name = "incapture_time")
    private String incapture_time;

    @Column(name = "outcapture_time")
    private String outcapture_time;

    @Column(name = "in_capturedevice")
    private String in_capturedevice;

    @Column(name = "out_direction")
    private String out_direction;

    @Column(name = "out_captureTime")
    private String out_captureTime; // Renamed from 'outCaptureTime' to 'outCaptureTimeSecond'

    @Column(name = "out_capturedevice")
    private String out_capturedevice;

    @Column(name = "sid")
    private Long sid;

    @Column(name = "in_time")
    private String in_time;

    @Column(name = "out_time")
    private String out_time;

    @Column(name = "shiftname")
    private String shiftname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEid() {
        return Eid;
    }

    public void setEid(Long eid) {
        Eid = eid;
    }

    public String getIn_direction() {
        return in_direction;
    }

    public void setIn_direction(String in_direction) {
        this.in_direction = in_direction;
    }

    public String getIncapture_time() {
        return incapture_time;
    }

    public void setIncapture_time(String incapture_time) {
        this.incapture_time = incapture_time;
    }

    public String getOutcapture_time() {
        return outcapture_time;
    }

    public void setOutcapture_time(String outcapture_time) {
        this.outcapture_time = outcapture_time;
    }

    public String getIn_capturedevice() {
        return in_capturedevice;
    }

    public void setIn_capturedevice(String in_capturedevice) {
        this.in_capturedevice = in_capturedevice;
    }

    public String getOut_direction() {
        return out_direction;
    }

    public void setOut_direction(String out_direction) {
        this.out_direction = out_direction;
    }

    public String getOut_captureTime() {
        return out_captureTime;
    }

    public void setOut_captureTime(String out_captureTime) {
        this.out_captureTime = out_captureTime;
    }

    public String getOut_capturedevice() {
        return out_capturedevice;
    }

    public void setOut_capturedevice(String out_capturedevice) {
        this.out_capturedevice = out_capturedevice;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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