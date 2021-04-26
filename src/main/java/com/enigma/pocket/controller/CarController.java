package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Car;
import com.enigma.pocket.entity.Engine;
import com.enigma.pocket.format.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/coba")
    public ResponseEntity<ResponseMessage> getCar(){
        Engine engine = new Engine("Toyota", 15000);
        Car car = new Car("kucing", "mantap", engine);
        return ResponseEntity.accepted().body(ResponseMessage.acceptedResponse(car));
    }
}
