package com.demo.poc.creditcard.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardDTO {

  private String customerId;
  private double limit;
  private double balance;
  private double interestRate;
}