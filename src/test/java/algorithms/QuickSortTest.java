package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    @Test
    public void testSort() {
        Integer[] array = new Integer[]{10, 1, 4, 2, 6, 7, 3, 5, 8, 9};
        QuickSort.sort(array);
        assertEquals("1 2 3 4 5 6 7 8 9 10", join(array, " "));
    }

    private <T> String join(T[] array, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    @Test
    public void testPartition() {
        Integer[] a = new Integer[]{5, 7, 2, 8, 3, 9, 6, 4, 1};
        assertEquals(4, QuickSort.partition(a, 0, a.length - 1));
        assertEquals("3 1 2 4 5 9 6 8 7", join(a, " "));

        a = new Integer[]{-1, 3, 6, 0, -10};
        assertEquals(2, QuickSort.partition(a, 1, 3));
        assertEquals("-1 0 3 6 -10", join(a, " "));

        a = new Integer[]{10, 1, 4, 2, 6, 7, 3, 5, 8, 9};
        assertEquals(9, QuickSort.partition(a, 0, a.length - 1));
        assertEquals("9 1 4 2 6 7 3 5 8 10", join(a, " "));

        a = new Integer[]{0, 1, 4, 2, 6, 7, 3, 5, 8, 9};
        assertEquals(0, QuickSort.partition(a, 0, a.length - 1));
        assertEquals("0 1 4 2 6 7 3 5 8 9", join(a, " "));
    }
}
