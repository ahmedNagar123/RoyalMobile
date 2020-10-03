package com.example.roylmobile.api;

import com.example.roylmobile.Model.Phone;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhoneApi {
//    @GET("v1/getlatest")
//    Call<List<Phono>> getPhone(@Query("brand") String brand, @Query("token") String token);


    @GET("v1/getlatest")
     Observable<List<Phone>> getPhone(@Query("brand") String brand, @Query("token") String token);

}
