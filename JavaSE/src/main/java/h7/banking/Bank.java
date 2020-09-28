package h7.banking;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accountMap = new HashMap<>();
    private int firstAvailableAccountNumber = ACCOUNT_START_NUMBER;
    private static int ACCOUNT_START_NUMBER = 1;

    public BankAccount openNewAccount() {
        BankAccount newAccount = new BankAccount(firstAvailableAccountNumber);
        System.out.println("Congrats, you just opened a new account!\nYour account number is: " + firstAvailableAccountNumber);
        accountMap.put(firstAvailableAccountNumber, newAccount);
        this.firstAvailableAccountNumber++;
        return newAccount;
    }

    public double getTotalBankBalance() {
        double totalBankBalance = 0d;
        for (BankAccount account : accountMap.values()) {
            totalBankBalance += account.getBalance();
        }
        return totalBankBalance;
    }

    public void printAllAccountInfo() {
        for (BankAccount account : accountMap.values()) {
            System.out.println("Accountnumber: " + account.getAccountNumber() +
                    " earns " + account.calculateInterestRate() +
                    " interest per year");
        }
    }

    public BankAccount getBankAccountByNumber(int number) {
        return accountMap.get(number);
    }

    public void transferMoney(int from, int to, double amount) {
        BankAccount accountFrom = getBankAccountByNumber(from);
        BankAccount accountTo = getBankAccountByNumber(to);
        double amountWithdrawn = accountFrom.performWithdraw(amount);
        accountTo.performDeposit(amountWithdrawn);
        System.out.println("The bank transferred " + amountWithdrawn + " from account " +
                from + " to account " + to );
    }

}
