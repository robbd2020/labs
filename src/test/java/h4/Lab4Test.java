package h4;

import org.junit.Test;

import java.text.NumberFormat;

import static h4.Hw4.createHourGlass;
import static h4.Lab4.elevenProof;
import static org.junit.Assert.*;

public class Lab4Test {
    @Test
    public void whenPossibleBankNumberIsEnteredDisplayTrue() {
        assertTrue(elevenProof("317905929"));
        assertTrue(elevenProof("123456789"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEnteredNumberIsTooLargeExceptionIsGiven() {
        elevenProof("1234567891");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenEnteredNumberIsTooSmallExceptionIsGiven() {
        elevenProof("12345678");
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputForElevenproofContainsLetterExceptionIsGiven(){
        elevenProof("1234567b9");
    }

    @Test
    public void whenSeasonIsSpringItIsWarm(){
        assertEquals(Temp.WARM.name(), Hw4.determineSeason(Season.SPRING));
    }

    @Test
    public void whenImpossibleBankNumberIsEnteredDisplayFalse()  {
        assertFalse(elevenProof("987654321"));
    }

    @Test(expected = EvenNumberException.class)
    public void whenEvenNumberThrowException() throws EvenNumberException {
        createHourGlass(6);
    }

}