package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Pocket;
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
public interface ProductHistoryPriceRepository extends JpaRepository<ProductHistoryPrice, String>, JpaSpecificationExecutor<ProductHistoryPrice> {
    public List<ProductHistoryPrice> findAllByProduct(Product product);

    @Query(value = "SELECT * FROM m_history_prices", nativeQuery = true)
    Page<ProductHistoryPrice> getAllHistory(Specification specification, Pageable pageable);

    @Query(value = "SELECT * FROM m_history_prices as hp WHERE hp.id = ?1", nativeQuery = true)
    ProductHistoryPrice getHistoryById(String historyId);

    @Query(value = "DELETE FROM m_history_prices as hp WHERE hp.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteHistoryById(String historyId);
}
