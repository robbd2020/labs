package h5;

import java.util.concurrent.atomic.AtomicInteger;

public class Lab5 {
    public static int greatest(int x, int y) {
        return x > y ? x : y;
    }

    public static String greatest(String x, String y) {
        return x.length() > y.length() ? x : y;
    }

    public static int greatest(int... list) {
        int largestNumber = Integer.MIN_VALUE;
        for (int variable : list) {
            if (variable > largestNumber) largestNumber = variable;
        }
        return largestNumber;
    }

    public static int factorial(int x) {
        if (x <= 1) return 1;
        else return x * factorial(x - 1);
    }

    public static void testje(String x) {
        x += "Ik heb iets toegevoegd";
    }

    public static void testje(AtomicInteger x) {
        x.set(x.intValue() + 1);
    }

    public static void printReverse(String str) {
        if (!str.equals("")) {
            System.out.print(str.substring(str.length() - 1));
            printReverse(str.substring(0, str.length() - 1));
        }
    }
}
