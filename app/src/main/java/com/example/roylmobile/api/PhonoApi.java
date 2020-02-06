package com.example.roylmobile.api;

import com.example.roylmobile.Model.Phono;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhonoApi {
    @GET("v1/getlatest")
    Call<List<Phono>> getPhone(@Query("brand") String brand, @Query("token") String token);

}
