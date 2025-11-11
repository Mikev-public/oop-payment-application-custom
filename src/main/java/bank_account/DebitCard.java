package bank_account;

import java.util.Random;

public class DebitCard {
    private final int cardNumber;
    private final int pinCode;

    public DebitCard() {
        Random random = new Random();

        // Generate random 6-digit card number (100000 to 999999) AI
        this.cardNumber = 100000 + random.nextInt(900000);

        // Generate random 4-digit PIN (1000 to 9999) AI
        this.pinCode = 1000 + random.nextInt(9000);

    }

    public String debitCardDetails() {
        return "CreditCard info : " + "cardNumber=" + cardNumber + ", pinCode=" + pinCode;
    }

    public String getCardNumber() {
        return String.valueOf(cardNumber);
    }

    public Boolean isPinCodeCorrect(int pinCode) {
        return this.pinCode == pinCode;
    }
}

