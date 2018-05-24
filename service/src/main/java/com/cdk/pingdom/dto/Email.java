package com.cdk.pingdom.dto;

/**
 * Created by Jayesh on 5/18/18.
 */
public class Email {

    private Long id;
    private String severity;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
