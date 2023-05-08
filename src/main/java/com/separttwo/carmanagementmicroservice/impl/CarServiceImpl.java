package com.separttwo.carmanagementmicroservice.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.separttwo.carmanagementmicroservice.entities.Car;
import com.separttwo.carmanagementmicroservice.interfaces.CarRepository;
import com.separttwo.carmanagementmicroservice.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendCarToKafka(Car car) {
        Map<String, Object> carData = new HashMap<>();
        carData.put("carID", car.getId());
        carData.put("name", car.getName());
        carData.put("path", car.getImage());
        carData.put("isAvailable", car.getIsAvailable());

        ObjectMapper objectMapper = new ObjectMapper();
        String carDataJsonString;
        try {
            carDataJsonString = objectMapper.writeValueAsString(carData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error, check sendCarToKafka, something wrong with variables/values.");
        }
        kafkaTemplate.send("bookingCarCreate", carDataJsonString);
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
