package com.example.restcontrollerdemo.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CarDto {
    String name;
    String model;
    Integer speed;
    Integer seatCount;

}
