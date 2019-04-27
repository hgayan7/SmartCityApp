package com.aidev.him.smartcity.rest;

import com.aidev.him.smartcity.model.Drain;
import com.aidev.him.smartcity.model.Parking;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by him on 1/12/2018.
 */

public interface ApiInterface {
    //API call
    @GET("parkings/getParkings")
    Call<List<Parking>> getParkings();

    @GET("drains/getDrains")
    Call<List<Drain>> getDrains();

}