package com.enigma.pocket.repository;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.model.request.LoginRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {

    @Query(value = "SELECT * FROM m_customers", nativeQuery = true)
    Page<Customer> getAllCustomer(Specification specification, Pageable pageable);

    @Query(value = "SELECT * FROM m_customers as c WHERE c.id = ?1", nativeQuery = true)
    Customer getCustomerById(String customerId);

    @Query(value = "DELETE FROM m_customers as c WHERE c.id = ?1", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteCustomerById(String customerId);

    @Query(value = "SELECT * FROM m_customers as c WHERE c.username = :username AND c.password = :password", nativeQuery = true)
    Customer getLoginCustomer(String username, String password);

//    @Query(value = "INSERT INTO m_customers VALUES(:customer.first_name, :customer.last_name, :customer.birthdate)", nativeQuery = true)
//    Customer createCustomerNative(Customer customer);

}
