package com.firma.student.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitService {

    @POST("/oXYXEnLLymf1mmLaR07V")
    Call<RetrofitResponse> test(@Body RetrofitRequest request);
}
