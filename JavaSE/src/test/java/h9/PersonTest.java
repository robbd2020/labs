package h9;

import h7.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PersonTest {

    Person piet1;
    Person piet2;
    Person jan;
    Person wim;

    @Before
    public void setUp() {
        piet1 = Person.builder().age(40).name("Piet").build();
        piet2 = Person.builder().name("Piet").age(40).gender(Gender.UNKNOWN).build();
        jan = Person.builder().age(55).gender(Gender.MALE).name("Jan").build();
        wim = Person.builder().build();
    }

    @Test
    public void whenNoGenderIsGivenItsSetToUnknown() {
        assertEquals(piet1.getGender(), Gender.UNKNOWN);
    }

    @Test
    public void whenGenderIsSetToFemale() {
        wim.setGender(Gender.FEMALE);
        assertEquals(Gender.FEMALE, wim.getGender());
    }

    @Test
    public void whenTwoPersonsWithEqualPropertiesAreCompared() {
        piet1.setGender(Gender.UNKNOWN);
        assertEquals(piet1, piet2);
    }

    @Test
    public void whenTwoPersonsWithUnequalsPropertiesAreCompared() {
        assertNotEquals(piet1, jan);
    }

    @Test
    public void hashCodeOfPersonsWithEqualsPropertiesIsEqual() {
        piet1.setGender(Gender.UNKNOWN);
        assertEquals(piet1.hashcode(), piet2.hashcode());
    }
}