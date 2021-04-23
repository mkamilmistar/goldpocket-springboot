package com.enigma.crudProduct.controller;

import com.enigma.crudProduct.dto.ProductSearchDto;
import com.enigma.crudProduct.entity.Product;
import com.enigma.crudProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductResController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id){
        return productService.findProductById(id);
    }

    @GetMapping("/products")
    public Page<Product> getAllProduct(@RequestBody ProductSearchDto productSearchForm,
                                       @RequestParam(name = "page", defaultValue = "0") Integer page,
                                       @RequestParam(name = "size", defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productService.findProducts(productSearchForm, pageable);
    }

    @PostMapping("/product/create")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @PutMapping("/product")
    public void editProductById(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}/delete")
    public void deleteProductById(@PathVariable(name = "id") String id){
        productService.deleteProduct(id);
    }
}
