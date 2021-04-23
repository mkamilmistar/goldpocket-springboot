package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocketController {

    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/{id}")
    public Pocket getPocketById(@PathVariable(name = "id") String id){
        return pocketService.getPocketById(id);
    }

    @GetMapping("/pockets")
    public Page<Pocket> getAllPocket(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                     @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return pocketService.findAllPocket(pageable);
    }

    @PostMapping("/pocket")
    public Pocket createPocket(@RequestBody Pocket pocket){
        return pocketService.createNewPocket(pocket);
    }

    @PutMapping("/pocket")
    public Pocket editPocket(@RequestBody Pocket pocket){
        return pocketService.editPocket(pocket);
    }

    @DeleteMapping("/pocket/{id}")
    public void deletePocketById(@PathVariable(name = "id") String id){
        pocketService.deletePocketById(id);
    }


}
