package converters;

import currencies.ZlotyCurrency;

public class PlnConverter implements CurrencyConverter {
    private final double conversionRateToEuro = 0.22;

    @Override
    public ZlotyCurrency convertCurrencyToEuro(double amount) {
        Double convertedAmount = amount * conversionRateToEuro;
        convertedAmount = Math.round(convertedAmount * 100.0) / 100.0;

        return new ZlotyCurrency(convertedAmount);
    }

}

