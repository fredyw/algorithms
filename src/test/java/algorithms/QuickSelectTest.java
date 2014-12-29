package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSelectTest {
    @Test
    public void test() {
        Integer[] array = new Integer[] {6, 3, 9, 2, 1, 5, 8, 4, 7};
        assertEquals(1, QuickSelect.select(array, 1).intValue());
        assertEquals(2, QuickSelect.select(array, 2).intValue());
        assertEquals(3, QuickSelect.select(array, 3).intValue());
        assertEquals(4, QuickSelect.select(array, 4).intValue());
        assertEquals(5, QuickSelect.select(array, 5).intValue());
        assertEquals(6, QuickSelect.select(array, 6).intValue());
        assertEquals(7, QuickSelect.select(array, 7).intValue());
        assertEquals(8, QuickSelect.select(array, 8).intValue());
        assertEquals(9, QuickSelect.select(array, 9).intValue());
    }
}
