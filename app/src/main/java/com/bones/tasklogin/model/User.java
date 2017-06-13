package com.bones.tasklogin.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo ip on 11/06/2017.
 */

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("token_authentication")
    private String token_authentication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken_authentication() {
        return token_authentication;
    }

    public void setToken_authentication(String token_authentication) {
        this.token_authentication = token_authentication;
    }

    public User(String email,String password){
        this.email = email;
        this.password = password;
    }

}
