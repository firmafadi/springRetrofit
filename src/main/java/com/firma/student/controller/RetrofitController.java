package com.firma.student.controller;

import com.firma.student.ResponseHandler;
import com.firma.student.service.RetrofitApp;
import com.firma.student.service.RetrofitRequest;
import com.firma.student.service.RetrofitResponse;
import com.firma.student.service.RetrofitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@RestController

public class RetrofitController {
    @GetMapping("/retrofit/{id}/{name}")
    public ResponseEntity<Object> getHookbin(@PathVariable("id") String id, @PathVariable("name") String name) throws IOException {
        return getObjectResponseEntity(id, name);
    }

    @PostMapping("/retrofit")
    public ResponseEntity<Object> getHookbinPost(@RequestParam("id") String id, @RequestParam("name") String name) throws IOException {
        return getObjectResponseEntity(id, name);
    }

    private ResponseEntity<Object> getObjectResponseEntity(@RequestParam("id") String id, @RequestParam("name") String name) throws IOException {
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
