package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {
    @Test
    public void testSort() {
        Integer[] array = new Integer[]{10, 1, 4, 2, 6, 7, 3, 5, 8, 9};
        MergeSort.sort(array);
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
    public void testMerge() {
        Integer[] a = new Integer[]{-1, 3, 5, 6, 7, 2, 4, 8, 9, -9};
        MergeSort.merge(a, 1, 4, 8);
        assertEquals("-1 2 3 4 5 6 7 8 9 -9", join(a, " "));

        a = new Integer[]{-1, 2, 4, 8, 9, 3, 5, 6, 7, -9};
        MergeSort.merge(a, 1, 4, 8);
        assertEquals("-1 2 3 4 5 6 7 8 9 -9", join(a, " "));
    }
}
