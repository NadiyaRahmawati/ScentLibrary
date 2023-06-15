package com.nadiya.scentlibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                   @Field("password") String password);

    @FormUrlEncoded
    @GET("perfume")
    Call<ValueData<List<Add>>> getPerfume();

    @FormUrlEncoded
    @POST("perfume")
    Call<ValueNoData> addPerfume(@Field("MerekPerfume") String MerkPerfume,
                                 @Field("NamaPerfume") String NamaPerfume,
                                 @Field("DeskripsiPerfume") String DeskripsiPerfume,
                                 @Field("JenisPerfume") String JenisPerfume,
                                 @Field("UkuranPerfume") Integer UkuranPerfume,
                                 @Field("HargaPerfume") Integer HargaPerfume,
                                 @Field("GenderPerfume") String GenderPerfume,
                                 @Field("User_id") String User_id);
}
