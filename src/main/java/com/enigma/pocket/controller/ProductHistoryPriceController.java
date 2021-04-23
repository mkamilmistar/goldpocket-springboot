package com.enigma.crudProduct.controller;

import com.enigma.crudProduct.dto.HistoryProductSearchDto;
import com.enigma.crudProduct.entity.HistoryProduct;
import com.enigma.crudProduct.service.HistoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryProductResController {

    @Autowired
    HistoryProductService historyProductService;

    @GetMapping("/history-product/{id}")
    public HistoryProduct getHistoryProductById(@PathVariable(name = "id") String id){
        return historyProductService.getHistoryProductById(id);
    }

    @GetMapping("/history-products")
    public Page<HistoryProduct> findAllHistoryProduct(@RequestBody HistoryProductSearchDto historyProductSearchForm,
                                                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "size", defaultValue = "10") Integer size){

        Pageable pageable = PageRequest.of(page,size);
        return historyProductService.findAllHistoryProduct(historyProductSearchForm, pageable);
    }

    @PostMapping("/history-product/create")
    public HistoryProduct createNewHistoryProduct(@RequestBody HistoryProduct historyProduct){
        return historyProductService.createNewHistoryProduct(historyProduct);
    }

    @PutMapping("/history-product")
    public HistoryProduct updateHistoryProduct(@RequestBody HistoryProduct historyProduct){
        return historyProductService.updateHistoryProduct(historyProduct);
    }

    @DeleteMapping("history-product/{id}/delete")
    public void removeHistoryProductById(@PathVariable(name = "id") String id){
        historyProductService.removeHistoryProductById(id);
    }
}
