package com.example.restcontrollerdemo.service;

import com.example.restcontrollerdemo.models.dto.CarDto;
import com.example.restcontrollerdemo.models.entities.Car;
import com.example.restcontrollerdemo.models.entities.User;
import com.example.restcontrollerdemo.models.payload.CarSave;
import com.example.restcontrollerdemo.models.response.CarResponse;
import com.example.restcontrollerdemo.repo.CarRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepo carRepo;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    public List<CarResponse> getAllCar() {
        return carRepo.findAll().stream().map(this::convertCarResponse).toList();
    }
    public CarResponse saveCar(CarSave carSave){
        User user=userService.findUserByFinCode(carSave.getUserFinCode());
        Car car=objectMapper.convertValue(carSave,Car.class);
        car.setUser(user);
        Car car1=carRepo.save(car);
        CarDto carDto=CarDto.builder().name(car1.getName()).speed(car1.getSpeed()).model(car1.getModel()).build();
        return objectMapper.convertValue(carDto, CarResponse.class);
    }
// private method
    private CarResponse convertCarResponse(Car car) {
        return CarResponse.builder().speed(car.getSpeed()).number(car.getNumber())
                .model(car.getModel()).name(car.getName()).seatCount(car.getSeatCount()).build();

    }
}
