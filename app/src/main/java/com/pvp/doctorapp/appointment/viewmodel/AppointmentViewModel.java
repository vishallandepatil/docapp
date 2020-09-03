package com.pvp.doctorapp.appointment.viewmodel;


import android.content.Context;
import android.util.Log;

import com.pvp.doctorapp.appointment.api.ApointmentsApi;
import com.pvp.doctorapp.appointment.model.AppointmentBookingResponce;
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

    public MutableLiveData<Boolean> isloading =new MutableLiveData<>();
    public MutableLiveData<String> errorMessage =new MutableLiveData<>();


    //   for AppointmentBooking
    public MutableLiveData<AppointmentBookingResponce> appointmentBookingResponceMutableLiveData=new MutableLiveData<>();

    public void loadData(Context context){


        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.getDates(RetrofitClientInstance.API_KEY,RetrofitClientInstance.USERID).
                enqueue(new Callback<DateResponce>() {
            @Override
            public void onResponse(Call<DateResponce> call, Response<DateResponce> response) {


                DateResponce notificationResult=  response.body();
                doctorsResponceMutableLiveData.setValue(notificationResult);
                if(notificationResult.status) {
                    if(notificationResult.availableDates.size()==0) {
                        errorMessage.setValue(null);
                    }
                } else {

                    errorMessage.setValue(notificationResult.message);

                }


            }


            @Override
            public void onFailure(Call<DateResponce> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
Log.d("","");

            }
        });
    }


    public void loadDTimes(Context context,String row_id){

        isloading.setValue(true);

        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.getTiming(RetrofitClientInstance.API_KEY,row_id).
                enqueue(new Callback<TimeResponce>() {
                    @Override
                    public void onResponse(Call<TimeResponce> call, Response<TimeResponce> response) {

                        TimeResponce notificationResult=  response.body();
                        timeResponceMutableLiveData.setValue(notificationResult);
                        isloading.setValue(false);


                    }

                    @Override
                    public void onFailure(Call<TimeResponce> call, Throwable t) {

                        isloading.setValue(false);

                        Log.d("","");

                    }
                });
    }



    public void bookAppointment(Context context, int doctor_id, String date,String time_slot,
                               String email_id, String phone_number ){

        isloading.setValue(true);

        ApointmentsApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(ApointmentsApi.class);
        apiInterface.setBooking(RetrofitClientInstance.API_KEY,doctor_id, date,time_slot,email_id,phone_number).
                enqueue(new Callback<AppointmentBookingResponce>() {
                    @Override
                    public void onResponse(Call<AppointmentBookingResponce> call, Response<AppointmentBookingResponce> response) {

                        AppointmentBookingResponce appointmentBookingResponce=  response.body();
                        appointmentBookingResponceMutableLiveData.setValue(appointmentBookingResponce);
                        Log.e( "chk: ", appointmentBookingResponce.message);
                        isloading.setValue(false);


                    }

                    @Override
                    public void onFailure(Call<AppointmentBookingResponce> call, Throwable t) {

                        isloading.setValue(false);

                        Log.d("","");

                    }
                });
    }
}
