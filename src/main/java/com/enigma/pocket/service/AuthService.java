package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.model.projection.LoginView;
import com.enigma.pocket.model.request.LoginRequest;

public interface AuthService {
  public LoginView loginService(LoginRequest loginRequest);
}
