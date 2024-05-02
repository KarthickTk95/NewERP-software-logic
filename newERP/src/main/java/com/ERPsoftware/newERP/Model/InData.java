package com.ERPsoftware.newERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeid;
    private String isoutpunch;
    private String punchedtime;
    private Integer processed;
    private String punchtype;
    private String ipaddr;

    // Constructors, getters, and setters


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

    public String getIsoutpunch() {
        return isoutpunch;
    }

    public void setIsoutpunch(String isoutpunch) {
        this.isoutpunch = isoutpunch;
    }

    public String getPunchedtime() {
        return punchedtime;
    }

    public void setPunchedtime(String punchedtime) {
        this.punchedtime = punchedtime;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    public String getPunchtype() {
        return punchtype;
    }

    public void setPunchtype(String punchtype) {
        this.punchtype = punchtype;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }
}
