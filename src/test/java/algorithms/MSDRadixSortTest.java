package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class MSDRadixSortTest {
    @Test
    public void testSort() {
        String[] strings = new String[] {
            "4CEF",
            "3BMNO",
            "1ABDE",
            "3BMN",
            "1ABC",
            "2ADF",
            "2ACFM"
        };
        MSDRadixSort.sort(strings, 256);
        
        assertEquals("1ABC", strings[0]);
        assertEquals("1ABDE", strings[1]);
        assertEquals("2ACFM", strings[2]);
        assertEquals("2ADF", strings[3]);
        assertEquals("3BMN", strings[4]);
        assertEquals("3BMNO", strings[5]);
        assertEquals("4CEF", strings[6]);
    }
}
