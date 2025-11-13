package bank_account;

import java.util.Random;

public class DebitCard implements Card {
    private final int cardNumber;
    private final int pinCode;

    public DebitCard() {
        Random random = new Random();

        // Generate random 6-digit card number (100000 to 999999) AI
        this.cardNumber = 100000 + random.nextInt(900000);

        // Generate random 4-digit PIN (1000 to 9999) AI
        this.pinCode = 1000 + random.nextInt(9000);

    }

    public String getCardDetails() {
        return "CreditCard info : " + "cardNumber=" + cardNumber + ", pinCode=" + pinCode;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public boolean validateSecurityCode(int pinCode) {
        return this.pinCode == pinCode;
    }
}

