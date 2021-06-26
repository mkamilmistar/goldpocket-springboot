package com.enigma.pocket.model.response;

import lombok.Data;

@Data
public class LoginResponse {

  private String tokenUser;
  private String username;
  private String password;
  private String firstName;
  private String lastName;

}
