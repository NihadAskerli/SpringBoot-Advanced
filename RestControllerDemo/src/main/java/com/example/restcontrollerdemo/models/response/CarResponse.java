package com.example.restcontrollerdemo.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CarResponse {
    private String name;
    private String model;
    private Integer speed;
    private Integer seatCount;
    private String number;
    private String url;
}
