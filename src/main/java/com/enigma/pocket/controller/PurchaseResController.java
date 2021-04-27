package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseResController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/purchase")
    public Purchase purchase(@RequestParam(name = "customerId") String customerId,
                             @RequestBody Purchase purchase){

        return purchaseService.purchase(purchase, customerId);
    }

    @GetMapping("/purchase/{id}")
    public Purchase findPurchaseById(@PathVariable(name = "id") String id){
        return purchaseService.findPurchaseById(id);
    }

    @GetMapping("/purchases")
    public List<Purchase> searchPurchases(){
        return purchaseService.findAllPurchase();
    }
}
