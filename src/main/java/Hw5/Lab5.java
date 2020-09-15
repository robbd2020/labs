package Hw5;

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
        else return x * factorial(x-1);
    }
}
