package com.separttwo.carmanagementmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private KafkaTemplate<String, Car> kafkaTemplate;

    @Override
    public void sendCarToKafka(Car car) {
        kafkaTemplate.send("createdCar", car);
    }
    @Override
    public Car saveCar(Car car) {
        Car savedCar = carRepository.save(car);
        sendCarToKafka(savedCar);
        return savedCar;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public Car getCar(String id) {
        return carRepository.findById(id).orElse(null);
    }



}
