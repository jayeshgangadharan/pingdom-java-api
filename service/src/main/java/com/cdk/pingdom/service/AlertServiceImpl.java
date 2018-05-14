package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.CheckDetail;
import com.cdk.pingdom.dto.Checks;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.Resource;

/**
 * Created by Jayesh on 5/9/18.
 */
@Component
public class AlertServiceImpl implements AlertService {

    public static final String SLASH = "/";
    public static final String ALL_CHECKS = "/checks";
    public static final String COMMA = ",";
    public static final String USER_PARAM = "?userids=";

    private static Logger LOGGER = LoggerFactory.getLogger(AlertServiceImpl.class);

    @Resource
    private PingdomConfiguration pingdomConfiguration;

    /**
     * Find all configured alerts in pingdom
     * @return
     */
    public Checks findAllChecks() throws Exception {
        String url = getUrl() + ALL_CHECKS;
        ResponseEntity<Checks> response;

        response = getResponse(url, HttpMethod.GET, Checks.class);
        if(response == null) {
            return null;
        }

        return response.getBody();
    }

    public Check getCheckDetail(Long checkId) throws Exception {
        String url = getUrl() + ALL_CHECKS + SLASH + checkId;
        ResponseEntity<CheckDetail> response;
        response = getResponse(url, HttpMethod.GET, CheckDetail.class);
        if(response == null) {
            return null;
        }

        Check check = response.getBody().getCheck();
        return check;
    }

    public void addUserToCheck(Long checkId, String userids) throws Exception {
        Assert.notNull(checkId, "checkid cannot be null");
        Assert.notNull(userids, "userids cannot be null");

        String url = getUrl() + ALL_CHECKS + SLASH + checkId;

        Check check = getCheckDetail(checkId);


        String existingIds = StringUtils.join(check.getUserids(), ',');
        String newIds;

        if(existingIds != null && existingIds.contains(userids)) {
            LOGGER.info("User already added");
        } else {
            newIds = combineUserIds(userids, existingIds);

            url = url + USER_PARAM + newIds;
            LOGGER.info("adding users={} for checkId={}", newIds, checkId);
            getResponse(url, HttpMethod.PUT, Void.class);
        }
    }

    private String combineUserIds(String userids, String existingIds) {
        String newIds;
        if(existingIds == null) {
            newIds = userids;
        } else {
            newIds = existingIds + COMMA + userids;
        }
        return newIds;
    }

    private <T> ResponseEntity<T> getResponse(String url, HttpMethod method, Class<T> responseType) throws Exception {
        ResponseEntity<T> response;
        try{
            response = getRestTemplate().exchange(url, method, getHttpEntity(), responseType);
        }catch (Exception exception){
            LOGGER.error("Error calling Pingdom API", exception);
            throw exception;
        }
        return response;
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
