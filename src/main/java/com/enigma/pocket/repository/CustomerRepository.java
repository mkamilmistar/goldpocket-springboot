package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findAllByFirstNameStartsWithOrEmailContaining(String firstName, String email);
}
