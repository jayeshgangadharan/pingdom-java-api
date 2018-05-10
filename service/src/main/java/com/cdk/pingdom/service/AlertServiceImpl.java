package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.Checks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by Jayesh on 5/9/18.
 */
@Component
public class AlertServiceImpl implements AlertService {

    @Resource
    private PingdomConfiguration pingdomConfiguration;

    public static final String ALL_CHECKS = "/checks";


    /**
     * Find all configured alerts in pingdom
     * @return
     */
    public Checks findAllChecks() {
        ResponseEntity<Checks> response = getRestTemplate().exchange(getUrl() + ALL_CHECKS,
                HttpMethod.GET, getHttpEntity(), Checks.class);
        return response.getBody();
    }

    public void addCheck(Check check) {

    }

    public RestTemplate getRestTemplate() {
        return pingdomConfiguration.getRestTemplate();
    }

    private String getUrl() {
        return pingdomConfiguration.getPingdomUrl();
    }

    private HttpEntity getHttpEntity() {
        return pingdomConfiguration.getHttpEntity();
    }

    public void setPingdomConfiguration(PingdomConfiguration pingdomConfiguration) {
        this.pingdomConfiguration = pingdomConfiguration;
    }
}
