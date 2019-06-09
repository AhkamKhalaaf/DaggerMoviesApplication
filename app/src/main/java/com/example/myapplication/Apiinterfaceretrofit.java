package com.example.myapplication;

import com.example.myapplication.utils.Apiresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterfaceretrofit {
    @GET("movie")
    Call<Apiresponse> getData(@Query("api_key") String api_key, @Query("query") String query, @Query("page") int page);
}
