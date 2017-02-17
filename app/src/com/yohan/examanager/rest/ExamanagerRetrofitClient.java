package com.yohan.examanager.rest;

import retrofit2.Retrofit;
import com.google.gson.GsonBuilder;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yohan on 09-02-17.
 */

public class ExamanagerRetrofitClient {
    public static final String BASE_URL = "https://ap2.salesforce.com/services/apexrest/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .build();
        }
        return retrofit;
    }
    public static ApiInterface getInterface(){
        getRetrofitClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        return apiInterface;
    }
}
