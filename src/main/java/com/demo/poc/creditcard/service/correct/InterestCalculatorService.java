package com.demo.poc.creditcard.service.correct;

import com.demo.poc.creditcard.dto.CreditCardDTO;
import com.demo.poc.creditcard.repository.CreditCardRepository;

public class InterestCalculatorService {

  private final CreditCardRepository creditCardRepository;

  public InterestCalculatorService() {
    creditCardRepository = new CreditCardRepository();
  }

  public double calculateInterest(String customerId) {
    CreditCardDTO card = creditCardRepository.findById(customerId);

    if (card == null)
      throw new IllegalArgumentException("Credit card not found for customerId: " + customerId);

    return card.getBalance() * card.getInterestRate();
  }
}
