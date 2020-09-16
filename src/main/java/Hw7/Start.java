package Hw7;

public class Start {
    public static void main(String[] args) {
//        Hw7.Person jan = new Hw7.Person("Jan", 130);
//        try {
//            jan.haveBirthday();
//        } catch (PersonDiedException e) {
//            System.out.println(e.getMessage());
//        }

        BankAccount henk = new BankAccount(1);
        BankAccount piet = new BankAccount(2);
        BankAccount jan = new BankAccount(3);
        BankAccount klaas = new BankAccount(4);
        henk.deposit(100d);
        jan.deposit(75.43);
        piet.deposit(1_000_000.93d);
        System.out.println(jan.calculateInterestRate());
        System.out.println(BankAccount.getTotalBankBalance());
        BankAccount.printAllAccountInfo();
    }
}
