package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer findCustomerById(Integer id);
    public List<Customer> findCustomers(String firstName, String email);
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
