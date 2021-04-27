package com.enigma.pocket.controller;

import com.enigma.pocket.dto.Car;
import com.enigma.pocket.dto.Engine;
import com.enigma.pocket.format.WrapperMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @GetMapping("/coba")
    public ResponseEntity<WrapperMessage> getCar(){
        Engine engine = new Engine("Toyota", 15000);
        Car car = new Car("kucing", "mantap", engine);
        return ResponseEntity.accepted().body(WrapperMessage.acceptedResponse(car));
    }
}
