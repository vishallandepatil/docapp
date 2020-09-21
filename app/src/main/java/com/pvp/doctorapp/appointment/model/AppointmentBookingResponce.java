package com.pvp.doctorapp.appointment.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public  class AppointmentBookingResponce {
    @SerializedName("status")
    public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("terms_conditions")
    public String terms_conditions;

}
