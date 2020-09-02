package com.pvp.doctorapp.doctor.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DoctorsResponce{
    @SerializedName("status")
   public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("doctorsInfo")
    public ArrayList<DoctorsInfo> doctorsInfo;
    @SerializedName("doctosImgPath")
    public String doctosImgPath;




}
