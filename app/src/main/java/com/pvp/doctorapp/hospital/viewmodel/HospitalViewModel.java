package com.pvp.doctorapp.hospital.viewmodel;


import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.doctor.api.DoctorApi;
import com.pvp.doctorapp.hospital.api.HospitalApi;
import com.pvp.doctorapp.hospital.model.HospitalInfo;
import com.pvp.doctorapp.hospital.model.HospitalResponce;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {
    public MutableLiveData<HospitalResponce> hospitalResponceMutableLiveData=new MutableLiveData<>();
    public MutableLiveData<HospitalInfo> hospitalInfoMutableLiveData=new MutableLiveData<>();

    public MutableLiveData<Boolean> isloading =new MutableLiveData<>();
    public MutableLiveData<Boolean> iserror =new MutableLiveData<>();
    public MutableLiveData<String> errorMessage =new MutableLiveData<>();

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).placeholder(R.drawable.doc).into(view);
    }

    public void loadData(Context context){


        if (Utilities.isNetworkAvailable(context))
        {
            isloading.setValue(true);
           iserror.setValue(false);

        HospitalApi apiInterface = RetrofitClientInstance.getRetrofitInstanceServer().create(HospitalApi.class);
        apiInterface.getHospitals(RetrofitClientInstance.API_KEY, RetrofitClientInstance.getLanguage(context)).
                enqueue(new Callback<HospitalResponce>() {
            @Override
            public void onResponse(Call<HospitalResponce> call, Response<HospitalResponce> response) {

                HospitalResponce hospitalResponce=  response.body();
                hospitalResponceMutableLiveData.setValue(hospitalResponce);
                if(hospitalResponce.status){
                    hospitalInfoMutableLiveData.setValue(hospitalResponce.hospitalsInfo.get(0));
                }
                else {
                    iserror.setValue(true);
                    errorMessage.setValue(hospitalResponce.message);
                }
                isloading.setValue(false);


            }

            @Override
            public void onFailure(Call<HospitalResponce> call, Throwable t) {

                isloading.setValue(false);
                iserror.setValue(true);
                errorMessage.setValue(t.getMessage());

                Log.d("","");

            }
        });

        } else {
            iserror.setValue(true);
            errorMessage.setValue(context.getResources().getString(R.string.interneterror));
        }
    }

    @BindingAdapter("textdr")
    public static void textDr(TextView view, String title) {
        String lang=new PrefManager(view.getContext()).getSELECTLANG();
        if(lang!=null && lang.equalsIgnoreCase("mr")){
            view.setText( title+" बद्दल");
        } else {
            view.setText( "About " +title);


        }
    }
}
