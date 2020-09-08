package com.pvp.doctorapp.retrofit;



import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit2;
    public static String API_KEY = "gen";

    private static final String BASE_URL = "http://www.genekatechnologies.in";


    public static Retrofit getRetrofitInstanceServer() {
        if (retrofit2 == null) {
            retrofit2 = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit2;
    }


}
