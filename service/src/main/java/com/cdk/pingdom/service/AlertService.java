package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.Checks;


/**
 * Created by Jayesh on 5/9/18.
 */
public interface AlertService {


    /**
     * Get all alerts from pingdom
     * @return
     */
    public Checks findAllChecks() throws Exception;

    /**
     * Get Detail for a single check
     * @param checkId
     * @return
     */
    public Check getCheckDetail(Long checkId) throws Exception;

    /**
     * update user to a check for notifications
     * @param checkId
     * @param userids (comma separated user-ids
     */
    public void addUserToCheck(Long checkId, String userids) throws Exception;

}
