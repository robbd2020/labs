package unittesting;

import java.util.Arrays;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {

        String delimiter = ",";

//        try {

        if (s.length() >= 2 && s.startsWith("//")) {
            delimiter = Character.toString(s.charAt(2));
            s = s.substring(2);
        }

        return Arrays.stream(s.replace(" ", "")
                .split("[" + delimiter + "|\n]"))
                .filter(c -> !c.isEmpty())
                .mapToInt(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);

//        } catch (Exception e) {
//            throw new UnsupportedOperationException("Not yet implemented");
//        }
    }
}