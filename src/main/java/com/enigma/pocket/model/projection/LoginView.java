package com.enigma.pocket.model.projection;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
public class LoginView {

  private String token;
  private String userId;
  private String firstName;
  private String lastName;
  private Date birthDate;
  private String address;
  private Integer status;
  private String username;
  private String password;
  private String email;
}
