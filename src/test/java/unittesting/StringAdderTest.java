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
        assertThrows(NumberFormatException.class, () -> adder.add("12345657464562652562"));
    }
}