package com.pvp.doctorapp.doctor.api;

import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.home.model.NotificationResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DoctorApi {
    @FormUrlEncoded
    @POST("/newpro/getDoctors")
    Call<DoctorsResponce> getDoctors(
            @Field("skey") String api_key,
            @Field("doctor_id") String doctor_id
          );
}
