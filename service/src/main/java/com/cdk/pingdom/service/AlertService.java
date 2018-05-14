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
    public Checks findAllChecks();

    /**
     * Get Detail for a single check
     * @param checkId
     * @return
     */
    public Check getCheckDetail(long checkId);

    /**
     * update user to a check for notifications
     * @param check
     */
    public void addUserToCheck(Check check, Long... userids);

}
