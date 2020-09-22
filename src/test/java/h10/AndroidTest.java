package h10;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class AndroidTest {

    Android andy;
    Employee employee;
    Person person;
    Teacher teacher;

    @Before
    public void setup() {
        andy = new Android();
        andy.setLevel(80);
        employee = new Employee();
        person = new Person();
        teacher = new Teacher("Bram");

    }

    @Test
    public void whenAndroidIsChargedLevelGotUp() {
        andy.charge(10);
        assertEquals(90, andy.getLevel());
    }

    @Test
    public void whenAndroidChargeWouldLevelGetOverHundredNoIncreaseInLevel(){
        andy.charge(25);
        assertEquals(80, andy.getLevel());
    }

    @Test
    public void personIsAHuman(){
        assertThat(person, instanceOf(Human.class));
    }
    @Test
    public void employeeIsAHuman(){
        assertThat(employee, instanceOf(Human.class));
    }
    @Test
    public void androidIsAHuman(){
        assertThat(andy, instanceOf(Human.class));
    }
    @Test
    public void teacherIsAHuman(){
        assertThat(teacher, instanceOf(Human.class));
    }

    @Test
    public void androidImplementsChargeable(){
        assertThat(andy, instanceOf(Chargeable.class));
    }

}