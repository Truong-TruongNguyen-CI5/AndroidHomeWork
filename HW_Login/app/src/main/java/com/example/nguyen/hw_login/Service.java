package com.example.nguyen.hw_login;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Nguyen on 11/4/2016.
 */

public interface Service  {
    @GET("/api/{login}")
    Call<JSonModelsRespone> result (@Path("login") String username);

    @POST("/api/{login}")
    Call<JSonModelsRespone> login(@Path("login") String postfix, @Body RequestBody params);

}
