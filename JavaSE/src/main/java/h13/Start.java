package h13;

import h10.Android;
import h10.Human;
import h10.Person;
import h10.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Start {
    public static void main(String[] args) {

        House<Teacher> house = new House<>(new Teacher(""));

        List<House<Human>> dorpje = new ArrayList<>();
        dorpje.add(new House<>(new Teacher("Bram")));
        dorpje.add(new House<>(new Android()));
        dorpje.add(new House<>(new Person("Henno", 87)));

        dorpje.forEach(System.out::println);

        MyCollection col = new MyCollection();
        col.add(new Object());
        System.out.println(col.container.length);
    }
}
