package com.pvp.doctorapp.home.model;


import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.doctor.model.DoctorsInfo;

import java.util.ArrayList;

public class SliderResponce {
    @SerializedName("status")
   public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("bannersInfo")
    public ArrayList<SliderInfo> sliderInfos;
    @SerializedName("bannersImgPath")
    public String bannersImgPath;



}
