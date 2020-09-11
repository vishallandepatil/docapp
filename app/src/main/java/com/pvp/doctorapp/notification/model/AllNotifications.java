package com.pvp.doctorapp.notification.model;

import com.google.gson.annotations.SerializedName;

public class AllNotifications {
@SerializedName("notification_title")
public String notification_title;
@SerializedName("notification_message")
public String notification_message;
@SerializedName("created_on")
public String created_on;
}

