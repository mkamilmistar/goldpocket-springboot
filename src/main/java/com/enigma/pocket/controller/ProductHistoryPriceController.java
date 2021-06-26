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
@RequestMapping("/v1")
public class ProductHistoryPriceController {

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @GetMapping("/historyProduct/{id}")
    public ProductHistoryPrice getHistoryProductById(@PathVariable(name = "id") String id){
        return productHistoryPriceService.getHistoryProductById(id);
    }

    @GetMapping("/historyProducts")
    public Page<ProductHistoryPrice> findAllHistoryProduct(@RequestBody ProductHistoryPriceSearchDto historyProductSearchForm,
                                                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "size", defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page,size);
        return productHistoryPriceService.findAllLogPrice(historyProductSearchForm, pageable);
    }

    @PostMapping("/historyProduct")
    public ProductHistoryPrice createNewHistoryProduct(@RequestBody ProductHistoryPrice historyProduct){
        return productHistoryPriceService.logPrice(historyProduct);
    }

    @PutMapping("/historyProduct")
    public ProductHistoryPrice updateHistoryProduct(@RequestBody ProductHistoryPrice historyProduct){
        return productHistoryPriceService.updateLogPrice(historyProduct);
    }

    @DeleteMapping("historyProduct/{id}")
    public void removeHistoryProductById(@PathVariable(name = "id") String id){
        productHistoryPriceService.removeLogPriceById(id);
    }
}
