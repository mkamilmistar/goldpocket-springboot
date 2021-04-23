package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductHistoryPriceSearchDto;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.repository.ProductHistoryPriceRepository;
import com.enigma.pocket.specification.ProductHistoryPriceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductHistoryPriceServiceDBImpl implements ProductHistoryPriceService {

    private final String notFoundMessage = "History Product with id: %s Not Found";

    @Autowired
    ProductHistoryPriceRepository productHistoryPriceRepository;

    @Autowired
    ProductService productService;

    @Override
    public ProductHistoryPrice getHistoryProductById(String id) {
        validatePresent(id);
        ProductHistoryPrice historyProduct = productHistoryPriceRepository.findById(id).get();
        return historyProduct;
    }

    @Override
    public Page<ProductHistoryPrice> findAllLogPrice(ProductHistoryPriceSearchDto historyProductSearchForm, Pageable pageable) {
        Specification<ProductHistoryPrice> specification = ProductHistoryPriceSpecification.findHistoryProducts(historyProductSearchForm);
        return productHistoryPriceRepository.findAll(specification, pageable);
    }

    @Override
    public List<ProductHistoryPrice> findAllByProduct(String productId) {
        Product product = productService.findProductById(productId);
        return product.getHistoryPrices();
    }

    @Override
    public ProductHistoryPrice logPrice(ProductHistoryPrice historyProduct) {
        return productHistoryPriceRepository.save(historyProduct);
    }

    @Override
    public ProductHistoryPrice updateLogPrice(ProductHistoryPrice historyProduct) {
        validatePresent(historyProduct.getId());
        return productHistoryPriceRepository.save(historyProduct);
    }

    @Override
    public void removeLogPriceById(String id) {
        validatePresent(id);
        productHistoryPriceRepository.deleteById(id);
    }

    private void validatePresent(String id) {
        if(!productHistoryPriceRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
