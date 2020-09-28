package unittesting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class StringAdder {

    public static final int ZERO = 0;

    public int add(String s) {

//        try {

            return Arrays.stream(s
                    .split((s.startsWith("//") ?
                            (s.charAt(2) == ('[') ?
                                    Arrays.stream(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]"))
                                            .split("]")).map(x -> x.replace("[", "")).collect(Collectors.joining("|"))
                                    : s.charAt(2))
                            : ",")
                            + "|\n"))
                    .collect(HashMap::new, (h, o) -> h.put(h.size(), o), HashMap::putAll)
                    .entrySet()
                    .stream().filter(map -> !(map.getKey().equals(0) && map.getValue().toString().startsWith("//")))
                    .map(map -> map.getValue()
                            .toString()
                            .replace(" ", "")
                            .replace("[", "")
                            .replace("]", ""))
                    .filter(c -> !c.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .filter(number -> number <= 1000)
                    .reduce(0, (x, y) -> x + y);



//        return Arrays.stream(s
//                .split((s.startsWith("//") ?
//                        (s.charAt(2) == ('[') ?
//                                Arrays.stream(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]"))
//                                        .split("]")).map(x -> x.replace("[", "")).collect(Collectors.joining("|"))
//                                : s.charAt(2))
//                        : ",")
//                        + "|\n"))
//
//                .map(map -> map
//                        .replace(" ", "")
//                        .replace("[", "")
//                        .replace("]", "")
//                        .replace("//", ""))
//                .filter(c -> !c.isEmpty())
//                .mapToInt(Integer::parseInt)
//                .filter(number -> number <= 1000)
//                .reduce(0, (x, y) -> x + y);




//        } catch (Exception e) {
//            throw new UnsupportedOperationException("Not yet implemented");
//        }
    }
}