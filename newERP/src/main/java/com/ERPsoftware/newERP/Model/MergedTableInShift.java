package com.ERPsoftware.newERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MergedTableInShift {

    @Id
    private Long id;
    private Long employeeid;
    private String punchtype_in;
    private String punchedtime_in;
    private String ipaddr_in;

    private String punchtype_out;
    private String punchedtime_out;
    private String ipaddr_out;

    private String in_time;
    private String out_time;
    private String shiftname;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Long employeeid) {
        this.employeeid = employeeid;
    }

    public String getPunchtype_in() {
        return punchtype_in;
    }

    public void setPunchtype_in(String punchtype_in) {
        this.punchtype_in = punchtype_in;
    }

    public String getPunchedtime_in() {
        return punchedtime_in;
    }

    public void setPunchedtime_in(String punchedtime_in) {
        this.punchedtime_in = punchedtime_in;
    }

    public String getIpaddr_in() {
        return ipaddr_in;
    }

    public void setIpaddr_in(String ipaddr_in) {
        this.ipaddr_in = ipaddr_in;
    }

    public String getPunchtype_out() {
        return punchtype_out;
    }

    public void setPunchtype_out(String punchtype_out) {
        this.punchtype_out = punchtype_out;
    }

    public String getPunchedtime_out() {
        return punchedtime_out;
    }

    public void setPunchedtime_out(String punchedtime_out) {
        this.punchedtime_out = punchedtime_out;
    }

    public String getIpaddr_out() {
        return ipaddr_out;
    }

    public void setIpaddr_out(String ipaddr_out) {
        this.ipaddr_out = ipaddr_out;
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
