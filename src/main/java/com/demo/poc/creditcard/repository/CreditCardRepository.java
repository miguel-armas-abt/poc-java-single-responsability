package com.demo.poc.creditcard.repository;

import com.demo.poc.creditcard.dto.CreditCardDTO;
import java.util.HashMap;
import java.util.Map;

public class CreditCardRepository {

  private static final Map<String, CreditCardDTO> dataSource = new HashMap<>();

  static {
    dataSource.put("7654321", CreditCardDTO.builder().customerId("7654321").limit(10000).balance(3500).interestRate(0.02).build());
    dataSource.put("7654322", CreditCardDTO.builder().customerId("7654322").limit(5000).balance(1500).interestRate(0.01).build());
    dataSource.put("7654323", CreditCardDTO.builder().customerId("7654323").limit(15000).balance(2500).interestRate(0.03).build());
  }

  public CreditCardDTO findById(String customerId) {
    return dataSource.get(customerId);
  }

  public void save(String customerId, CreditCardDTO card) {
    dataSource.put(customerId, card);
  }
}
