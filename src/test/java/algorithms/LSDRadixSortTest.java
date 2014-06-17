package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class LSDRadixSortTest {
    @Test
    public void testSort() {
        String[] strings = new String[] {
            "3ABC",
            "1DEF",
            "4XYZ",
            "4ABC",
            "2ABC",
            "3DEF",
            "1ABC"
        };
        LSDRadixSort.sort(strings, 4, 256);
        
        assertEquals("1ABC", strings[0]);
        assertEquals("1DEF", strings[1]);
        assertEquals("2ABC", strings[2]);
        assertEquals("3ABC", strings[3]);
        assertEquals("3DEF", strings[4]);
        assertEquals("4ABC", strings[5]);
        assertEquals("4XYZ", strings[6]);
    }
}
