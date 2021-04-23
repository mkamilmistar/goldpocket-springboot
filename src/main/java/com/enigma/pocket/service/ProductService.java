package com.enigma.crudProduct.service;

import com.enigma.crudProduct.dto.ProductSearchDto;
import com.enigma.crudProduct.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    public Product findProductById(String id);
    public Page<Product> findProducts(ProductSearchDto productSearchForm, Pageable pageable);
    public void createProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(String id);
}
