package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.repository.ProductRepository;
import com.enigma.pocket.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Service
public class ProductServiceDBImpl implements ProductService {

    private final String notFoundMessage = "Product with id: %s Not Found";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @Override
    public Product findProductById(String id) {
        validatePresent(id);
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public Page<Product> searchProducts(ProductSearchDto productSearchForm, Pageable pageable) {
        Specification<Product> specification = ProductSpecification.findProducts(productSearchForm);
        return productRepository.findAll(specification, pageable);
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedDate(new Date());
        return persistProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        validatePresent(product.getId());
        return persistProduct(product);
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

    private Product persistProduct(Product product) {
        product.setUpdatedDate(new Date());

        //Simpan Product
        Product savedProduct = productRepository.save(product);

        //Simpan History Product
        ProductHistoryPrice productHistoryPrice = new ProductHistoryPrice(savedProduct);
        productHistoryPriceService.logPrice(productHistoryPrice);

        return productRepository.save(product);
    }
}
