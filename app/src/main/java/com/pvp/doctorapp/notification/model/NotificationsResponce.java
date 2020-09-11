package com.pvp.doctorapp.notification.model;


import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.appointment.model.AvailableTimes;

import java.util.ArrayList;

public class NotificationsResponce {
    @SerializedName("status")
    public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("allNotifications")
    public ArrayList<AllNotifications> allNotifications;


}
