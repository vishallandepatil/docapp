package com.pvp.doctorapp.appointment.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public  class DateResponce{
    @SerializedName("status")
    public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("availableDates")
    public ArrayList<AvailableDates> availableDates;

}
