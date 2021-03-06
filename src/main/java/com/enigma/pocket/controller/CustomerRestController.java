package com.enigma.pocket.controller;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    public Page<Customer> findCustomers(@RequestBody CustomerSearchDto customerSearchForm,
                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "size", defaultValue = "10") Integer size
                                       )
    {
        Pageable pageable = PageRequest.of(page, size);
        return customerService.findCustomers(customerSearchForm, pageable);
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
