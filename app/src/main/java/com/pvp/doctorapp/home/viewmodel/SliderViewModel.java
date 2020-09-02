package com.pvp.doctorapp.home.viewmodel;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pvp.doctorapp.home.api.SliderApi;
import com.pvp.doctorapp.home.model.SliderInfo;
import com.pvp.doctorapp.home.model.SliderResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SliderViewModel extends ViewModel {
    public MutableLiveData<SliderResponce> sliderResponceMutableLiveData =new MutableLiveData<>();
    public MutableLiveData<SliderInfo> sliderinfo=new MutableLiveData<>();


    public void loadData(Context context){


        SliderApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(SliderApi.class);
        apiInterface.getSlider(RetrofitClientInstance.API_KEY).
                enqueue(new Callback<SliderResponce>() {
            @Override
            public void onResponse(Call<SliderResponce> call, Response<SliderResponce> response) {

                SliderResponce notificationResult=  response.body();
                sliderResponceMutableLiveData.setValue(notificationResult);
                if(notificationResult.status){
                    sliderinfo.setValue(notificationResult.sliderInfos.get(0));
                }

            }

            @Override
            public void onFailure(Call<SliderResponce> call, Throwable t) {

Log.d("","");

            }
        });
    }
}
