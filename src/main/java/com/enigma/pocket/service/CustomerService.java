package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface CustomerService {
    public Customer findCustomerById(Integer id);
//    public List<Customer> findCustomers(String firstName, String email, Date fromDate, Date toDate, Pageable pageable);
    public Page<Customer> findCustomers(Customer customerSearchForm, Pageable pageable);
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
