package com.cdk.pingdom.dto;

/**
 * Created by Jayesh on 5/14/18.
 */
public class Http {

    private String port;
    private String encryption;
    private String url;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
