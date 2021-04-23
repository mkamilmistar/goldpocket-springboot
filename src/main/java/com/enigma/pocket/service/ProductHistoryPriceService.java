package com.enigma.pocket.service;


import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryProductService {
    public ProductHistoryPrice getHistoryProductById(String id);
    public Page<ProductHistoryPrice> findAllHistoryProduct(ProductHistoryPrice historyProductSearchForm, Pageable pageable);
    public ProductHistoryPrice createNewHistoryProduct(ProductHistoryPrice historyProduct);
    public ProductHistoryPrice updateHistoryProduct(ProductHistoryPrice historyProduct);
    public void removeHistoryProductById(String id);

}
