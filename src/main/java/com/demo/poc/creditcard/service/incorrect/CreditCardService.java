package com.demo.poc.creditcard.service.incorrect;

import com.demo.poc.creditcard.dto.CreditCardDTO;
import com.demo.poc.creditcard.repository.CreditCardRepository;

public class CreditCardService {

  private final CreditCardRepository creditCardRepository;

  public CreditCardService() {
    creditCardRepository = new CreditCardRepository();
  }

  public void createCreditCard(String customerId, long limit, double interestRate) {
    CreditCardDTO card = CreditCardDTO.builder()
        .customerId(customerId)
        .limit(limit)
        .interestRate(interestRate)
        .balance(0)
        .build();

    creditCardRepository.save(customerId, card);
  }

  public double calculateInterest(String customerId) {
    CreditCardDTO card = creditCardRepository.findById(customerId);

    if (card == null)
      throw new IllegalArgumentException("Credit card not found for customerId: " + customerId);

    return card.getBalance() * card.getInterestRate();
  }

  public void sendPaymentReminder(String customerId) {
    CreditCardDTO card = creditCardRepository.findById(customerId);

    if (card == null)
      throw new IllegalArgumentException("Credit card not found for customerId: " + customerId);

    if (card.getBalance() > 0)
      System.out.println("Reminder sent to customer " + customerId + " for balance: " + card.getBalance());
  }
}
