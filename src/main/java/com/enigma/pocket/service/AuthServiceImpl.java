package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.model.projection.LoginView;
import com.enigma.pocket.model.request.LoginRequest;

import com.enigma.pocket.repository.CustomerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class AuthServiceImpl implements AuthService{

  private CustomerRepository customerRepository;

  public AuthServiceImpl (CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public LoginView loginService(LoginRequest loginRequest) {
    String token = generateUUIDString();

    Customer customer = login(loginRequest);

    LoginView response = LoginView.builder()
      .userId(customer.getId())
      .token(token)
      .username(customer.getUsername())
      .firstName(customer.getFirstName())
      .lastName(customer.getLastName())
      .password(customer.getPassword())
      .address(customer.getAddress())
      .birthDate(customer.getBirthDate())
      .email(customer.getEmail())
      .build();

    return response;
  }

  public static String generateUUIDString() {
    return UUID.randomUUID().toString();
  }


  private Customer login(LoginRequest request) {

    Customer loginCustomer = customerRepository.getLoginCustomer(request.getUsername(), request.getPassword());
    log.info("login user: {}", loginCustomer);

    return loginCustomer;
  }
}
