package h6;

public class Hw6 {
    public static long[] makeLongTwiceItsSize(long[] arg) {
        long[] newArg = new long[arg.length * 2];
        for (int position = 0; position < arg.length; position++) {
            newArg[position] = arg[position];
        }
        return newArg;
    }

    public static void multiply(long[] input, int multiplier){
        for (int i = 0; i < input.length; i++){
            input[i] *= multiplier;
        }
    }
}
