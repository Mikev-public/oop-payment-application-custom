package currencies;

public class PoundCurrency extends Currency {

    public PoundCurrency(double amount) {
        this.setAmount(amount);
        setName("POUND");
    }
}
