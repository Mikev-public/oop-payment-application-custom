package bank_account;

public abstract class BankAccount {
    private final String owner;
    private Currency currency;

    // WORK ON IMPLEMENTING THE DEBIT/CREDITCARD features that we have gateways that use these fields, also make creditcard optional
    private DebitCard debitCard;
    private CreditCard creditCard;

    public BankAccount(String owner, Currency currency, DebitCard debitCard) {
        this.owner = owner;
        this.currency = currency;
        this.debitCard = debitCard;
    }

    public String getOwner() {
        return owner;
    }

    public String getCurrencyName() {
        return currency.getName();
    }

    public double getCurrencyAmount() {
        return currency.getAmount();
    }

    // public abstract void deposit(double value);
    public void deposit(double value) {
        if (value > 0) {
            double newAmount = currency.getAmount() + value;
            currency.setAmount(newAmount);
        }
    }

    // public abstract void withdraw(double value);
    public boolean withdraw(double value) {
        if (value > 0 && value <= currency.getAmount()) {
            double newAmount = currency.getAmount() - value;
            currency.setAmount(newAmount);
        }
        return false;
    }

    public String bankAccountInfo() {
        return owner + " currently has " + currency.getAmount() + " " + currency.getName()
                + " In their wallet";
    }

}
