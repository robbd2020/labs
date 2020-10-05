package h9;

import h7.Gender;

public class Start {
    public static void main(String[] args)  {
        Person Willem = Person.builder().name("Willem").build();
        Person Willemien = Person.builder().name("Willemien").age(33).gender(Gender.FEMALE).build();
        Willem = null;
        Willemien.getGender();
        Willemien = null;
        System.gc();
//        for (int i = 0; i < (5*60); i++) {
//            System.out.println("zzz");
//            Thread.sleep(1000);
//        }
//        BuilderExample be = BuilderExample.builder().name("Henk").age(3).occupation("Peuter").occupation("Ettertje").build();
//        System.out.println(be);
        Person pwb = Person.builder().age(3).name("Hannibal").build();
        System.out.println(pwb);
    }
}
