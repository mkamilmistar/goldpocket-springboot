package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Purchase> searchPurchases(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                          @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return purchaseService.findAllPurchase(pageable);
    }
}
