package com.cdk.pingdom.dto;

/**
 * Created by Jayesh on 5/10/18.
 */
public class Counts {

    private String total;

    private String limited;

    private String filtered;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limited) {
        this.limited = limited;
    }

    public String getFiltered() {
        return filtered;
    }

    public void setFiltered(String filtered) {
        this.filtered = filtered;
    }

    @Override
    public String toString() {
        return "ClassPojo [total = " + total + ", limited = " + limited + ", filtered = " + filtered + "]";
    }
}
