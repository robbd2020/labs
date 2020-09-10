public class Hw4 {

    enum Season {SPRING, SUMMER, FALL, WINTER}

    enum Temp {WARM, COLD, UNKNOWN}

    public static void determineSeason(Season season) {
        String message;
        switch (season) {

            case FALL:
            case WINTER:
                message = Temp.COLD.name();
                break;
            case SPRING:
            case SUMMER:
                message = Temp.WARM.name();
                break;
            default:
                message = Temp.UNKNOWN.name();
                break;
        }
        System.out.println(message);
    }

    public static String printHourGlass(int n) {
        if (n % 2 == 0) {
            return "Your input number is even. Try again!";
        } else {
            String message = "";
            for (int i = 1; i <= n; i++) {
                if (i == 1 || i == n) {
                    for (int j = 1; j <= n; j++) {
                        message += "*";
                    }
                } else if (i == (n / 2) + 1) {
                    for (int j = 1; j <= n; j++) {
                        if (j != (n / 2) + 1) {
                            message += " ";
                        } else {
                            message += "*";
                        }
                    }
                } else {
                    {
                        for (int j = 1; j <= n; j++) {
                            if (j != i && j != n - i + 1) {
                                message += " ";
                            } else {
                                message += "*";
                            }
                        }
                    }
                }
                message += "\n";
            }

            return message;
        }

    }
}
