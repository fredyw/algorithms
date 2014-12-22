package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickFindTest {
    @Test
    public void test() {
        QuickFind<String> qf = new QuickFind<>();
        qf.union("a", "b");
        qf.union("b", "c");
        qf.union("d", "e");
        qf.union("d", "f");
        
        assertTrue(qf.connected("a", "b"));
        assertTrue(qf.connected("a", "c"));
        assertTrue(qf.connected("b", "c"));
        
        assertTrue(qf.connected("d", "e"));
        assertTrue(qf.connected("e", "f"));
        assertTrue(qf.connected("d", "f"));
        
        assertFalse(qf.connected("a", "d"));
        assertFalse(qf.connected("b", "f"));
    }
}
