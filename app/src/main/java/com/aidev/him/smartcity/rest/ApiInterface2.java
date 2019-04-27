package com.aidev.him.smartcity.rest;


import com.aidev.him.smartcity.model.Channel;
import com.aidev.him.smartcity.model.Drain;
import com.aidev.him.smartcity.model.Example;
import com.aidev.him.smartcity.model.Feed;
import com.aidev.him.smartcity.model.Parking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface2 {
    //API call
    @GET("channels/729077/feeds.json?api_key=WD38U5G4GGZCDSLP&results=3")
    Call<Example> getExamples();



}