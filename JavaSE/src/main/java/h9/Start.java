package h9;

import h7.Gender;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        Person Willem = new Person();
        Person Willemien = new Person("Willemien", 33, Gender.FEMALE);
        Willem = null;
        Willemien.getGender();
        Willemien = null;
        System.gc();
//        for (int i = 0; i < (5*60); i++) {
//            System.out.println("zzz");
//            Thread.sleep(1000);
//        }
    }
}
