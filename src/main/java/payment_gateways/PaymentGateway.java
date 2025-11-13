package payment_gateways;

import bank_account.BankAccount;
import converters.CurrencyConverter;
import converters.GbpConverter;
import converters.JpyConverter;
import converters.PlnConverter;
import converters.UsdConverter;

public abstract class PaymentGateway {
    // We implementeren alleen betaling die ons bedrijf binnen komen op het moment anders hadden we
    // ook wel een outgoingfunds gemaakt
    public abstract void ExecutePayment(BankAccount companyBankAccount,
            BankAccount customerBankAccount, int securityCode, double amount);

    // naam van de 2 methodes hieronder aangepast zodat we in de toekomst nog outgoing zouden kunnen
    // gebruiken
    public abstract void transferIncomingEuroFunds(BankAccount companyBankAccount,
            BankAccount customerBankAccount, double amount);

    public abstract void transferIncomingNonEuroFunds(BankAccount companyBankAccount,
            BankAccount customerBankAccount, double amount, CurrencyConverter converter);

    // CURRENCIES WE SUPPORT
    // EURO
    // POUND
    // DOLLAR
    // ZLOTY
    // YEN
    public CurrencyConverter collectCorrectCurrencyConverter(BankAccount customerBankAccount) {
        // Geen mooie/shaalbare oplossing maar kon geen manier bedenken om polimorphisme te
        // gebruiken denk dat het wel zou gaan
        // als we gebruik hadden gemaakt met een ENUM voor de currecies in te doen, dan zou ik
        // namelijk de ENUM values kunnen benutten hiervoor.
        if (customerBankAccount.getCurrencyName() == "EURO") {
            return null;
        } else if (customerBankAccount.getCurrencyName() == "POUND") {
            return new GbpConverter();
        } else if (customerBankAccount.getCurrencyName() == "DOLLAR") {
            return new UsdConverter();
        } else if (customerBankAccount.getCurrencyName() == "ZLOTY") {
            return new PlnConverter();
        } else if (customerBankAccount.getCurrencyName() == "YEN") {
            return new JpyConverter();
        }
        return null;
    }
}

