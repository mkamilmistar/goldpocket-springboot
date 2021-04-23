package com.enigma.crudProduct.service;

import com.enigma.crudProduct.dto.ProductSearchDto;
import com.enigma.crudProduct.entity.Product;
import com.enigma.crudProduct.repository.ProductRepository;
import com.enigma.crudProduct.specification.ProductSpecification;
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
public class ProductServiceDBImpl implements ProductService{

    private final String notFoundMessage = "Product with id: %s Not Found";

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product findProductById(String id) {
        validatePresent(id);
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public Page<Product> findProducts(ProductSearchDto productSearchForm, Pageable pageable) {
        Specification<Product> specification = ProductSpecification.findProducts(productSearchForm);
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public void createProduct(Product product) {
        product.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        validatePresent(product.getId());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        validatePresent(id);
        productRepository.deleteById(id);
    }

    private void validatePresent(String id) {
        if(!productRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }
}
