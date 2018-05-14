package com.cdk.pingdom.dto;


import java.util.List;

/**
 * Created by Jayesh on 5/10/18.
 */
public class Checks {

    private Counts counts;

    private List<Check> checks;

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void setChecks(List<Check> checks) {
        this.checks = checks;
    }
}
