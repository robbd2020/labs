package h11;

import h7.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonTest {

    Person piet1;
    Person piet2;
    Person jan;
    Person wim;

    @Before
    public void setUp() {
        piet1 = new Person("Piet", 40);
        piet2 = new Person("Piet", 40, Gender.UNKNOWN);
        jan = new Person("Jan", 55, Gender.MALE);
        wim = new Person();
    }

//    public void testAddHistory() {
//    }
//
//    public void testPrintHistory() {
//    }

    @Test
    public void whenSubHumanIsCreatedItsGreetContainsSubIsTheBest() {
        assertTrue(jan.createSubHuman().greet().contains("Sub is the best"));
    }
}