package h11;

import h7.Gender;

public class Start {

    public static void main(String[] args) {
        Person persoon = new Person("Jantje",9, Gender.MALE);
        persoon.addHistory("Fietsen");
        persoon.addHistory("Voetballen");
        persoon.addHistory("Gamen");
        persoon.addHistory("Op bezoek bij Ome Henk");
        persoon.printHistory();

        System.out.println(persoon.createSubHuman().greet());

        Bank bigBank = new Bank();
        bigBank.createAccount(AccountType.CHECKING);
        bigBank.createAccount(AccountType.SAVING);
        bigBank.createAccount(AccountType.SAVING);
        bigBank.createAccount(AccountType.CHECKING);
        bigBank.createAccount(AccountType.SAVING);

        bigBank.depositAccount(2,100_000);
        bigBank.depositAccount(3, 230_000);
        bigBank.transferMoney(3,4,50_000);
        bigBank.transferMoney(4,5,40_000);
        bigBank.withdrawAccount(1,100);

        System.out.println();
        bigBank.printAllAccountInfo();
    }
}
