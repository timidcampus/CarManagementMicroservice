package com.separttwo.carmanagementmicroservice;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);
    List<Car> getAllCars();
    Car getCar(String id);
}
