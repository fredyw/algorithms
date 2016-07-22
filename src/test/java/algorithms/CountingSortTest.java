package algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CountingSortTest {
    @Test
    public void testSort() {
        int[] array = new int[]{3, 2, 1, 2, 3, 1};
        CountingSort.sort(array, 20);
        assertEquals("[1, 1, 2, 2, 3, 3]", Arrays.toString(array));

        array = new int[]{1, 4, 1, 2, 7, 5, 2};
        CountingSort.sort(array, 20);
        assertEquals("[1, 1, 2, 2, 4, 5, 7]", Arrays.toString(array));
    }
}
