package com.finalproject.carrentalsv3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Singleton for retrofit
    //private static final String BASE_URL = " https://localhost//:8082/"; //192.168.2.14
    private static final String BASE_URL = " https://0335c9b4.ngrok.io/"; //Used a 3rd party application as localhost was not working properly
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }
    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
