package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import bank_account.BankAccount;
import bank_account.Currency;
import bank_account.CreditCard;
import bank_account.DebitCard;

class BankAccountTest {

    @Test
    void CreateBankAccountTest() {
        // setup
        Currency currency = new Currency("EURO", 1500);

        // result
        BankAccount result = new BankAccount("Mike", currency);

        // validation
        // validate that the bank account was made
        assertNotNull(result);
        assertEquals("Mike" + " currently has " + 1500.0 + " " + "EURO" + " In their wallet",
                result.bankAccountInfo());
        assertNotNull(result.getDebitCard());
        assertInstanceOf(DebitCard.class, result.getDebitCard());

        // Create and validate creditcard creation
        assertNull(result.getCreditCard());
        result.createCreditcard();
        assertNotNull(result.getCreditCard());
        assertInstanceOf(CreditCard.class, result.getCreditCard());
    }

    

}

