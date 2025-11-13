package payment_gateways;

import bank_account.BankAccount;
import converters.CurrencyConverter;

public class DebitCardGateway extends PaymentGateway {

    @Override
    public void ExecutePayment(BankAccount companyBankAccount, BankAccount customerBankAccount,
            int securityCode, double amount) {
        if (customerSecurityCodeInputSimulator(customerBankAccount, securityCode)) {
            if (customerBankAccount.getCurrencyName() != "EURO") {
                CurrencyConverter converter = collectCorrectCurrencyConverter(customerBankAccount);
                transferIncomingNonEuroFunds(companyBankAccount, customerBankAccount, amount,
                        converter);
            } else {
                transferIncomingEuroFunds(companyBankAccount, customerBankAccount, amount);
            }
        }
    }

    public boolean customerSecurityCodeInputSimulator(BankAccount customerBankAccount,
            int securityCode) {
        if (customerBankAccount.getDebitCard().validateSecurityCode(securityCode)) {
            return true;
        } else {
            throw new SecurityException("Invalid cvv code");
        }
    }

    @Override
    public void transferIncomingEuroFunds(BankAccount companyBankAccount,
            BankAccount customerBankAccount, double amount) {
        customerBankAccount.withdraw(amount);
        companyBankAccount.deposit(amount);
    }

    @Override
    public void transferIncomingNonEuroFunds(BankAccount companyBankAccount,
            BankAccount customerBankAccount, double amount, CurrencyConverter converter) {
        customerBankAccount.withdraw(amount);
        companyBankAccount.depositForeignCurrency(amount, converter);
    }

}
