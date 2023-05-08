package com.separttwo.carmanagementmicroservice.kafkalisteners;

import com.separttwo.carmanagementmicroservice.Car;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "createdCar", groupId = "groupId")
    void listener(Car car) {
        System.out.println("Listener received " + car.getName());
    }

}
