package com.pvp.doctorapp.firebase.api;

import com.pvp.doctorapp.doctor.model.DoctorsResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TokenApi {
    @FormUrlEncoded
    @POST("/drbooking/setDevice")
    Call<DoctorsResponce> setDevice(
            @Field("skey") String api_key,
            @Field("android_id") String android_id,
            @Field("device_id") String device_id
    );
}
