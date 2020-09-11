package com.pvp.doctorapp.notification.viewmodel;


import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.pvp.doctorapp.notification.api.NotificationApi;
import com.pvp.doctorapp.notification.model.NotificationsResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;
import com.pvp.doctorapp.utils.Utilities;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsViewModel extends ViewModel {
    public MutableLiveData<NotificationsResponce> notificationResponceMutableLiveData=new MutableLiveData<>();

    public MutableLiveData<Boolean> isloading =new MutableLiveData<>();
    public MutableLiveData<String> errorMessage =new MutableLiveData<>();
    public MutableLiveData<String> date =new MutableLiveData<>();
    public MutableLiveData<Boolean> iserror =new MutableLiveData<>();
    public MutableLiveData<String> mobile =new MutableLiveData<>();




    public void loadData(Context context) {
        if (Utilities.isNetworkAvailable(context)) {
            isloading.setValue(true);

            NotificationApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(NotificationApi.class);
            apiInterface.getNotifications(RetrofitClientInstance.API_KEY, mobile.getValue()).
                    enqueue(new Callback<NotificationsResponce>() {
                        @Override
                        public void onResponse(Call<NotificationsResponce> call,
                                               Response<NotificationsResponce> response) {

                            NotificationsResponce notificationResult = response.body();
                            notificationResponceMutableLiveData.setValue(notificationResult);
                            isloading.setValue(false);
                            if(notificationResult.allNotifications.size()>0) {
                                errorMessage.setValue(null);
                            }


                        }

                        @Override
                        public void onFailure(Call<NotificationsResponce> call, Throwable t) {

                            isloading.setValue(false);
                            errorMessage.setValue(t.getMessage());

                            Log.d("", "");

                        }
                    });
        }


        else {
            errorMessage.setValue("Please Check Internet Connection");
        }
    }



}
