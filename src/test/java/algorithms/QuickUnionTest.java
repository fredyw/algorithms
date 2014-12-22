package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickUnionTest {
    @Test
    public void test() {
        QuickUnion<String> qu = new QuickUnion<>();
        qu.union("a", "b");
        qu.union("b", "c");
        qu.union("d", "e");
        qu.union("d", "f");
        
        assertTrue(qu.connected("a", "b"));
        assertTrue(qu.connected("a", "c"));
        assertTrue(qu.connected("b", "c"));
        
        assertTrue(qu.connected("d", "e"));
        assertTrue(qu.connected("e", "f"));
        assertTrue(qu.connected("d", "f"));
        
        assertFalse(qu.connected("a", "d"));
        assertFalse(qu.connected("b", "f"));
    }
}
