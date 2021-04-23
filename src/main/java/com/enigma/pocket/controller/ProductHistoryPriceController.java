package com.enigma.pocket.controller;

import com.enigma.pocket.dto.ProductHistoryPriceSearchDto;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.service.ProductHistoryPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductHistoryPriceController {

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @GetMapping("/history-product/{id}")
    public ProductHistoryPrice getHistoryProductById(@PathVariable(name = "id") String id){
        return productHistoryPriceService.getHistoryProductById(id);
    }

    @GetMapping("/history-products")
    public Page<ProductHistoryPrice> findAllHistoryProduct(@RequestBody ProductHistoryPriceSearchDto historyProductSearchForm,
                                                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "size", defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page,size);
        return productHistoryPriceService.findAllPrice(historyProductSearchForm, pageable);
    }

    @PostMapping("/history-product/create")
    public ProductHistoryPrice createNewHistoryProduct(@RequestBody ProductHistoryPrice historyProduct){
        return productHistoryPriceService.createLogPrice(historyProduct);
    }

    @PutMapping("/history-product")
    public ProductHistoryPrice updateHistoryProduct(@RequestBody ProductHistoryPrice historyProduct){
        return productHistoryPriceService.updateHistoryProduct(historyProduct);
    }

    @DeleteMapping("history-product/{id}/delete")
    public void removeHistoryProductById(@PathVariable(name = "id") String id){
        productHistoryPriceService.removeHistoryProductById(id);
    }
}
