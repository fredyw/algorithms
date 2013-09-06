package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class BalancedSearchTreeTest {
    @Test
    public void test() {
        BalancedSearchTree<String, Integer> bst = new BalancedSearchTree<>();
        bst.put("e", 1);
        bst.put("b", 2);
        bst.put("c", 3);
        bst.put("c", 30);
        bst.put("d", 4);
        bst.put("a", 5);
        bst.put("h", 6);
        bst.put("f", 7);
        bst.put("g", 8);
        
        assertEquals(new Integer(1), bst.get("e"));
        assertEquals(new Integer(2), bst.get("b"));
        assertEquals(new Integer(30), bst.get("c"));
        assertEquals(new Integer(4), bst.get("d"));
        assertEquals(new Integer(5), bst.get("a"));
        assertEquals(new Integer(6), bst.get("h"));
        assertEquals(new Integer(7), bst.get("f"));
        assertEquals(new Integer(8), bst.get("g"));
        
        assertEquals("[4, 30, 7, 1]", bst.get("c", "f").toString());
        
        assertEquals(8, bst.getSize());
    }
}
