package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocketController {

    @Autowired
    PocketService pocketService;

    @PostMapping("/pocket")
    public Pocket createPocket(@RequestBody Pocket pocket){
        return pocketService.createNewPocket(pocket);
    }
}
