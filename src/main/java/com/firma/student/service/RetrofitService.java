package com.firma.student.service;

import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitService {

    @POST("/oXYXEnLLymf1mmLaR07V")
    Call<RetrofitResponse> test(@Body RetrofitRequest request);

    @POST("/oXYXEnLLymf1mmLaR07V")
    Call<RetrofitResponse> test2(@Header("Authorization") String authorization, @Body RetrofitRequest request);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: 12345156"
    })
    @POST("/oXYXEnLLymf1mmLaR07V")
    Call<RetrofitResponse> test3(@Body RetrofitRequest request);
}
