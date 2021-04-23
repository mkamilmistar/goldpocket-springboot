package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Car;
import com.enigma.pocket.entity.Engine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/coba")
    public Car getCar(){
        Engine engine = new Engine("Toyota", 15000);
        Car car = new Car("kucing", "mantap", engine);
        return car;
    }
}
