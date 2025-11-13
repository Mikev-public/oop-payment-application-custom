package currencies;

public class DollarCurrency extends Currency {

    public DollarCurrency(double amount) {
        this.setAmount(amount);
        setName("DOLLAR");
    }
}
