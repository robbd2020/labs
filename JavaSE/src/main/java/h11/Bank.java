package h11;

import h7.NotEnoughCashException;

import java.util.HashMap;
import java.util.Map;

// Same Bank as in package banking, but with inner class BankAccount2. Advantage is that BankAccount2 can now be private
public class Bank {
    private Map<Integer, BankAccount> accountMap = new HashMap<>();

    private int firstAvailableAccountNumber = ACCOUNT_START_NUMBER;

    private static int ACCOUNT_START_NUMBER = 1;
    private final double STANDARD_INTEREST_RATE = 0.03;

    BankAccount createAccount(AccountType accountType) {
        BankAccount newAccount;
        switch (accountType) {
            case SAVING:
                newAccount = new SavingsAccount(getFirstAvailableAccountNumber());
                break;
            case CHECKING:
            default:
                newAccount = new CheckingAccount(getFirstAvailableAccountNumber());
                break;
        }
        System.out.println("Congrats, you just opened a new account!\nYour account number is: " + getFirstAvailableAccountNumber());
        accountMap.put(getFirstAvailableAccountNumber(), newAccount);
        this.firstAvailableAccountNumber++;
        return newAccount;
    }

    void depositAccount(int account, double amount) {
        getBankAccountByNumber(account).deposit(amount);
    }

    void withdrawAccount(int account, double amount) {
        getBankAccountByNumber(account).withdraw(amount);
    }

    double getTotalBankBalance() {
        return this.accountMap.values().stream().mapToDouble(BankAccount::getBalance).sum();
    }

    void printAllAccountInfo() {
        for (BankAccount account : accountMap.values()) {
            System.out.println("Accountnumber: " + account.getAccountNumber() +
                    (account instanceof SavingsAccount ? " earns " +
                            ((SavingsAccount) account).getInterestRate() * account.getBalance() +
                            " interest / year" : ""));
        }
    }

    private int getFirstAvailableAccountNumber() {
        return this.firstAvailableAccountNumber;
    }

    void transferMoney(int from, int to, double amount) {
        BankAccount accountFrom = getBankAccountByNumber(from);
        BankAccount accountTo = getBankAccountByNumber(to);
        double amountWithdrawn = accountFrom.performWithdraw(amount);
        accountTo.performDeposit(amountWithdrawn);
        System.out.println("The bank transferred " + amountWithdrawn + " from account " +
                from + " to account " + to);
    }

    private BankAccount getBankAccountByNumber(int number) {
        return accountMap.get(number);
    }

    private class CheckingAccount extends BankAccount {

        CheckingAccount(int number) {
            super(number);
        }

    }

    private class SavingsAccount extends BankAccount {
        private double interestRate;

        SavingsAccount(int number) {
            this(number, STANDARD_INTEREST_RATE);
        }

        SavingsAccount(int number, double interest) {
            super(number);
            setInterestRate(interest);
        }

        private double getInterestRate() {
            return interestRate;
        }

        private void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        private double calculateInterestRate() {
            return getBalance() * getInterestRate();
        }

    }

    private abstract class BankAccount {
        private int accountNumber;
        private double balance = 0d;

        BankAccount(int number) {
            this.accountNumber = number;
        }

        private void checkForSufficientCash(double amount) throws NotEnoughCashException {
            if (amount > this.balance) throw new NotEnoughCashException();
        }

        private double performWithdraw(double amount) {
            double amountToWithraw = amount;
            try {
                checkForSufficientCash(amountToWithraw);
            } catch (NotEnoughCashException e) {
                amountToWithraw = 0d;
            }
            this.balance -= amountToWithraw;
            return amountToWithraw;
        }

        private void withdraw(double amount) {
            System.out.println("You have withdrawn: " + performWithdraw(amount));
        }

        private double performDeposit(double amount) {
            this.balance += amount;
            return amount;
        }

        private void deposit(double amount) {
            System.out.println(performDeposit(amount) + " added to account!");
        }

        double getBalance() {
            return this.balance;
        }

        private int getAccountNumber() {
            return accountNumber;
        }

    }
}



