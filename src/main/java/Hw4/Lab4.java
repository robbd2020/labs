package Hw4;

import java.util.Scanner;

public class Lab4 {

    public static Boolean elevenProof(String accountNr) {
        int multiplicationFactor = 9;
        int numberToCheck = 0;
        for (int i = 0; i < accountNr.length(); i++) {
            numberToCheck += Integer.parseInt(accountNr.charAt(i) + "") * multiplicationFactor--;
        }

        return numberToCheck % 11 == 0;
    }

    public static void checkBankAccountPossibility() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number please: ");

        String input = myObj.nextLine();  // Read user input
        try {
            System.out.println(elevenProof(input));
        } catch (NumberFormatException e){
            System.out.println("You entered a letter. Try again!");
            checkBankAccountPossibility();
        }
    }
}
