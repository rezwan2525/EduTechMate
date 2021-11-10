package com.rezwan2525.edutechmate.commons;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private final static String BASE_URL = "https://ide.geeksforgeeks.org/";
    private static Retrofit retrofit;

    public RetrofitInstance(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static synchronized Retrofit getRetrofitInstance(){
        if(retrofit == null){
            new RetrofitInstance();
        }
        return retrofit;
    }
}

