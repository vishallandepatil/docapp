package com.pvp.doctorapp.doctor.model;

import com.google.gson.annotations.SerializedName;

public  class DoctorsInfo {
    @SerializedName("id")
   public int id;
    @SerializedName("title")
    public String title;
    @SerializedName("img")
    public String img;
    @SerializedName("description")
    public String description;
    @SerializedName("status")
    public String status;
    @SerializedName("created_on")
    public String created_on;

}
