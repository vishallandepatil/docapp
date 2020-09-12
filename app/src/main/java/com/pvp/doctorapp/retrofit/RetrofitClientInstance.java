package com.pvp.doctorapp.retrofit;



import android.content.Context;

import com.pvp.doctorapp.utils.PrefManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit2;
    public static String API_KEY = "gen";



    private static final String BASE_URL = "http://bcsvirtual.com";


    public static Retrofit getRetrofitInstanceServer() {
        if (retrofit2 == null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }


    public  static String getLanguage(Context context)
    {//
       // eng/mar;
        String lang=new PrefManager(context).getSELECTLANG();
        if(lang!=null && lang.equalsIgnoreCase("mr"))
        {
            return "mar";
        }
        else {
            return "eng";
        }


    }


}
