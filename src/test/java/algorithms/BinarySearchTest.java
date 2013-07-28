package algorithms;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(3, BinarySearch.search(list, 10));
        
        list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(6, BinarySearch.search(list, 15));
        
        list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(7, BinarySearch.search(list, 17));
        
        list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(0, BinarySearch.search(list, 1));
        
        list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(1, BinarySearch.search(list, 5));
        
        list = Arrays.asList(new Integer[]{1, 5, 6, 10, 11, 14, 15, 17});
        assertEquals(-1, BinarySearch.search(list, 0));
    }
}
