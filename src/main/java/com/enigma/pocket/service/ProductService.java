package com.enigma.pocket.service;


import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    public Product findProductById(String id);
    public Page<Product> searchProducts(ProductSearchDto productSearchForm, Pageable pageable);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(String id);
    public Product findProductByName(String productName);
}
