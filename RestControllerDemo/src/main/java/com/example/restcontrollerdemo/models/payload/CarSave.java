package com.example.restcontrollerdemo.models.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarSave {
    private String name;
    private String model;
    private Integer speed;
    private Integer seatCount;
    private String number;
    private String userFinCode;


}
