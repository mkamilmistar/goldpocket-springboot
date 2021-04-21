package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer findCustomerById(Integer id);
    public List<Customer> findCustomers();
    public void createCustomer(Customer customer);
    public void updateCustomer(Integer id, Customer customer);
    public void removeCustomer(Integer id);
}
