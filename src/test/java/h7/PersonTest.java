package h7;

import org.junit.Test;

public class PersonTest {

    @Test(expected = PersonDiedException.class)
    public void whenOldFartHasBirthdayHeDies() throws PersonDiedException {
        Person jan = new Person("jan", 130);
        jan.haveBirthday();
    }

    @Test
    public void whenTwoUnequalPersonsAreCompared(){
        Person x = new Person("Henk", 50);


    }
}