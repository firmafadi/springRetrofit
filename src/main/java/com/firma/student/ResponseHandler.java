package com.firma.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put("data", responseObj);
            map.put("error", error);
            map.put("message", message);
            map.put("status", status.value());
            return new ResponseEntity<Object>(map,status);
        } catch (Exception e) {
            map.clear();
            map.put("data", null);
            map.put("message", e.getMessage());
            map.put("error",false);
            map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<Object>(map,status);
        }
    }
}