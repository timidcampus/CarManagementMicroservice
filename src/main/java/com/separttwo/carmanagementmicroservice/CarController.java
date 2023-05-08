package com.separttwo.carmanagementmicroservice;

import com.separttwo.carmanagementmicroservice.entities.Car;
import com.separttwo.carmanagementmicroservice.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-rental/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return carService.getCar(id);
    }
}
