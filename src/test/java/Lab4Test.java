import org.junit.Test;

import static org.junit.Assert.*;

public class Lab4Test {
    @Test
    public void whenPossibleBankNumberIsEnteredDisplayTrue(){
        assertTrue(Lab4.elevenProof("317905929"));
        assertTrue(Lab4.elevenProof("123456789"));
    }

    @Test
    public void whenImpossibleBankNumberIsEnteredDisplayFalse(){
        assertFalse(Lab4.elevenProof("987654321"));
    }
}