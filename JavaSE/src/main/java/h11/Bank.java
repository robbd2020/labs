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

    public BankAccount createAccount(AccountType accountType) {
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

    public void depositAccount(int account, double amount) {
        getBankAccountByNumber(account).deposit(amount);
    }

    public void withdrawAccount(int account, double amount){
        getBankAccountByNumber(account).withdraw(amount);
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
                    (account instanceof SavingsAccount ? " earns " +
                            ((SavingsAccount) account).getInterestRate() * account.getBalance() +
                            " interest / year" : ""));
        }
    }

    public int getFirstAvailableAccountNumber() {
        return this.firstAvailableAccountNumber;
    }

    public void setFirstAvailableAccountNumber(int firstAvailableAccountNumber) {
        this.firstAvailableAccountNumber = firstAvailableAccountNumber;
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
                from + " to account " + to);
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

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        public double calculateInterestRate() {
            return getBalance() * getInterestRate();
        }

    }

    private abstract class BankAccount {
        private int accountNumber;
        private double balance = 0d;

        BankAccount(int number) {
            this.accountNumber = number;
        }

        public void checkForSufficientCash(double amount) throws NotEnoughCashException {
            if (amount > this.balance) throw new NotEnoughCashException();
        }

        public double performWithdraw(double amount) {
            double amountToWithraw = amount;
            try {
                checkForSufficientCash(amountToWithraw);
            } catch (NotEnoughCashException e) {
                amountToWithraw = 0d;
            }
            this.balance -= amountToWithraw;
            return amountToWithraw;
        }

        public void withdraw(double amount) {
            System.out.println("You have withdrawn: " + performWithdraw(amount));
        }

        public double performDeposit(double amount) {
            this.balance += amount;
            return amount;
        }

        public void deposit(double amount) {
            System.out.println(performDeposit(amount) + " added to account!");
        }

        public double getBalance() {
            return this.balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

    }
}



