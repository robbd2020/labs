package h14;

import h7.Gender;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class GroupTest {

    @Test
    public void whenTwoPersonsWithSamePropertiesAreAddedToAGroupTheGroupOnlyContainsOnePerson() {
        Person p1 = new Person("Jan", 33, Gender.MALE);
        Person p2 = new Person("Jan", 33, Gender.MALE);

        Group groupie = new Group();
        groupie.add(p1);
        groupie.add(p2);
        assertThat(groupie.getGroup().size(), is(1));
    }
}