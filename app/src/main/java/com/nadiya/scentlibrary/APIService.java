package com.nadiya.scentlibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
    @FormUrlEncoded
    @POST("auth/login")
    Call<ValueData<User>> login(@Field("username") String username,
                                @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register")
    Call<ValueData<User>> register(@Field("username") String username,
                                   @Field("password") String password);

    @GET("addperfume")
    Call<ValueData<List<Add>>> getPerfume();

    @FormUrlEncoded
    @POST("addperfume")
    Call<ValueNoData> addPerfume(@Field("merekperfume") String MerkPerfume,
                                 @Field("namaperfume") String NamaPerfume,
                                 @Field("deskripsiperfume") String DeskripsiPerfume,
                                 @Field("jenisperfume") String JenisPerfume,
                                 @Field("ukuranperfume") Integer UkuranPerfume,
                                 @Field("hargaperfume") Integer HargaPerfume,
                                 @Field("genderperfume") String GenderPerfume,
                                 @Field("user_id") String User_id);

    @FormUrlEncoded
    @PUT("addperfume")
    Call<ValueNoData> updateAdd(@Field("id") String id,
                                @Field("merekperfume") String MerkPerfume,
                                @Field("namaperfume") String NamaPerfume,
                                @Field("deskripsiperfume") String DeskripsiPerfume,
                                @Field("jenisperfume") String JenisPerfume,
                                @Field("ukuranperfume") String UkuranPerfume,
                                @Field("hargaperfume") String HargaPerfume,
                                @Field("genderperfume") String GenderPerfume);


    @DELETE("addperfume/{id}")
    Call<ValueNoData> deleteAdd(@Path("id") String id);

//    Call<ValueNoData> addPerfume(String userId, String merek, String nama, String deskripsi, String jenis, int ukuran, int harga, String gender);
}
