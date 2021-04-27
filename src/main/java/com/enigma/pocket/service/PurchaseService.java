package com.enigma.pocket.service;

import com.enigma.pocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PurchaseService {

    public Purchase purchase(Purchase purchase, String customerId);
    public Purchase findPurchaseById(String id);
    public Page<Purchase> findAllPurchase(Pageable pageable);
}
