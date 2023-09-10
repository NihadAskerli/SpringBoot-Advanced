package com.example.restcontrollerdemo.controller;

import com.example.restcontrollerdemo.models.dto.CarDto;
import com.example.restcontrollerdemo.models.payload.CarSave;
import com.example.restcontrollerdemo.models.entities.Car;
import com.example.restcontrollerdemo.models.error.SuccessResponse;
import com.example.restcontrollerdemo.models.response.CarResponse;
import com.example.restcontrollerdemo.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.restcontrollerdemo.models.error.SuccessResponse.success;

@RestController
@RequestMapping(value = "/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/all")
    public SuccessResponse<List> getAllCar() {
        return success(carService.getAllCar());
    }

    @PostMapping("/save")
    public SuccessResponse<CarResponse> saveCar(@RequestBody CarSave carSave) {
        return success(carService.saveCar(carSave));
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<CarDto> getCarByName(@PathVariable String name) {
//
//    }

}

