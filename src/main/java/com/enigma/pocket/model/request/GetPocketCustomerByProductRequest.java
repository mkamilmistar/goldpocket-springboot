package com.enigma.pocket.model.request;

import lombok.Data;

@Data
public class GetPocketCustomerByProductRequest {
  private String productId;
  private String customerId;
}
