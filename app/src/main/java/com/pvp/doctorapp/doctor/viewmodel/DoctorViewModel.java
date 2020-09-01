package com.pvp.doctorapp.doctor.viewmodel;


import android.content.Context;
import android.util.Log;

import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.doctor.model.DoctorsInfo;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.home.api.NotificationApi;
import com.pvp.doctorapp.home.model.NotificationResult;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorViewModel extends ViewModel {
    public MutableLiveData<DoctorsResponce> doctorsResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<DoctorsInfo> doctorinfo=new MutableLiveData<>();


    public void loadData(Context context){


        DoctorApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(DoctorApi.class);
        apiInterface.getDoctors(RetrofitClientInstance.API_KEY,RetrofitClientInstance.USERID).enqueue(new Callback<DoctorsResponce>() {
            @Override
            public void onResponse(Call<DoctorsResponce> call, Response<DoctorsResponce> response) {

                DoctorsResponce notificationResult=  response.body();
                doctorsResponceMutableLiveData.setValue(notificationResult);
                if(notificationResult.status){
                    doctorinfo.setValue(notificationResult.doctorsInfo.get(0));
                }

            }

            @Override
            public void onFailure(Call<DoctorsResponce> call, Throwable t) {

Log.d("","");

            }
        });
    }
}
