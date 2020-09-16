package Hw7;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private int accountNumber;
    private Double balance = 0d;
    private Double interestRate = 0.03;
    private static Double totalBankBalance = 0d;
    private static List<BankAccount> accountList = new ArrayList<BankAccount>();

    public BankAccount(int number) {
        this.accountNumber = number;
        accountList.add(this);
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

    public int getAccountNumber(){
        return accountNumber;
    }

    public static Double getTotalBankBalance() {
        return totalBankBalance;
    }

    public static void printAllAccountInfo(){
        for (BankAccount account : accountList){
            System.out.println("Accountnumber: " + account.getAccountNumber() +
                    " earns " + account.calculateInterestRate() +
                    " interest per year");
        }
    }
}
