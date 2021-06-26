package com.enigma.pocket.model.response;

import lombok.Data;

@Data
public class LoginDataResponse {
  private String tokenUser;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
}
