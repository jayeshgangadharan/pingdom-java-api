package com.cdk.pingdom.dto;

/**
 * Created by Jayesh on 5/9/18.
 */
public class Check {

    private String ipv6;

    private String id;

    private String lastresponsetime;

    private String status;

    private String created;

    private String lasterrortime;

    private String use_legacy_notifications;

    private String name;

    private String hostname;

    private String resolution;

    private String type;

    private String lasttesttime;

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastresponsetime() {
        return lastresponsetime;
    }

    public void setLastresponsetime(String lastresponsetime) {
        this.lastresponsetime = lastresponsetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLasterrortime() {
        return lasterrortime;
    }

    public void setLasterrortime(String lasterrortime) {
        this.lasterrortime = lasterrortime;
    }

    public String getUse_legacy_notifications() {
        return use_legacy_notifications;
    }

    public void setUse_legacy_notifications(String use_legacy_notifications) {
        this.use_legacy_notifications = use_legacy_notifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLasttesttime() {
        return lasttesttime;
    }

    public void setLasttesttime(String lasttesttime) {
        this.lasttesttime = lasttesttime;
    }

    @Override
    public String toString() {
        return "ClassPojo [ipv6 = " + ipv6 + ", id = " + id + ", lastresponsetime = " + lastresponsetime + ", status = " + status + ", created = " + created + ", lasterrortime = " + lasterrortime + ", use_legacy_notifications = " + use_legacy_notifications + ", name = " + name + ", hostname = " + hostname + ", resolution = " + resolution + ", type = " + type + ", lasttesttime = " + lasttesttime + "]";
    }
}
