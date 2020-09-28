package h5;

import static h5.Lab5.printReverse;
import static h5.Lab5.testje;

public class Start {
    public static void main(String[] args) {
        System.out.println(Lab5.greatest(19, 76));
        System.out.println(Lab5.greatest("hoi", "doei"));
        System.out.println(Lab5.greatest(1, 2, 3, 77, 86, 13, 99, 132, 94));
        System.out.println(Lab5.factorial(11));

        printReverse("Hallo daar, alles goed?");
        System.out.println();
        Hw5.Fibo fibo = new Hw5.Fibo();
        fibo.printFiboRec(6);

//        String b = "robbie";
//        testje(b);
//        System.out.println(b);
//
//        AtomicInteger c = new AtomicInteger(9);
//        testje(c);
//        System.out.println(c);
    }


}
