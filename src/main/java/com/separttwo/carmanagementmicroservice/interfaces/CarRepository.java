package com.separttwo.carmanagementmicroservice.interfaces;

import com.separttwo.carmanagementmicroservice.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, String> {
}
