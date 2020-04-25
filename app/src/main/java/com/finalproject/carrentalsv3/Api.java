package com.finalproject.carrentalsv3;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(

            @Field("FirstName") String FirstName,
            @Field("LastName") String LastName,
            @Field("Email") String Email,
            @Field("Password") String Password,
            @Field("Mobile") String Mobile
    );
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(
            @Field("Email") String Email,
            @Field("Password") String Password
    );
}

