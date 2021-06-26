package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, String> {

    @Query(value = "SELECT * FROM t_purchases", nativeQuery = true)
    Page<Purchase> getAllPurchase(Pageable pageable);

    @Query(value = "SELECT * FROM t_purchases as pur WHERE pur.id = ?1", nativeQuery = true)
    Purchase getPurchaseById(String purchaseId);

    @Query(value = "DELETE FROM t_purchases as pur WHERE pur.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deletePurchaseById(String purchaseId);
}
