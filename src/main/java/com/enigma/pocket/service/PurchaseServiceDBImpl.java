package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.entity.PurchaseDetail;
import com.enigma.pocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceDBImpl implements PurchaseService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @Override
    public Purchase purchase(Purchase purchase, String customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date());

        for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()){
            Pocket pocket = pocketService.getPocketById(purchaseDetail.getPocket().getId());
            pocketService.topUp(pocket, purchaseDetail.getQuantityInGram());
            purchaseDetail.setProduct(pocket.getProduct());
            purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
            purchaseDetail.setPurchase(purchase);
        }

        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public List<Purchase> findAllPurchase() {
        return purchaseRepository.findAll();
    }
}

