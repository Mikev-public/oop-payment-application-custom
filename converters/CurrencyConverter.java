package converters;

import bank_account.Currency;

public interface CurrencyConverter {
    public Currency convertCurrencyToEuro(double amount);
}
