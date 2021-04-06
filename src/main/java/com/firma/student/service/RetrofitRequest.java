package com.firma.student.service;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RetrofitRequest {
    private String id;
    private String first_name;
}
