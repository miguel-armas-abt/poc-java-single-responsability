package com.demo.poc.creditcard.service.correct;

import com.demo.poc.creditcard.dto.CreditCardDTO;
import com.demo.poc.creditcard.repository.CreditCardRepository;

public class CreditCardCreatorService {

  private final CreditCardRepository creditCardRepository;

  public CreditCardCreatorService() {
    creditCardRepository = new CreditCardRepository();
  }

  public void createCreditCard(String customerId, double limit, double interestRate) {
    CreditCardDTO creditCard = CreditCardDTO.builder()
        .customerId(customerId)
        .limit(limit)
        .interestRate(interestRate)
        .balance(0)
        .build();
    creditCardRepository.save(customerId, creditCard);
  }
}
