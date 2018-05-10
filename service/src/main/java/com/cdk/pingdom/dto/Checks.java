package com.cdk.pingdom.dto;

/**
 * Created by Jayesh on 5/10/18.
 */
public class Checks {

    private Counts counts;

    private Checks[] checks;

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public Checks[] getChecks() {
        return checks;
    }

    public void setChecks(Checks[] checks) {
        this.checks = checks;
    }

    @Override
    public String toString() {
        return "ClassPojo [counts = " + counts + ", checks = " + checks + "]";
    }
}
