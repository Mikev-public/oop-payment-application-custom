package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bank_account.GiftCard;
import bank_account.InsufficientFundsException;

public class GiftCardTest {

    @Test
    void CreateGiftCardTest() {
        GiftCard giftCard = new GiftCard(400);
        assertNotNull(giftCard);
        assertInstanceOf(GiftCard.class, giftCard);
        assertEquals(400.0, giftCard.getAmount());
    }

    @Test
    void GiftCodeTest() {

    }

    @Test
    void PaymentTest() {
        GiftCard giftCard = new GiftCard(500);
        assertNotNull(giftCard);
        giftCard.payUsingGiftCard(300, giftCard.getGiftCode());
        assertEquals(giftCard.getAmount(), 200.0);
    }

    @Test
    void InsufficientFundsTest() {
        GiftCard giftCard = new GiftCard(500);
        assertNotNull(giftCard);
        assertThrows(InsufficientFundsException.class,
                () -> giftCard.payUsingGiftCard(600, giftCard.getGiftCode()),
                "There are not enough funds on the giftcard");
    }
}
