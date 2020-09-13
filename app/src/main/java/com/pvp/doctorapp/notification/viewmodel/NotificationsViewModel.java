package com.pvp.doctorapp.notification.viewmodel;


import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.pvp.doctorapp.R;
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

            String androidId = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            Log.e( "loadData: ", androidId);

            NotificationApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(NotificationApi.class);
            apiInterface.getNotifications(RetrofitClientInstance.API_KEY, androidId, RetrofitClientInstance.getLanguage(context)).
                    enqueue(new Callback<NotificationsResponce>() {
                        @Override
                        public void onResponse(Call<NotificationsResponce> call,
                                               Response<NotificationsResponce> response) {

                            NotificationsResponce notificationResult = response.body();
                            notificationResponceMutableLiveData.setValue(notificationResult);

                            if(notificationResult.allNotifications.size()>0) {
                                errorMessage.postValue(null);
                                isloading.postValue(false);
                                iserror.setValue(false);
                            }

                            else {
                                isloading.postValue(true);
                                iserror.setValue(true);
                                //errorMessage.postValue(notificationResult.message);
                            }


                        }

                        @Override
                        public void onFailure(Call<NotificationsResponce> call, Throwable t) {

                            isloading.postValue(true);
                            errorMessage.postValue(t.getMessage());
                            iserror.setValue(true);

                            Log.d("", "");

                        }
                    });
        }


        else {
            errorMessage.setValue(context.getString(R.string.interneterror));
            iserror.setValue(true);
        }
    }



}
