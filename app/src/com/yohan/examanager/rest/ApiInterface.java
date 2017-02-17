package com.yohan.examanager.rest;

import com.yohan.examanager.model.EnrollMe;
import com.yohan.examanager.model.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Yohan on 09-02-17.
 */

public interface ApiInterface {
    @GET("examanager/{getWhat}")
    Call<String> getCall(@Header("Authorization") String authString, @Path("getWhat") String getWhat, @Query("id") String id);

    @GET("examanager/profile")
    Call<String> getProfileCall(@Header("Authorization") String authString, @Query("id") String id);

    @PUT("examanager/{putWhat}")
    Call<String> updateProfile(@Header("Authorization") String authString, @Path("putWhat") String putWhat , @Body Profile profile);

    @PUT("examanager/{putWhat}")
    Call<String> enrollMe(@Header("Authorization") String authString, @Path("putWhat") String putWhat, @Body EnrollMe enrollMe);

}
