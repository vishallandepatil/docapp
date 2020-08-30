package com.pvp.doctorapp.home.api;

import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.home.model.NotificationResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NotificationApi {
    @GET("/app/getWatchlist.php")
    Call<NotificationResult> getNotifications(@Query("api_key") String api_key, @Query("user_id") String user_id);
}

