package com.enigma.pocket.model.projection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginView {

  private String token;
  private String userId;
  private String username;
  private String password;
  private String firstName;
  private String lastName;
}
