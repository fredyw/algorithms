package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeSumTest {
    @Test
    public void test() {
        int[] result = ThreeSum.solve(new Integer[]{-7, 0, 1, 7, 10});
        assertEquals(-7, result[0]);
        assertEquals(0, result[1]);
        assertEquals(7, result[2]);
    }
}
