package com.cdk.pingdom.dto;

import java.util.List;

/**
 * Created by Jayesh on 5/18/18.
 */
public class UserListResponse {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
