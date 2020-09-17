package h6;

public class Hw6 {
    public static long[] makeLongTwiceItsSize(long[] arg) {
        long[] newArg = new long[arg.length * 2];
        for (int position = 0; position < arg.length; position++) {
            newArg[position] = arg[position];
        }
        return newArg;
    }

    public static void multiply(long[] input, int multiplier) {
        for (int i = 0; i < input.length; i++) {
            input[i] *= multiplier;
        }
    }

    public static class Fibo {
        private static final int MAX_NUMBERS_FOR_CALCULATION = 30;

        private static int run(int n) {
            if (n < 2) return n;
            return run(n - 2) + run(n - 1);
        }

        public static int[] arrayFiboRec(int n) {
            int maxNumber = Math.min(n, MAX_NUMBERS_FOR_CALCULATION);

            int[] arr = new int[maxNumber];
            for (int i = 1; i <= maxNumber; i++) {
                arr[i - 1] = run(i);
            }
            return arr;
        }
    }
}
