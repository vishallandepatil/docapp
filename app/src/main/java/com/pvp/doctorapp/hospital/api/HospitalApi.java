package com.pvp.doctorapp.hospital.api;

import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.hospital.model.HospitalResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HospitalApi {
    @FormUrlEncoded
    @POST("newpro/getHospitals")
    Call<HospitalResponce> getHospitals(
            @Field("skey") String api_key,
            @Field("lang") String lang

    );
}
