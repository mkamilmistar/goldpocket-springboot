package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHistoryPriceRepository extends JpaRepository<ProductHistoryPrice, String>, JpaSpecificationExecutor<ProductHistoryPrice> {
    public List<ProductHistoryPrice> findAllByProduct(Product product);
}
