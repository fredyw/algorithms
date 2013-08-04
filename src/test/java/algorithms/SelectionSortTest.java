package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSortTest {
    @Test
    public void test() {
        Integer[] array = new Integer[] {10, 1, 4, 2, 6, 7, 3, 5, 8, 9};
        SelectionSort.sort(array);
        assertEquals("1 2 3 4 5 6 7 8 9 10", join(array, " "));
    }
    
    private <T> String join(T[] array, String separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length-1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
