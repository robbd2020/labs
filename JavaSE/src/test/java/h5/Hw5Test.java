package h5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Hw5Test {
    @Test
    public void whenFibonacciIsEight(){
        Hw5.Fibo fibo = new Hw5.Fibo();
        assertEquals(21, fibo.run(8));
    }
    @Test
    public void whenFibonacciIsZero(){
        Hw5.Fibo fibo = new Hw5.Fibo();
        assertEquals(0, fibo.run(0));
    }
    @Test
    public void whenFibonacciIsTwo(){
        Hw5.Fibo fibo = new Hw5.Fibo();
        assertEquals(1, fibo.run(2));
    }
    @Test
    public void whenFibonacciIsNegative(){
        Hw5.Fibo fibo = new Hw5.Fibo();
        assertEquals(-11, fibo.run(-11));
    }
}