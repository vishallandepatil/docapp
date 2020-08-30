package com.pvp.doctorapp.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NotificationResult{
    @SerializedName("message")
    String message;
    @SerializedName("status")
    int apiStatus;
    @SerializedName("result")
    ArrayList<Notification> results;


}
