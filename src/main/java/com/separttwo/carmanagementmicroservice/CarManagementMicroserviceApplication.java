package com.separttwo.carmanagementmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class CarManagementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarManagementMicroserviceApplication.class, args);
    }

}
