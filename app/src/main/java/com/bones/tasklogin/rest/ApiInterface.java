package com.bones.tasklogin.rest;

import com.bones.tasklogin.model.User;
import com.bones.tasklogin.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by lenovo ip on 11/06/2017.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<User> register(@Field("email") String email, @Field("password") String pass);


    @GET("login")
    Call<UserResponse> login();




}
