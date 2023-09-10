package com.example.restcontrollerdemo.repo;

import com.example.restcontrollerdemo.models.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {
}
