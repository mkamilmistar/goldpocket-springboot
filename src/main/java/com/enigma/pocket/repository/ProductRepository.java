package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {

    @Query(value = "SELECT * FROM m_products", nativeQuery = true)
    Page<Product> searchProduct(Specification specification, Pageable pageable);

    @Query(value = "SELECT * FROM m_products as pr WHERE pr.id = ?1", nativeQuery = true)
    Product getProductById(String productId);

    @Query(value = "DELETE FROM m_products as pr WHERE pr.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteProductById(String productId);

    Product findProductByProductName(String productName);
}
