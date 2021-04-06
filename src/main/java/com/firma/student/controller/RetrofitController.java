package com.firma.student.controller;

import com.firma.student.ResponseHandler;
import com.firma.student.service.RetrofitApp;
import com.firma.student.service.RetrofitRequest;
import com.firma.student.service.RetrofitResponse;
import com.firma.student.service.RetrofitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@RestController
@Validated
public class RetrofitController {
    @GetMapping("/retrofit/{id}/{name}")
    public ResponseEntity<Object> getHookbin(@PathVariable("id") String id, @PathVariable("name") String name) throws IOException {
        return getObjectResponseEntity(id, name);
    }

    @PostMapping("/retrofit")
    public ResponseEntity<Object> getHookbinPost(@RequestParam("id") String id, @RequestParam("name") String name) throws IOException {
        return getObjectResponseEntity(id, name);
    }

    @PostMapping("/retrofit/header")
    public ResponseEntity<Object> getHookbinPostHeader(@RequestParam("id") String id, @RequestParam("name") String name) throws IOException {
        RetrofitApp retrofitApp = new RetrofitApp();
        RetrofitRequest retrofitReq = RetrofitRequest.builder().id(id).first_name(name).build();
        Call<RetrofitResponse> call = retrofitApp.getService().test2("userHeader",retrofitReq);
        RetrofitResponse response = call.execute().body();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                false,
                "Success",
                response);
    }

    @PostMapping("/retrofit/costumHeader")
    public ResponseEntity<Object> getHookbinPostHeader2(@RequestParam("id") String id, @RequestParam("name") String name) throws IOException {
        RetrofitApp retrofitApp = new RetrofitApp();
        RetrofitRequest retrofitReq = RetrofitRequest.builder().id(id).first_name(name).build();
        Call<RetrofitResponse> call = retrofitApp.getService().test3(retrofitReq);
        RetrofitResponse response = call.execute().body();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                false,
                "Success",
                response);
    }

    private ResponseEntity<Object> getObjectResponseEntity(String id, String name) throws IOException {
        RetrofitApp retrofitApp = new RetrofitApp();
        RetrofitRequest retrofitReq = RetrofitRequest.builder().id(id).first_name(name).build();
        Call<RetrofitResponse> call = retrofitApp.getService().test(retrofitReq);
        RetrofitResponse response = call.execute().body();

        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                false,
                "Success",
                response);
    }
}
