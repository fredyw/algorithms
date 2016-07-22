package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickWeightedUnionTest {
    @Test
    public void test() {
        QuickWeightedUnion<String> qwu = new QuickWeightedUnion<>();
        qwu.union("a", "b");
        qwu.union("b", "c");
        qwu.union("d", "e");
        qwu.union("d", "f");

        assertTrue(qwu.connected("a", "b"));
        assertTrue(qwu.connected("a", "c"));
        assertTrue(qwu.connected("b", "c"));

        assertTrue(qwu.connected("d", "e"));
        assertTrue(qwu.connected("e", "f"));
        assertTrue(qwu.connected("d", "f"));

        assertFalse(qwu.connected("a", "d"));
        assertFalse(qwu.connected("b", "f"));
    }
}
