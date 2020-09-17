package h7.banking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    Bank abn;
    BankAccount piet;
    BankAccount sarah;
    BankAccount guus;
    BankAccount moniek;

    @Before
    public void init() {
        abn = new Bank();
        piet = abn.openNewAccount();
        sarah = abn.openNewAccount();
        guus = abn.openNewAccount();
        moniek = abn.openNewAccount();

        piet.deposit(33.33);
        sarah.deposit(999.21);
        guus.deposit(1_000_000);
    }

    @Test
    public void getTotalBankBalance() {
        assertEquals(33.33 + 999.21 + 1_000_000, abn.getTotalBankBalance(), .1);
    }

    @Test
    public void whenMoreMoneyThanBalanceIsWithdrawn() {
        assertEquals(0d, piet.performWithdraw(35), .1);
    }

    @Test
    public void whenMoneyIsTransferredItIsWithdrawnCorrectly() {
        abn.transferMoney(2, 1, 100d);
        assertEquals(piet.getBalance(), 133.33, 0.1);
    }

    @Test
    public void whenMoneyIsTransferredItIsDepositedCorrectly() {
        abn.transferMoney(2, 1, 100d);
        assertEquals(sarah.getBalance(), 899.21, 0.1);
    }

    @Test
    public void whenMoreThanAvailableMoneyIsTransferredNothingWithdrawnOrDeposited() {
        abn.transferMoney(2, 3, 1000d);
        assertEquals(1_000_000, guus.getBalance(), .1);
        assertEquals(999.21, sarah.getBalance(), .1);
        assertEquals(0, moniek.getBalance(), .1);
        assertEquals(33.33, piet.getBalance(), .1);
    }
}