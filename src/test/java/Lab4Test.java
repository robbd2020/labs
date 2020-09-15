import Hw4.*;
import org.junit.Test;

import static Hw4.Hw4.createHourGlass;
import static org.junit.Assert.*;

public class Lab4Test {
    @Test
    public void whenPossibleBankNumberIsEnteredDisplayTrue(){
        assertTrue(Lab4.elevenProof("317905929"));
        assertTrue(Lab4.elevenProof("123456789"));
    }

    @Test
    public void whenSeasonIsSpringItIsWarm(){
        assertEquals(Temp.WARM.name(), Hw4.determineSeason(Season.SPRING));
    }

    @Test
    public void whenImpossibleBankNumberIsEnteredDisplayFalse(){
        assertFalse(Lab4.elevenProof("987654321"));
    }

    @Test(expected = EvenNumberException.class)
    public void whenEvenNumberThrowException() throws EvenNumberException {
        createHourGlass(6);
    }

}