package h7;

import java.util.HashMap;
import java.util.Map;

// Same Bank as in package banking, but with inner class BankAccount2. Advantage is that BankAccount2 can now be private
public class Bank2 {
    private Map<Integer, BankAccount2> accountMap = new HashMap<>();
    private int firstAvailableAccountNumber = ACCOUNT_START_NUMBER;
    private static int ACCOUNT_START_NUMBER = 1;

    public BankAccount2 openNewAccount() {
        BankAccount2 newAccount = new BankAccount2(firstAvailableAccountNumber);
        System.out.println("Congrats, you just opened a new account!\nYour account number is: " + firstAvailableAccountNumber);
        accountMap.put(firstAvailableAccountNumber, newAccount);
        this.firstAvailableAccountNumber++;
        return newAccount;
    }

    public void depositAccount(int account, double amount){
        getBankAccountByNumber(account).deposit(amount);
    }

    public double getTotalBankBalance() {
        double totalBankBalance = 0d;
        for (BankAccount2 account : accountMap.values()) {
            totalBankBalance += account.getBalance();
        }
        return totalBankBalance;
    }

    public void printAllAccountInfo() {
        for (BankAccount2 account : accountMap.values()) {
            System.out.println("Accountnumber: " + account.getAccountNumber() +
                    " earns " + account.calculateInterestRate() +
                    " interest per year");
        }
    }

    public BankAccount2 getBankAccountByNumber(int number) {
        return accountMap.get(number);
    }

    public void transferMoney(int from, int to, double amount) {
        BankAccount2 accountFrom = getBankAccountByNumber(from);
        BankAccount2 accountTo = getBankAccountByNumber(to);
        double amountWithdrawn = accountFrom.performWithdraw(amount);
        accountTo.performDeposit(amountWithdrawn);
        System.out.println("The bank transferred " + amountWithdrawn + " from account " +
                from + " to account " + to);
    }

    private class BankAccount2 {
        private int accountNumber;
        private double balance = 0d;
        private double interestRate = 0.03;

        BankAccount2(int number) {
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

        public double calculateInterestRate() {
            return balance * interestRate;
        }

        public double getBalance() {
            return this.balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

    }
}


