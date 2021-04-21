package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceDBImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Integer id, Customer customer) {
        Customer customerToUpdate = customerRepository.getOne(id);
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setBirthDate(customer.getBirthDate());
        customerToUpdate.setAddress(customer.getAddress());
        customerToUpdate.setStatus(customer.getStatus());
        customerToUpdate.setUsername(customer.getUsername());
        customerToUpdate.setPassword(customer.getPassword());
        customerToUpdate.setEmail(customer.getEmail());
        customerRepository.save(customerToUpdate);
    }

    @Override
    public void removeCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
