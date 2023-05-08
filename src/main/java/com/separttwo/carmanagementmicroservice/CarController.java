package com.separttwo.carmanagementmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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
