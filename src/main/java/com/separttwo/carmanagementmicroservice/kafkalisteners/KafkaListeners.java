package com.separttwo.carmanagementmicroservice.kafkalisteners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.separttwo.carmanagementmicroservice.entities.Car;

import com.separttwo.carmanagementmicroservice.interfaces.CarRepository;
import com.separttwo.carmanagementmicroservice.interfaces.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class KafkaListeners {

    @Autowired
    private CarService carService;


    @KafkaListener(topics = {"bookingCarRequestNotAvailable"}, groupId = "groupId")
    void listenerFalse(String data) {
        ObjectMapper objectMapperFalse = new ObjectMapper();
        Map<String, Object> dataResponseDataJson;
        try {
            dataResponseDataJson = objectMapperFalse.readValue(data, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while converting JSON into Map<String, Object>.");
        }

        System.out.println("Car Service: " + dataResponseDataJson.get("carID"));

        Car updatedCar = carService.getCar((String) dataResponseDataJson.get("carID"));
        updatedCar.setIsAvailable(false);
        carService.saveCar(updatedCar);

    }

    @KafkaListener(topics = {"bookingCarRequestAvailable"}, groupId = "groupId")
    void listenerTrue(String data) {
        ObjectMapper objectMapperTrue = new ObjectMapper();
        Map<String, Object> dataResponseDataJson;
        try {
            dataResponseDataJson = objectMapperTrue.readValue(data, new TypeReference<Map<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while converting JSON into Map<String, Object>.");
        }

        System.out.println("Car Service: " + dataResponseDataJson.get("carID"));

        Car updatedCar = carService.getCar((String) dataResponseDataJson.get("carID"));
        updatedCar.setIsAvailable(true);
        carService.saveCar(updatedCar);

    }


}
