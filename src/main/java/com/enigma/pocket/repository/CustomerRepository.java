package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllByFirstNameStartsWithAndEmailContainingAndBirthDateBetween(String firstName, String email, Date fromDate, Date toDate, Pageable pageable);
}
