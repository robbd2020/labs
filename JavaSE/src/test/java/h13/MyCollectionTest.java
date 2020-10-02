package h13;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MyCollectionTest {


    @Before
    public void setup(){

    }


    @Test
    public void whenMyIntegerCollectionIsInitializedISizeIsFourAndAllNumbersAreDefault() {
        MyCollection<Integer> col = new MyCollection<>();
        assertEquals(4, col.getContainer().length);
        Integer[] expectedResult = new Integer[]{null, null, null, null};
        Integer[] result = Arrays.copyOf(col.getContainer(), col.getContainer().length,
                Integer[].class);
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void whenOneIntegerIsAddedToMyIntCollectionItIsIsPutInTheContainer() {
        MyCollection<Integer> col = new MyCollection<>();

        col.add(3);
        assertArrayEquals(new Integer[]{3, null, null, null},
                Arrays.copyOf(col.getContainer(), col.getContainer().length, Integer[].class));

    }

    @Test
    public  void whenCollectionIsFullWithFourElementsTheSizeIsStillFour(){
        MyCollection<Integer> col = new MyCollection<>();

        IntStream.range(1,5).forEach(col::add);
        assertEquals(4, col.getContainer().length);
    }

    @Test
    public void whenFiveIntegersAreAddedToMyIntCollectionTheSizeIs8(){
        MyCollection<Integer> col = new MyCollection<>();

        IntStream.range(1,6).forEach(col::add);
        assertEquals(8, col.getContainer().length);
    }

    @Test
    public void whenFiveIntegersAreAddedToMyIntCollectionThoseFiveArePrintedWhenToArrayMethodIsCalled(){
        MyCollection<Integer> col = new MyCollection<>();
        IntStream.range(1,6).forEach(col::add);
        assertEquals("1, 2, 3, 4, 5", col.toString());
    }

    @Test
    public void whenMyIntegerCollectionGetsSixtyFiveItemsItsSizeIs128(){
        MyCollection<Integer> col = new MyCollection<>();
        IntStream.range(0,65).forEach(col::add);
        assertEquals(128, col.getContainer().length);
    }

    @Test
    public void whenMyCollectionContainsFiveStringElementsTheyArePrintedCorrectly(){
        MyCollection<String> col = new MyCollection<>();
        String[] words = {"ik", "ben", "een","beetje", "gek"};
        Arrays.stream(words).forEach(col::add);
        assertEquals(8, col.getContainer().length);
        assertEquals("ik, ben, een, beetje, gek", col.toString());
    }

}
