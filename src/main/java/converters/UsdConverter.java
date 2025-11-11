package converters;

import bank_account.Currency;

public class UsdConverter implements CurrencyConverter {
    private final double conversionRateToEuro = 0.9;

    @Override
    public Currency convertCurrencyToEuro(double amount) {
        Double convertedAmount = amount * conversionRateToEuro;
        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new Currency("EURO", convertedAmount);
    }

}

