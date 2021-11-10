package com.rezwan2525.edutechmate.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanceRapid {
    private final static String BASE_URL_SMS = "https://rapidapi.rmlconnect.net:9443/";
    private final static String BASE_URL = "https://rapidapi.rmlconnect.net/";
    private static Retrofit retrofitSMS, retrofit;

    public RetrofitInstanceRapid(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofitSMS = new Retrofit.Builder()
                .baseUrl(BASE_URL_SMS)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


    public static synchronized Retrofit getRetrofitInstanceRapidSMS(){
        if(retrofitSMS == null){
            new RetrofitInstanceRapid();
        }
        return retrofitSMS;
    }

    public static synchronized Retrofit getRetrofitInstanceRapid(){
        if(retrofit == null){
            new RetrofitInstanceRapid();
        }
        return retrofit;
    }
}
