package Hw5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lab5Test {
    @Test
    public void whenFactorialIsFive() {
        assertEquals(120, Lab5.factorial(5));
    }

    @Test
    public void whenFactorialIsOne() {
        assertEquals(1, Lab5.factorial(1));
    }

    @Test
    public void whenFactorialIsZero() {
        assertEquals(1, Lab5.factorial(1));
    }

    @Test
    public void whenTwoIntegersAreCompared() {
        assertEquals(19, Lab5.greatest(18, 19));
    }

    @Test
    public void whenTwoStringsAreCompared() {
        assertEquals("doei", Lab5.greatest("hoi", "doei"));
    }

    @Test
    public void whenMultipleIntegersAreCompared() {
        assertEquals(132, Lab5.greatest(1, 2, 3, 34, 5, 87, 132, 131));
    }
}