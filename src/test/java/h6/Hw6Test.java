package h6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Hw6Test {

    @Test
    public void makeLongTwiceItsSize() {

        assertArrayEquals(new long[]{1L, 2L, 3L, 4L, 0, 0, 0, 0},
                Hw6.makeLongTwiceItsSize(new long[]{1L, 2L, 3L, 4L}));
    }
}