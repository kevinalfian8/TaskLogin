package com.bones.tasklogin.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo ip on 11/06/2017.
 */

public class UserResponse {

    @SerializedName("users")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
