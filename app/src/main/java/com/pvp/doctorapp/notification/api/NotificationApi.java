package com.pvp.doctorapp.notification.api;

import com.pvp.doctorapp.appointment.model.AppointmentBookingResponce;
import com.pvp.doctorapp.appointment.model.DateResponce;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.notification.model.NotificationsResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NotificationApi {

    @FormUrlEncoded
    @POST("/newpro/getNotifications")
    Call<NotificationsResponce> getNotifications(
            @Field("skey") String api_key,
            @Field("android_id") String android_id,
            @Field("lang") String lang

    );


}
