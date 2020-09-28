package h9;

import h7.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void whenNoGenderIsGivenItsSetToUnknown(){
        assertEquals(piet1.getGender(), Gender.UNKNOWN);
    }

    @Test
    public void whenGenderIsSetToFemale(){
        wim.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, wim.getGender());
    }

    @Test
    public void whenTwoPersonsWithEqualPropertiesAreCompared(){
        piet1.setGender(Gender.UNKNOWN);
        assertTrue(piet1.equals(piet2));
    }

    @Test
    public void whenTwoPersonsWithUnequalsPropertiesAreCompared(){
        assertFalse(piet1.equals(jan));
    }

    @Test
    public void hashCodeOfPersonsWithEqualsPropertiesIsEqual(){
        piet1.setGender(Gender.UNKNOWN);
        assertEquals(piet1.hashcode(), piet2.hashcode());
    }
}