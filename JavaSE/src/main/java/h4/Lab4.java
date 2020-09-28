package h4;

import java.util.Scanner;

public class Lab4 {

    public static Boolean elevenProof(String accountNr) throws IllegalArgumentException {
        if (accountNr.length()!=9) throw new IllegalArgumentException("De bankrekening moet uit negen nummer bestaan");
        int numberToCheck = 0;
        for (int i = 0; i < accountNr.length(); i++) {
            numberToCheck += Integer.parseInt(accountNr.charAt(i) + "") * (accountNr.length()-i);
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
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
