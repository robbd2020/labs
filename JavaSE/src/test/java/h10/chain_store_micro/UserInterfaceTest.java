package h10.chain_store_micro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserInterfaceTest {
    UserInterface ui;
    GoldCard gc1;
    RegularCard rc1;
    GoldCard gc2;
    RegularCard rc2;

    @Before
    public void setup() {
        ui = new UserInterface();
        try {
            gc1 = new GoldCard(1, "Piet", 100d, 25);
            gc2 = new GoldCard(3, "Truus", 750d, 10);
        } catch (ArgumentOutOfRangeException e) {
            e.printStackTrace();
        }
        rc1 = new RegularCard(2, "Jan", 1000d);
        rc2 = new RegularCard(9, "Evelien", 15);

        try {
            ui.addClient(gc1);
            ui.addClient(rc1);
            ui.addClient(gc2);
            ui.addClient(rc2);
        } catch (CardIdIsNotUniqueException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenPaymentRequestedFromRegularCardWithEnoughBalanceItIsPerformed() throws IdNotPresentException {
        ui.newPayment(rc1.getCardId(), 100);
        assertEquals(900d, ui.findCustomerById(rc1.getCardId()).getCredit(), 0.1);
    }

    @Test
    public void whenPaymentRequestedFromRegularCardWithoutEnoughBalanceItsNotPerformed() throws IdNotPresentException {
        ui.newPayment(rc2.getCardId(), 100);
        assertEquals(15d, ui.findCustomerById(rc2.getCardId()).getCredit(), 0.1);
    }

    @Test
    public void whenPaymentRequestedFromGoldCardWithEnoughBalanceItIsPerformedWithDiscount() throws IdNotPresentException {
        ui.newPayment(gc1.getCardId(), 100);
        assertEquals(25d, ui.findCustomerById(gc1.getCardId()).getCredit(), 0.1);
    }

    @Test
    public void whenPaymentRequestedFromGoldCardWithoutEnoughBalanceItsPerformedAndBalanceIsNegative() throws IdNotPresentException {
        ui.newPayment(gc2.getCardId(), 1000);
        assertEquals(-150d, ui.findCustomerById(gc2.getCardId()).getCredit(), 0.1);
    }

    @Test(expected = IdNotPresentException.class)
    public void whenUnknownIdIsRequestedAnExceptionIsGiven() throws IdNotPresentException {
        ui.findCustomerById(8);
    }

    @Test
    public void whenANewClientIsAddedToUIItCanBeRetrieved() throws CardIdIsNotUniqueException {
        RegularCard newCard = new RegularCard(33, "Hannibal", 30);
        ui.addClient(newCard);
        assertTrue(ui.getCardMap().containsValue(newCard));
    }

    @Test(expected = ArgumentOutOfRangeException.class)
    public void whenANewGoldCardClientIsAddedWithZeroDiscountAnExceptionIsGiven() throws CardIdIsNotUniqueException, ArgumentOutOfRangeException {
        ui.addClient(new GoldCard(10, "Jannie", 10, 0));
    }

    @Test(expected = ArgumentOutOfRangeException.class)
    public void whenANewGoldCardClientIsAddedWithNegativeDiscountAnExceptionIsGiven() throws CardIdIsNotUniqueException, ArgumentOutOfRangeException {
        ui.addClient(new GoldCard(3, "Jannie", 10, -10));
    }

    @Test(expected = ArgumentOutOfRangeException.class)
    public void whenANewGoldCardClientIsAddedWithTooMuchDiscountAnExceptionIsGiven() throws CardIdIsNotUniqueException, ArgumentOutOfRangeException {
        ui.addClient(new GoldCard(3, "Jannie", 10, 33));
    }
}
