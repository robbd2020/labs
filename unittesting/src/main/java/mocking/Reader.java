package mocking;

import java.util.Scanner;

public class Reader {
    public String scanLocatie(boolean vertrek) {
        String s = vertrek ? "Type vanwaar je wilt vertrekken: " :
                "Type je bestemming: ";
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
