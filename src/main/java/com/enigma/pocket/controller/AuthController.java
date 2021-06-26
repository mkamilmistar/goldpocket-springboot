package com.enigma.pocket.controller;

import com.enigma.pocket.model.projection.LoginView;
import com.enigma.pocket.model.request.LoginRequest;
import com.enigma.pocket.service.AuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping(value = "/login")
  public LoginView loginUser(@RequestBody LoginRequest request) {
    LoginView loginResponse = authService.loginService(request);
    return loginResponse;
  }

}
