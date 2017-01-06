package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentTreeTest {
    @Test
    public void testSumRange() {
        SegmentTree<Integer> tree = new SegmentTree<>(
            new Integer[]{1, 3, 5, 7, 9, 11},
            (a, b) -> a + b,
            () -> 0);

        assertEquals(24, tree.execute(1, 4).intValue());
        assertEquals(3, tree.execute(1, 1).intValue());
        assertEquals(36, tree.execute(0, 5).intValue());
        assertEquals(1, tree.execute(0, 0).intValue());
    }

    @Test
    public void testMinRange() {
        SegmentTree<Integer> tree = new SegmentTree<>(
            new Integer[]{3, 1, 4, 6, 2, 7},
            (a, b) -> Math.min(a, b),
            () -> Integer.MAX_VALUE);

        assertEquals(1, tree.execute(1, 4).intValue());
        assertEquals(1, tree.execute(1, 1).intValue());
        assertEquals(1, tree.execute(0, 5).intValue());
        assertEquals(3, tree.execute(0, 0).intValue());
        assertEquals(2, tree.execute(3, 5).intValue());
    }

    @Test
    public void testMaxRange() {
        SegmentTree<Integer> tree = new SegmentTree<>(
            new Integer[]{3, 1, 4, 6, 2, 7},
            (a, b) -> Math.max(a, b),
            () -> Integer.MIN_VALUE);

        assertEquals(6, tree.execute(1, 4).intValue());
        assertEquals(1, tree.execute(1, 1).intValue());
        assertEquals(7, tree.execute(0, 5).intValue());
        assertEquals(3, tree.execute(0, 0).intValue());
        assertEquals(7, tree.execute(3, 5).intValue());
    }
}