package bank_account;

import java.util.Random;

public class GiftCard implements Card {
    private final int cardNumber;
    private final int giftCode;
    private double amount;

    public GiftCard(double amount) {
        Random random = new Random();

        // Generate random 6-digit card number (100000 to 999999) AI
        this.cardNumber = 100000 + random.nextInt(900000);

        // Generate random 4-digit PIN (1000 to 9999) AI
        this.giftCode = 1000 + random.nextInt(9000);

        // Sets the gift card balance
        this.amount = amount;
    }

    @Override
    public String getCardDetails() {
        return "Giftcard info : " + "cardNumber=" + cardNumber + ", giftCode=" + giftCode
                + " has a balance of: " + amount;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public boolean validateSecurityCode(int giftCode) {
        return this.giftCode == giftCode;
    }

    // Move to a giftcardgateway in future
    public GiftCard payUsingGiftCard(double amount, int giftCode) {
        if (this.amount < amount && this.validateSecurityCode(giftCode)) {
            throw new InsufficientFundsException("There are not enough funds on the giftcard");
        }
        this.amount = this.amount - amount;
        return this;
    }

    public int getGiftCode() {
        return this.giftCode;
    }

}
