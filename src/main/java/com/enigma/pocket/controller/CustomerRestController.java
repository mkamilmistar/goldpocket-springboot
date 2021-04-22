package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<Customer> findCustomers(@RequestParam(name = "firstName", defaultValue = "") String firstName,
                                        @RequestParam(name = "email", defaultValue = "") String email,
                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "size", defaultValue = "10") Integer size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return customerService.findCustomers(firstName, email, pageable);
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
