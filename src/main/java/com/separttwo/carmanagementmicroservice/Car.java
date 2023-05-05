package com.separttwo.carmanagementmicroservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@RedisHash("Car")
public class Car implements Serializable {
    @Id
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int seats;
    @Getter @Setter
    private double price;
    @Getter @Setter
    private String transmission;
    @Getter @Setter
    private String image;
    @JsonProperty("isAvailable")
    private boolean isAvailable;

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public Car() {}

    public Car(String name, int seats, Double price, String transmission, String image, boolean isAvailable) {
        this.name = name;
        this.seats = seats;
        this.price = price;
        this.transmission = transmission;
        this.image = image;
        this.isAvailable = isAvailable;
    }

}
