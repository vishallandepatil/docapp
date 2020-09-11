package com.pvp.doctorapp.doctor.viewmodel;


import android.content.Context;
import android.util.Log;

import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.doctor.model.DoctorsInfo;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.home.api.NotificationApi;
import com.pvp.doctorapp.home.model.NotificationResult;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorViewModel extends ViewModel {
    public MutableLiveData<DoctorsResponce> doctorsResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<DoctorsInfo> doctorinfo=new MutableLiveData<>();

    public MutableLiveData<Boolean> isloading =new MutableLiveData<>();
    public MutableLiveData<Boolean> iserror =new MutableLiveData<>();
    public MutableLiveData<String> errorMessage =new MutableLiveData<>();

    public void loadData(Context context) {

        if (Utilities.isNetworkAvailable(context)) {


            isloading.setValue(true);
            iserror.setValue(false);
            DoctorApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(DoctorApi.class);
            apiInterface.getDoctors(RetrofitClientInstance.API_KEY,RetrofitClientInstance.getLanguage(context)).
                    enqueue(new Callback<DoctorsResponce>() {
                        @Override
                        public void onResponse(Call<DoctorsResponce> call, Response<DoctorsResponce> response) {

                            DoctorsResponce doctorsResponce = response.body();
                            doctorsResponceMutableLiveData.setValue(doctorsResponce);
                            if (doctorsResponce.status) {
                                doctorinfo.setValue(doctorsResponce.doctorsInfo.get(0));

                                        new PrefManager(context).setDoctore(doctorsResponce.doctorsInfo.get(0).id+"");

                            } else {
                                iserror.setValue(true);
                                errorMessage.setValue(doctorsResponce.message);
                            }
                            isloading.setValue(false);
                        }

                        @Override
                        public void onFailure(Call<DoctorsResponce> call, Throwable t) {

                            isloading.setValue(false);
                            iserror.setValue(true);
                            errorMessage.setValue("Please Check Internet Connection");
                            Log.d("", "");

                        }
                    });


        } else {
            iserror.setValue(true);
            errorMessage.setValue("Please Check Internet Connection");
        }
    }
}
