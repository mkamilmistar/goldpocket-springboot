package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Integer id){
        return customerService.findCustomerById(id);
    }

    @GetMapping("/customers")
    public List<Customer> findCustomers(){
        return customerService.findCustomers();
    }

    @PostMapping("/customer/create")
    public void createNewCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @PutMapping("/customer")
    public void editCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @PostMapping("/customer/{id}/delete")
    public void deleteCustomerById(@PathVariable(name = "id") Integer id){
        customerService.removeCustomer(id);
    }
}
