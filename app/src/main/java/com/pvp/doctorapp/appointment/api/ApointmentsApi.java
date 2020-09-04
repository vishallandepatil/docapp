package com.pvp.doctorapp.appointment.api;

import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.appointment.model.AppointmentBookingResponce;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.DateResponce;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApointmentsApi {
    @FormUrlEncoded
    @POST("/newpro/getDates")
    Call<DateResponce> getDates(
            @Field("skey") String api_key,
            @Field("doctor_id") String doctor_id
    );

    @FormUrlEncoded
    @POST("/newpro/getTiming")
    Call<TimeResponce> getTiming(
            @Field("skey") String api_key,
            @Field("row_id") String row_id
    );

    @FormUrlEncoded
    @POST("/newpro/setBooking")
    Call<AppointmentBookingResponce> setBooking(
            @Field("skey") String api_key,
            @Field("doctor_id") String doctor_id,
            @Field("date") String date,
            @Field("time_slot") String time_slot,
            @Field("email_id") String email_id,
            @Field("phone_number") String phone_number
    );
}
