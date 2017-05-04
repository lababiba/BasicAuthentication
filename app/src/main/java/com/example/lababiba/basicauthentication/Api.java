package com.example.lababiba.basicauthentication;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by lababiba on 5/4/17.
 */

public interface Api {
    @GET("/echo")
    Call<Response<String>> sendEcho();
}
