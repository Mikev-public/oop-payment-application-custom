package converters;

import currencies.PoundCurrency;

public class GbpConverter implements CurrencyConverter {
    private final double conversionRateToEuro = 1.15;

    @Override
    public PoundCurrency convertCurrencyToEuro(double amount) {
        Double convertedAmount = amount * conversionRateToEuro;
        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new PoundCurrency(convertedAmount);
    }

}

