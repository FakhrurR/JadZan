package com.example.jadzan.data.rest;

import com.example.jadzan.data.model.JadzanResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.jadzan.data.model.JadzanResponse.*;

public interface JadzanApi {

    @GET("calendarByCity")
    Call<JadzanResponse> getPrayerTimeByCity(@Query("city") String city, @Query("country") String country);

}
