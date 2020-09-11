package com.pvp.doctorapp.hospital.model;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.utils.PrefManager;

import androidx.databinding.BindingAdapter;

public  class HospitalInfo {
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