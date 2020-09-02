package com.pvp.doctorapp.appointment.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TimeResponce{
    @SerializedName("status")
    public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("availableTimes")
    public ArrayList<AvailableTimes> availableTimes;


}
