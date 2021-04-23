package com.enigma.pocket.service;


import com.enigma.pocket.dto.ProductHistoryPriceSearchDto;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductHistoryPriceService {
    public ProductHistoryPrice getHistoryProductById(String id);
    public Page<ProductHistoryPrice> findAllHistoryProduct(ProductHistoryPriceSearchDto historyProductSearchForm, Pageable pageable);
    public ProductHistoryPrice createNewHistoryProduct(ProductHistoryPrice historyProduct);
    public ProductHistoryPrice updateHistoryProduct(ProductHistoryPrice historyProduct);
    public void removeHistoryProductById(String id);

}
