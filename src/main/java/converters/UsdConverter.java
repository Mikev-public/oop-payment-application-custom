package converters;

import currencies.DollarCurrency;

public class UsdConverter implements CurrencyConverter {
    private final double conversionRateToEuro = 0.9;

    @Override
    public DollarCurrency convertCurrencyToEuro(double amount) {
        Double convertedAmount = amount * conversionRateToEuro;
        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new DollarCurrency(convertedAmount);
    }

}

