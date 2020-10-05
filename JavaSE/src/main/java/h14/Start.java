package h14;

import h7.Gender;

public class Start {
    public static void main(String[] args) {
        Person p1 = new Person("Jan", 33, Gender.MALE);
        Person p2 = new Person("Jan", 33, Gender.MALE);
        Person p3 = new Person("Jantine", 23, Gender.FEMALE);

        Group groupie = new Group();
        groupie.add(p1);
        groupie.add(p2);
        groupie.add(p3);
        System.out.println(groupie);
        System.out.println(groupie.getGroup().size());
    }
}
