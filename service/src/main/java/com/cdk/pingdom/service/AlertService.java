package com.cdk.pingdom.service;

import com.cdk.pingdom.dto.Check;
import com.cdk.pingdom.dto.Checks;
import com.cdk.pingdom.dto.UserListResponse;
import com.cdk.pingdom.dto.UserResponse;


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

    /**
     * create a new contact for sending alerts
     * @param name
     * @param email
     * @throws Exception
     */
    public UserResponse addContact(String name, String email) throws Exception;


    /**
     * find all users
     * @return
     */
    public UserListResponse findAllUsers() throws Exception;

}
