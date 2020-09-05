package com.pvp.doctorapp.appointment.viewmodel;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.pvp.doctorapp.appointment.api.ApointmentsApi;
import com.pvp.doctorapp.appointment.model.AppointmentBookingResponce;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.DateResponce;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.doctor.model.DoctorsInfo;
import com.pvp.doctorapp.doctor.model.DoctorsResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;
import com.pvp.doctorapp.utils.Utilities;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppointmentViewModel extends ViewModel {
    public MutableLiveData<DateResponce> doctorsResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<TimeResponce> timeResponceMutableLiveData=new MutableLiveData<>();

    public MutableLiveData<Boolean> isloading =new MutableLiveData<>();
    public MutableLiveData<Boolean> bookingUIVisible =new MutableLiveData<>();
    public MutableLiveData<String> errorMessage =new MutableLiveData<>();
    public MutableLiveData<String> email =new MutableLiveData<>();
    public MutableLiveData<String> mobile =new MutableLiveData<>();
    public MutableLiveData<String> date =new MutableLiveData<>();
    public MutableLiveData<String> timeSlot =new MutableLiveData<>();
    public MutableLiveData<Boolean> iserror =new MutableLiveData<>();


    //   for AppointmentBooking
    public MutableLiveData<AppointmentBookingResponce> appointmentBookingResponceMutableLiveData=new MutableLiveData<>();

    public void loadData(Context context){

if(Utilities.isNetworkAvailable(context)) {

    iserror.setValue(false);
    ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
    apiInterface.getDates(RetrofitClientInstance.API_KEY, RetrofitClientInstance.USERID).
            enqueue(new Callback<DateResponce>() {
                @Override
                public void onResponse(Call<DateResponce> call, Response<DateResponce> response) {


                    DateResponce notificationResult = response.body();
                    doctorsResponceMutableLiveData.setValue(notificationResult);
                    if (notificationResult.status) {
                        if (notificationResult.availableDates.size() == 0) {
                            errorMessage.setValue(null);
                        }
                    } else {

                        iserror.setValue(true);
                        errorMessage.setValue(notificationResult.message);

                    }


                }


                @Override
                public void onFailure(Call<DateResponce> call, Throwable t) {
                    iserror.setValue(true);
                    errorMessage.setValue("Please Check Internet Connection");
                    Log.d("", "");

                }
            });
        }else {
    iserror.setValue(true);
    errorMessage.setValue("Please Check Internet Connection");
        }
    }


    public void loadDTimes(Context context,String row_id) {
        if (Utilities.isNetworkAvailable(context)) {
            isloading.setValue(true);

            ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
            apiInterface.getTiming(RetrofitClientInstance.API_KEY, row_id).
                    enqueue(new Callback<TimeResponce>() {
                        @Override
                        public void onResponse(Call<TimeResponce> call, Response<TimeResponce> response) {

                            TimeResponce notificationResult = response.body();
                            timeResponceMutableLiveData.setValue(notificationResult);
                            isloading.setValue(false);
                            errorMessage.setValue(null);

                        }

                        @Override
                        public void onFailure(Call<TimeResponce> call, Throwable t) {

                            isloading.setValue(false);
                            errorMessage.setValue(null);

                            Log.d("", "");

                        }
                    });
        } else {
            errorMessage.setValue("Please Check Internet Connection");
        }
    }



    public void bookAppointment(Context context, String date,String time_slot){

        if(Utilities.isNetworkAvailable(context)) {

        isloading.setValue(true);

        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.setBooking(RetrofitClientInstance.API_KEY,RetrofitClientInstance.USERID, date,time_slot,email.getValue(),mobile.getValue()).
                enqueue(new Callback<AppointmentBookingResponce>() {
                    @Override
                    public void onResponse(Call<AppointmentBookingResponce> call, Response<AppointmentBookingResponce> response) {

                        AppointmentBookingResponce appointmentBookingResponce=  response.body();
                        if(appointmentBookingResponce.status) {
                            appointmentBookingResponceMutableLiveData.postValue(appointmentBookingResponce);
                            Log.e("chk: ", appointmentBookingResponce.message);
                            errorMessage.postValue(null);
                        } else {

                            errorMessage.postValue(appointmentBookingResponce.message);
                        }
                        bookingUIVisible.postValue(true);

                        isloading.postValue(false);


                    }

                    @Override
                    public void onFailure(Call<AppointmentBookingResponce> call, Throwable t) {
                        bookingUIVisible.postValue(true);
                        isloading.postValue(false);
                        errorMessage.setValue("Please Check Internet Connection");
                        Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });

        } else {
            errorMessage.setValue("Please Check Internet Connection");
        }
    }
}
