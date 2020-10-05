package h14;

import h7.Gender;

public class Start {
    public static void main(String[] args) {
        Person p1 = Person.builder().age(33).gender(Gender.MALE).name("Jan").build();
        Person p2 = Person.builder().age(33).gender(Gender.MALE).name("Jan").build();
        Person p3 = Person.builder().name("Jantine").gender(Gender.FEMALE).age(23).build();

        p3.addHistory("Biertje nuttigen");
        p3.addHistory("Wijntje consumeren");
        Group groupie = new Group();
        groupie.add(p1);
        groupie.add(p2);
        groupie.add(p3);
        System.out.println(groupie);
        System.out.println(groupie.getGroup().size());
        p3.printHistory();
    }
}
