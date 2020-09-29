package h11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {
    Bank bigBank;

    @Before
            public void setUp() {
        bigBank = new Bank();
        bigBank.createAccount(AccountType.CHECKING);
        bigBank.createAccount(AccountType.SAVING);
        bigBank.createAccount(AccountType.SAVING);
        bigBank.createAccount(AccountType.CHECKING);
        bigBank.createAccount(AccountType.SAVING);

        bigBank.depositAccount(2, 100_000);
        bigBank.depositAccount(3, 230_000);
        bigBank.transferMoney(3, 4, 50_000);
        bigBank.transferMoney(4, 5, 40_000);
        bigBank.withdrawAccount(1, 100);

    }

    @Test
    public void whenMoneyIsTransferredTotalBankBalanceIsTheSame(){
        bigBank.transferMoney(2,3,100_000);
        assertEquals(330_000, bigBank.getTotalBankBalance(),0.1);
    }

}