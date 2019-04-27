package com.aidev.him.smartcity.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by him on 1/12/2018.
 */

public class ApiClient {
    //base url always ends with /
    public static final String BASE_URL="https://smartcityguwahati.herokuapp.com/webapi/";
    private static Retrofit retrofit=null;
    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}