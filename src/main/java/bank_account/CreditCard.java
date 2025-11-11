package bank_account;

import java.util.Random;

public class CreditCard {
    private final int cardNumber;
    private final int cvv;

    public CreditCard() {
        Random random = new Random();

        // Generate random 6-digit card number (100000 to 999999) AI
        this.cardNumber = 100000 + random.nextInt(900000);

        // Generate random 3-digit CVV (100 to 999) AI
        this.cvv = 100 + random.nextInt(900);
    }

    public String creditCardDetails() {
        return "CreditCard info : " + "cardNumber=" + cardNumber + ", cvv=" + cvv;
    }

    public String getCardNumber() {
        return String.valueOf(cardNumber);
    }

    public boolean isCvvCorrect(int cvv) {
        return this.cvv == cvv;
    }
}

