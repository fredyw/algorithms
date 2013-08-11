package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {
    @Test
    public void testDescending() {
        Integer[] a = new Integer[]{5, 8, 6, 3, 2, 1, 4, 7, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>(true);
        for (int i : a) {
            pq.insert(i);
        }
        assertEquals(9, pq.size());
        Integer[] result = new Integer[pq.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.remove();
        }
        assertEquals("1 2 3 4 5 6 7 8 9", join(result, " "));
        assertEquals(0, pq.size());
    }
    
    @Test
    public void testAscending() {
        Integer[] a = new Integer[]{5, 8, 6, 3, 2, 1, 4, 7, 9};
        PriorityQueue<Integer> pq = new PriorityQueue<>(false);
        for (int i : a) {
            pq.insert(i);
        }
        assertEquals(9, pq.size());
        Integer[] result = new Integer[pq.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = pq.remove();
        }
        assertEquals("9 8 7 6 5 4 3 2 1", join(result, " "));
        assertEquals(0, pq.size());
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
