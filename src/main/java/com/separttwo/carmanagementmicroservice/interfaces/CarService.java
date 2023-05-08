package com.separttwo.carmanagementmicroservice.interfaces;

import com.separttwo.carmanagementmicroservice.entities.Car;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCar(String id);
    void sendCarToKafka(Car car);
}
