package Hw7;

public class BankAccount {
    private int accountNumber;
    private Double balance = 0d;
    private Double interestRate = 0.03;
    private static Double totalBankBalance = 0d;

    public BankAccount(int number) {
        this.accountNumber = number;
    }

    public void withdraw(Double amount) {
        if (amount > this.balance) System.out.println("ERROR! Not enough money");
        else {
            this.balance -= amount;
            totalBankBalance -= amount;
            System.out.println(amount + " withdrawn");
        }
    }

    public void deposit(Double amount) {
        this.balance += amount;
        BankAccount.totalBankBalance += amount;
        System.out.println(amount + " added to account!");
    }

    public Double calculateInterestRate() {
        return balance * interestRate;
    }

    public Double getBalance() {
        return this.balance;
    }

    public static Double getTotalBankBalance() {
        return totalBankBalance;
    }
}
