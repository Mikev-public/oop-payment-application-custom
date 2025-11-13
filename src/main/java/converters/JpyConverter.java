package converters;

import currencies.YenCurrency;

public class JpyConverter implements CurrencyConverter {
    private final double conversionRateToEuro = 0.006;

    @Override
    public YenCurrency convertCurrencyToEuro(double amount) {
        Double convertedAmount = amount * conversionRateToEuro;
        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new YenCurrency(convertedAmount);
    }
}

