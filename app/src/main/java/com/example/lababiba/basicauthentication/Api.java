package com.example.lababiba.basicauthentication;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by lababiba on 5/4/17.
 */

public interface Api {
    @GET("/echo")
    Call<ResponseBody> sendEcho();

    @GET("/user/")
    Call<ResponseBody> getUsers();

    @POST("/registration/")
    Call<ResponseBody> createUser(@Body User user);
}
