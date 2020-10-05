package h14;

import h7.Gender;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GroupTest {

    @Test
    public void whenTwoPersonsWithSamePropertiesAreAddedToAGroupTheGroupOnlyContainsOnePerson() {
        Person p1 = Person.builder().name("Jan").age(33).gender(Gender.MALE).build();
        Person p2 = Person.builder().name("Jan").age(33).gender(Gender.MALE).build();

        Group groupie = new Group();
        groupie.add(p1);
        groupie.add(p2);
        assertThat(groupie.getGroup().size(), is(1));
    }
}