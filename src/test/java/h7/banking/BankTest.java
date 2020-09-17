package h7.banking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankTest {

    Bank abn;

    @Before
    public void init() {
        abn = new Bank();
        BankAccount piet = abn.openNewAccount();
        BankAccount sarah = abn.openNewAccount();
        BankAccount guus = abn.openNewAccount();
        BankAccount moniek = abn.openNewAccount();

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
        assertEquals(0d, abn.getBankAccountByNumber(1).performWithdraw(35), .1);
    }

    @Test
    public void whenMoneyIsTransferredItIsWithdrawnCorrectly(){
        abn.transferMoney(2,1,100d);
        assertEquals(abn.getBankAccountByNumber(1).getBalance(), 133.33, 0.1);
    }

    @Test
    public void whenMoneyIsTransferredItIsDepositedCorrectly(){
        abn.transferMoney(2,1,100d);
        assertEquals(abn.getBankAccountByNumber(2).getBalance(), 899.21, 0.1);
    }

    @Test
    public void whenMoreThanAvailableMoneyIsTransferredNothingWithdrawnOrDeposited(){
        abn.transferMoney(2,3,1000d);
        assertEquals(1_000_000,abn.getBankAccountByNumber(3).getBalance(),.1);
        assertEquals(999.21,abn.getBankAccountByNumber(2).getBalance(),.1);
    }
}