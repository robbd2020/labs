package h7;

import org.junit.Test;

public class Hw7Test {
    @Test
    public void testPerson() throws PersonDiedException {
        h7.Person p = new h7.Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday(); // person gets one year older
        System.out.println(p.getAge());
        System.out.println(h7.Person.numberOfPossibleGenders);
    }
}