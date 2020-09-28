package h7.banking;

import h7.NotEnoughCashException;

public class BankAccount {
    private int accountNumber;
    private double balance = 0d;
    private double interestRate = 0.03;

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
