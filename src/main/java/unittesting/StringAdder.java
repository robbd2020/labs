package unittesting;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {
        int number = ZERO;
        String delimiter = ",";

//        try {

            if (s.length() >= 2 && s.startsWith("//")) {
                delimiter = Character.toString(s.charAt(2));
                s = s.substring(2);
            }

            String[] splitted = s.replace(" ", "").split("[" + delimiter + "|\n]");

            for (String s1 : splitted) {
                if (!s1.isEmpty())
                    number += Integer.parseInt(s1);
            }

            return number;
//        } catch (Exception e) {
//            throw new UnsupportedOperationException("Not yet implemented");
//        }
    }
}