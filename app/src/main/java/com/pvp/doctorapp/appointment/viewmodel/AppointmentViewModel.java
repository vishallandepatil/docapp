package com.pvp.doctorapp.appointment.viewmodel;


import android.content.Context;
import android.util.Log;

import com.pvp.doctorapp.appointment.api.ApointmentsApi;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.DateResponce;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.doctor.model.DoctorsInfo;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentViewModel extends ViewModel {
    public MutableLiveData<DateResponce> doctorsResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<TimeResponce> timeResponceMutableLiveData=new MutableLiveData<>();


    public void loadData(Context context){


        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.getDates(RetrofitClientInstance.API_KEY,RetrofitClientInstance.USERID).
                enqueue(new Callback<DateResponce>() {
            @Override
            public void onResponse(Call<DateResponce> call, Response<DateResponce> response) {

                DateResponce notificationResult=  response.body();
                doctorsResponceMutableLiveData.setValue(notificationResult);


            }

            @Override
            public void onFailure(Call<DateResponce> call, Throwable t) {

Log.d("","");

            }
        });
    }
    public void loadDTimes(Context context,String row_id){


        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.getTiming(RetrofitClientInstance.API_KEY,row_id).
                enqueue(new Callback<TimeResponce>() {
                    @Override
                    public void onResponse(Call<TimeResponce> call, Response<TimeResponce> response) {

                        TimeResponce notificationResult=  response.body();
                        timeResponceMutableLiveData.setValue(notificationResult);


                    }

                    @Override
                    public void onFailure(Call<TimeResponce> call, Throwable t) {

                        Log.d("","");

                    }
                });
    }
}