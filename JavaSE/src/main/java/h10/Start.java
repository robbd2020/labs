package h10;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        ArrayList<Human> humanList = new ArrayList<>();
        humanList.add(new Person("Persoon"));
        humanList.add(new Android());
        humanList.add(new Employee());
        humanList.add(new Teacher("Bram"));

        humanList.forEach(Human -> System.out.println(Human.greet()));
    }
}
