package unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAdderTest {
    StringAdder adder;

    @BeforeEach
    public void setup() {
        adder = new StringAdder();
    }

    @Test
    public void whenAddIsCalledWithEmptyStringItShouldReturnZero() {
        int result = adder.add("");
        assertEquals(0, result);
    }

    @Test
    public void whenAddIsCalledWithOneItShouldReturnOne() {
        int result = adder.add("1");
        assertEquals(1, result);
    }

    @Test
    public void whenAddIsCalledWithTwoArgumentsItShouldReturnTheSum() {
        int result = adder.add("1,2");
        assertEquals(3, result);
    }

    @Test
    public void whenAddIsCalledWithSevenArgumentsItShouldReturnTheSum() {
        int result = adder.add("1,2,3,4,5,6,7");
        assertEquals(28, result);
    }

    @Test
    public void whenAddIsCalledWithArgumentsWithNewLineItShouldReturnTheSum() {
        assertEquals(4, adder.add("1,2\n1"));
    }

    @Test
    public void whenAddIsCalledWithDelimiterGivenItShouldReturnTheSum() {
        assertEquals(3, adder.add("//;\n1;2"));
    }

    @Test
    public void whenAddIsCalledWithSpacesItShouldReturnTheSum() {
        assertEquals(3, adder.add("//;\n 1 ; 2 "));
    }

    @Test
    public void whenAddIsCalledWithTooLargeNumberReturnException() {
        assertThrows(NumberFormatException.class, () -> adder.add("1,12345657464562652562"));
    }

    @Test
    public void whenAddIsCalledWithDashDashWhileThatsNotPartOfDelimiterReturnException() {
        assertThrows(NumberFormatException.class, () -> adder.add("1,2,3//,4"));
    }

    @Test
    public void whenAddIsCalledWithDelimiterDashDashReturnSum() {
        assertEquals(3, adder.add("//[//]1//2"));    }



    @Test
    public void whenAddIsCalledWithNegativeNumbersReturnSum() {
        assertEquals(-3, adder.add("//r-1r-2"));
    }

    @Test
    public void whenAddIsCalledWithTooLargeNumbersThoseNumbersAreIgnored() {
        assertEquals(6, adder.add("1,2,3,1001,1002"));
    }

    @Test
    public void whenAddIsCalledWithBoundaryNumberOneThousandThisNumberIsNotIgnored() {
        assertEquals(1006, adder.add("1,2,3,1000,1002"));
    }

    @Test
    public void whenAddIsCalledWithDelimitersOfLengthLargerThanOne() {
        assertEquals(11, adder.add("//[bier]1bier7bier3bier"));
    }

    @Test
    public void whenAddIsCalledWithMultipleDelimitersOfLengthLargerThanOne() {
        assertEquals(11, adder.add("//[bier][wijntjes]1bier7wijntjes3bier"));
    }

}