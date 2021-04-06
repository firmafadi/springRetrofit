package com.firma.student.service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitApp {
    public RetrofitService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://hookb.in/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitService.class);
    }
}
