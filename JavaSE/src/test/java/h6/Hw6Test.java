package h6;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Hw6Test {

    @Test
    public void makeLongTwiceItsSize() {

        assertArrayEquals(new long[]{1L, 2L, 3L, 4L, 0, 0, 0, 0},
                Hw6.makeLongTwiceItsSize(new long[]{1L, 2L, 3L, 4L}));
    }

    @Test
    public void multiply(){
        long[] x = {1L, 2L, 3L, 4L};
        Hw6.multiply(x, 3);
        assertArrayEquals(new long[]{3L, 6L, 9L, 12L}, x);
    }
}