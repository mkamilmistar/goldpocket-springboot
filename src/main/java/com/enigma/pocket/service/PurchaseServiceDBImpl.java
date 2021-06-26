package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.entity.PurchaseDetail;
import com.enigma.pocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
            pocketService.topUp(pocket, purchaseDetail.getQuantityInGram(), purchase.getPurchaseType());
            purchaseDetail.setProduct(pocket.getProduct());
            if(purchase.getPurchaseType() == 0){
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
            }else{
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceBuy());
            }
            purchaseDetail.setPurchase(purchase);
        }

        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findPurchaseById(String id) {
//        return purchaseRepository.findById(id).get();
        return purchaseRepository.getPurchaseById(id);
    }

    @Override
    public Page<Purchase> findAllPurchase(Pageable pageable) {
//        return purchaseRepository.findAll(pageable);
        return purchaseRepository.getAllPurchase(pageable);
    }
}

