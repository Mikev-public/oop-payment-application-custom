package converters;

import currencies.Currency;

public interface CurrencyConverter {
    public Currency convertCurrencyToEuro(double amount);
}

