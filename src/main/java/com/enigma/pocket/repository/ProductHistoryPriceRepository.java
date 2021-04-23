package com.enigma.crudProduct.repository;

import com.enigma.crudProduct.entity.HistoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryProductRepository extends JpaRepository<HistoryProduct, String>, JpaSpecificationExecutor<HistoryProduct> {
}
