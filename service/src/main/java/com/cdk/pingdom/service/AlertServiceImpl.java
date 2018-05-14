package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.CheckDetail;
import com.cdk.pingdom.dto.Checks;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
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

        response = getResponse(url, HttpMethod.GET, Checks.class);

        //response = getRestTemplate().exchange(url, HttpMethod.GET, getHttpEntity(), Checks.class);
        return response.getBody();
    }

    private <T> ResponseEntity<T> getResponse(String url, HttpMethod method, Class<T> responseType) {
        ResponseEntity<T> response = getRestTemplate().exchange(url, HttpMethod.GET, getHttpEntity(), responseType);
        return response;
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

    public void addUserToCheck(Check check, Long... userids){
        Assert.isNull(check, "check cannot be null");
        Assert.isNull(check.getId(), "check-id cannot be null");
        Assert.isNull(userids, "userids cannot be null");

        String url = getUrl() + ALL_CHECKS + SLASH + check.getId();




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
