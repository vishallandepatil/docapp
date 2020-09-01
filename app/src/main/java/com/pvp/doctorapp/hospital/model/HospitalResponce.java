package com.pvp.doctorapp.hospital.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HospitalResponce {
    @SerializedName("status")
   public boolean status;
    @SerializedName("message")
    public String message;
    @SerializedName("hospitalsInfo")
    public ArrayList<HospitalInfo> hospitalsInfo;
    @SerializedName("hospitalImgPath")
    public String hospitalImgPath;


}
