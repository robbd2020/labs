package h4;

import java.util.Scanner;

public class Hw4 {

    public static String determineSeason(Season season) {
        String message;
        switch (season) {

            case FALL:
            case WINTER:
                message = Temp.COLD.name();
                break;
            case SPRING:
            case SUMMER:
                message = Temp.WARM.name();
                break;
            default:
                message = Temp.UNKNOWN.name();
                break;
        }
        return message;
    }

    public static void printHourGlass() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Je wilt een zandloper printen. Hoe groot moet de zandloper zijn? Kies een oneven getal: ");

        int input = Integer.parseInt(myObj.nextLine());  // Read user input
        try {
            System.out.println(createHourGlass(input));
        } catch (EvenNumberException e) {
            System.out.println("Je hebt een even getal ingevoerd! Probeer het nog een keer");
            printHourGlass();
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
            printHourGlass();
        }
    }

    public static String printUpperOrLowerRow(int size) {
        String row = "";
        for (int j = 1; j <= size; j++) {
            row += "*";
        }
        return row;
    }

    public static String printCenterRow(int size) {
        String row = "";
        for (int j = 1; j <= size; j++) {
            if (j != (size / 2) + 1) {
                row += " ";
            } else {
                row += "*";
            }
        }
        return row;
    }

    public static String printInBetweenRow(int positionOfRow, int size) {
        String row = "";
        for (int j = 1; j <= size; j++) {
            if (j != positionOfRow && j != size - positionOfRow + 1) {
                row += " ";
            } else {
                row += "*";
            }
        }
        return row;
    }

    public static String createHourGlass(int n) throws EvenNumberException {
        if (n % 2 == 0) {
            throw new EvenNumberException();
        } else {
            String message = "";
            for (int i = 1; i <= n; i++) {
                if (i == 1 || i == n) {
                    message += printUpperOrLowerRow(n);
                } else if (i == (n / 2) + 1) {
                    message += printCenterRow(n);
                } else {
                    message += printInBetweenRow(i, n);
                }
                message += "\n";
            }
            return message;
        }

    }

}
