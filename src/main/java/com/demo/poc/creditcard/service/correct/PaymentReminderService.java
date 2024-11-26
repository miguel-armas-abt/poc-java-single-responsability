package com.demo.poc.creditcard.service.correct;

import com.demo.poc.creditcard.dto.CreditCardDTO;
import com.demo.poc.creditcard.repository.CreditCardRepository;

public class PaymentReminderService {

  private final CreditCardRepository creditCardRepository;

  public PaymentReminderService() {
    creditCardRepository = new CreditCardRepository();
  }

  public void sendPaymentReminder(String customerId) {
    CreditCardDTO card = creditCardRepository.findById(customerId);

    if (card == null)
      throw new IllegalArgumentException("Credit card not found for customerId: " + customerId);

    if (card.getBalance() > 0)
      System.out.println("Reminder sent to customer " + customerId + " for balance: " + card.getBalance());
  }
}
