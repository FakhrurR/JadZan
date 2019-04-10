package com.example.jadzan.data.rest;

import com.example.jadzan.data.rest.JadzanApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JadzanService {

    public static final String BASE_URL = "http://api.aladhan.com/v1/";
    public static Retrofit retrofit = null;

    public static Retrofit getAPI() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
