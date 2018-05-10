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
     * add a new pingdom alert
     * @param check
     */
    public void addCheck(Check check);

}
