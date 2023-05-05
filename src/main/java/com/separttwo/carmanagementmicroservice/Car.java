package com.separttwo.carmanagementmicroservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RedisHash("Car")
public class Car implements Serializable {
    @Id
    private String id;

    private String name;
    private int seats;
    private double price;
    private String transmission;
    private String image;
    private boolean isAvailable;

    public void setName(String name) {
        this.name = name;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public double getPrice() {
        return price;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getImage() {
        return image;
    }

    public boolean isAvailable() {
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
