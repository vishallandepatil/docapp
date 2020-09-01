package com.pvp.doctorapp.hospital.viewmodel;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.hospital.api.HospitalApi;
import com.pvp.doctorapp.hospital.model.HospitalInfo;
import com.pvp.doctorapp.hospital.model.HospitalResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {
    public MutableLiveData<HospitalResponce> hospitalResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<HospitalInfo> hospitalInfoMutableLiveData=new MutableLiveData<>();

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).placeholder(R.drawable.doc).into(view);
    }
    public void loadData(Context context){


        HospitalApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(HospitalApi.class);
        apiInterface.getHospitals(RetrofitClientInstance.API_KEY).enqueue(new Callback<HospitalResponce>() {
            @Override
            public void onResponse(Call<HospitalResponce> call, Response<HospitalResponce> response) {

                HospitalResponce notificationResult=  response.body();
                hospitalResponceMutableLiveData.setValue(notificationResult);
                if(notificationResult.status){
                    hospitalInfoMutableLiveData.setValue(notificationResult.hospitalsInfo.get(0));
                }


            }

            @Override
            public void onFailure(Call<HospitalResponce> call, Throwable t) {

Log.d("","");

            }
        });
    }
}
