package h14;

import java.util.Arrays;

public class Start2 {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4})));
    }

    public static int[] sortArray(int[] array) {
        int[] sortedOddArray = Arrays.stream(array).sorted().filter(i -> i % 2 == 1).toArray();

        for (int i = 0, counter = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) array[i] = sortedOddArray[counter++];
        }
        return array;
    }

}


