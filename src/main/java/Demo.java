import bank_account.Currency;
import bank_account.BankAccount;
import converters.GbpConverter;
import converters.JpyConverter;
import converters.PlnConverter;
import converters.UsdConverter;

public class Demo {
    private UsdConverter usdConverter = new UsdConverter();
    private GbpConverter gbpConverter = new GbpConverter();
    private JpyConverter jpyConverter = new JpyConverter();
    private PlnConverter plnConverter = new PlnConverter();

    public static void main(String[] args) {
        // initiate testing methode
        System.out.println("dingen aant testen");

        // mijn custom setup
        // BankAccount walletEur = new BankAccount("Jeroen de Vries", new Currency("EURO", 500));
        // BankAccount walletUsd = new BankAccount("John Smith", new Currency("USD", 500));
        // BankAccount walletGbp = new BankAccount("Oliver Brown", new Currency("GBP", 500));
        // BankAccount walletJpy = new BankAccount("Haruto Tanaka", new Currency("YEN", 500));
        // BankAccount walletPln = new BankAccount("Piotr Nowak", new Currency("ZLOTY", 500));


        // System.out.println(123 == 124);



        // System.out.println(walletEur.walletInfo());
    }

}

