package com.demo.poc;

import com.demo.poc.creditcard.service.correct.CreditCardCreatorService;
import com.demo.poc.creditcard.service.correct.InterestCalculatorService;
import com.demo.poc.creditcard.service.correct.PaymentReminderService;
import com.demo.poc.creditcard.service.incorrect.CreditCardService;

public class Main {

  public static void main(String[] args) {

    /**
     * Una sola clase gestiona creación, cálculo de intereses y recordatorios, violando SRP.
     */
    CreditCardService service = new CreditCardService();
    service.calculateInterest("7654321");
    service.sendPaymentReminder("7654321");
    service.createCreditCard("7654324", 30000, 0.4);

    /**
     * Las responsabilidades están separadas en clases diferentes: creación de tarjetas, cálculo de intereses y recordatorios,
     * lo que mejora la mantenibilidad y claridad.
     */
    InterestCalculatorService interestCalculatorService = new InterestCalculatorService();
    interestCalculatorService.calculateInterest("7654324");

    PaymentReminderService paymentReminderService = new PaymentReminderService();
    paymentReminderService.sendPaymentReminder("7654324");

    CreditCardCreatorService creditCardCreatorService = new CreditCardCreatorService();
    creditCardCreatorService.createCreditCard("7654324", 30000, 0.4);
  }
}