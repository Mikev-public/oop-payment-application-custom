package bank_account;

import converters.CurrencyConverter;
import currencies.Currency;

public class BankAccount {
    private final String owner;
    private Currency currency;

    // CURRENCIES WE SUPPORT
    // EURO
    // POUND
    // DOLLAR
    // ZLOTY
    // YEN

    // WORK ON IMPLEMENTING THE DEBIT/CREDITCARD features that we have gateways that use these
    // fields, also make creditcard optional
    private DebitCard debitCard;
    private CreditCard creditCard;

    public BankAccount(String owner, Currency currency) {
        this.owner = owner;
        this.currency = currency;
        this.debitCard = new DebitCard();
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

    public boolean deposit(double amount) {
        if (amount > 0) {
            double newAmount = currency.getAmount() + amount;
            currency.setAmount(newAmount);
            return true;
        } else {
            throw new InsufficientFundsException("Cannot deposit less than 0.01 EURO");
        }
    }

    public boolean depositForeignCurrency(double amount, CurrencyConverter converter) {
        amount = converter.convertCurrencyToEuro(amount).getAmount();
        if (amount > 0) {
            double newAmount = currency.getAmount() + amount;
            currency.setAmount(newAmount);
            return true;
        } else {
            throw new InsufficientFundsException("Cannot deposit less than 0.01 EURO");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= currency.getAmount()) {
            double newAmount = currency.getAmount() - amount;
            currency.setAmount(newAmount);
        } else {
            throw new InsufficientFundsException("Insufficient funds");
        }
    }

    public String bankAccountInfo() {
        return owner + " currently has " + currency.getAmount() + " " + currency.getName()
                + " In their wallet";
    }

    public void createCreditcard() {
        creditCard = new CreditCard();
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public boolean accountHasCreditCard() {
        return creditCard != null;
    }

}

