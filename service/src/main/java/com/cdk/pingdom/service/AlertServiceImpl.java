package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.CheckDetail;
import com.cdk.pingdom.dto.Checks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Jayesh on 5/9/18.
 */
@Component
public class AlertServiceImpl implements AlertService {

    public static final String SLASH = "/";
    public static final String ALL_CHECKS = "/checks";

    @Resource
    private PingdomConfiguration pingdomConfiguration;

    /**
     * Find all configured alerts in pingdom
     * @return
     */
    public Checks findAllChecks() {
        String url = getUrl() + ALL_CHECKS;
        ResponseEntity<Checks> response;
        response = getRestTemplate().exchange(url, HttpMethod.GET, getHttpEntity(), Checks.class);
        return response.getBody();
    }

    public Check getCheckDetail(long checkId) {
        String url = getUrl() + ALL_CHECKS + SLASH + checkId;
        ResponseEntity<CheckDetail> response;
        try {
            response = getRestTemplate().exchange(url, HttpMethod.GET, getHttpEntity(), CheckDetail.class);
        } catch (Exception exception) {
            return null;
        }
        Check check = response.getBody().getCheck();
        return check;
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
