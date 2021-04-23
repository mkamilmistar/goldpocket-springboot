package com.enigma.pocket.service;


import com.enigma.pocket.dto.ProductHistoryPriceSearchDto;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductHistoryPriceService {
    public ProductHistoryPrice getHistoryProductById(String id);
    public Page<ProductHistoryPrice> findAllLogPrice(ProductHistoryPriceSearchDto historyProductSearchForm, Pageable pageable);
    public ProductHistoryPrice logPrice(ProductHistoryPrice historyProduct);
    public ProductHistoryPrice updateLogPrice(ProductHistoryPrice historyProduct);
    public void removeLogPriceById(String id);

}
