package h6;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        System.out.println(row[2]);
//        System.out.println(row[4]);  // Array index out of range

        long[] x = {1L, 2L, 3L, 4L};
        Hw6.multiply(x, 3);
        System.out.println(Arrays.toString(x));

        System.out.println(Arrays.toString(Hw6.Fibo.arrayFiboRec(1000000)));
    }
}
