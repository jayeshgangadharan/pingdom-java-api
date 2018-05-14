package com.cdk.pingdom.dto;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jayesh on 5/9/18.
 */
public class Check {

    private List<Tag> tags;

    private String ipv6;

    private String responsetime_threshold;

    private String status;

    private String[] probe_filters;

    private String hostname;

    private String[] integrationids;

    private String resolution;

    private List<String> userids;

    private Type type;

    private Long id;

    private String lastresponsetime;

    private String notifyagainevery;

    private String created;

    private String lasterrortime;

    private String sendnotificationwhendown;

    private String notifywhenbackup;

    private String name;

    private String lasttesttime;

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public String getResponsetime_threshold() {
        return responsetime_threshold;
    }

    public void setResponsetime_threshold(String responsetime_threshold) {
        this.responsetime_threshold = responsetime_threshold;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getProbe_filters() {
        return probe_filters;
    }

    public void setProbe_filters(String[] probe_filters) {
        this.probe_filters = probe_filters;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String[] getIntegrationids() {
        return integrationids;
    }

    public void setIntegrationids(String[] integrationids) {
        this.integrationids = integrationids;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public List<String> getUserids() {
        return userids;
    }

    public void setUserids(List<String> userids) {
        this.userids = userids;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastresponsetime() {
        return lastresponsetime;
    }

    public void setLastresponsetime(String lastresponsetime) {
        this.lastresponsetime = lastresponsetime;
    }

    public String getNotifyagainevery() {
        return notifyagainevery;
    }

    public void setNotifyagainevery(String notifyagainevery) {
        this.notifyagainevery = notifyagainevery;
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

    public String getSendnotificationwhendown() {
        return sendnotificationwhendown;
    }

    public void setSendnotificationwhendown(String sendnotificationwhendown) {
        this.sendnotificationwhendown = sendnotificationwhendown;
    }

    public String getNotifywhenbackup() {
        return notifywhenbackup;
    }

    public void setNotifywhenbackup(String notifywhenbackup) {
        this.notifywhenbackup = notifywhenbackup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasttesttime() {
        return lasttesttime;
    }

    public void setLasttesttime(String lasttesttime) {
        this.lasttesttime = lasttesttime;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Check{" +
                ", ipv6='" + ipv6 + '\'' +
                ", responsetime_threshold='" + responsetime_threshold + '\'' +
                ", status='" + status + '\'' +
                ", probe_filters=" + Arrays.toString(probe_filters) +
                ", hostname='" + hostname + '\'' +
                ", integrationids=" + Arrays.toString(integrationids) +
                ", resolution='" + resolution + '\'' +
                ", type=" + type +
                ", id='" + id + '\'' +
                ", lastresponsetime='" + lastresponsetime + '\'' +
                ", notifyagainevery='" + notifyagainevery + '\'' +
                ", created='" + created + '\'' +
                ", lasterrortime='" + lasterrortime + '\'' +
                ", sendnotificationwhendown='" + sendnotificationwhendown + '\'' +
                ", notifywhenbackup='" + notifywhenbackup + '\'' +
                ", name='" + name + '\'' +
                ", lasttesttime='" + lasttesttime + '\'' +
                '}';
    }

}
