package com.pvp.doctorapp.home.api;

import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.home.model.NotificationResult;
import com.pvp.doctorapp.home.model.SliderResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface SliderApi {

    @FormUrlEncoded
    @POST("/drbooking/getBanners")
    Call<SliderResponce> getSlider(
            @Field("skey") String api_key
           // @Field("doctor_id") String doctor_id
    );

}

