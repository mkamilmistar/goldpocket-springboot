package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Product;
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
public interface PocketRepository extends JpaRepository<Pocket, String>, JpaSpecificationExecutor {

    @Query(value = "SELECT * FROM m_pockets", nativeQuery = true)
    Page<Pocket> getAllPocket(Pageable pageable);

    @Query(value = "SELECT * FROM m_pockets as p WHERE p.id = ?1", nativeQuery = true)
    Pocket getPocketById(String pocketId);

    @Query(value = "DELETE FROM m_pockets as p WHERE p.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deletePocketById(String pocketId);

    @Query(value = "SELECT * FROM m_pockets as p " +
      "where p.customer_id=:customerId AND p.product_id=:productId",
      nativeQuery = true)
    List<Pocket> findPocketCustomerByProduct(String customerId, String productId);
}
