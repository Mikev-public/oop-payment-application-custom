package bank_account;

public interface Card {
    public abstract String getCardDetails();
    public abstract boolean validateSecurityCode(int cvv);
}

