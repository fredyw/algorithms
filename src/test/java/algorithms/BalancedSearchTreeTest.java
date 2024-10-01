package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

        assertEquals(Integer.valueOf(1), bst.get("e"));
        assertEquals(Integer.valueOf(2), bst.get("b"));
        assertEquals(Integer.valueOf(30), bst.get("c"));
        assertEquals(Integer.valueOf(4), bst.get("d"));
        assertEquals(Integer.valueOf(5), bst.get("a"));
        assertEquals(Integer.valueOf(6), bst.get("h"));
        assertEquals(Integer.valueOf(7), bst.get("f"));
        assertEquals(Integer.valueOf(8), bst.get("g"));

        assertEquals("[4, 30, 7, 1]", bst.get("c", "f").toString());

        assertEquals(8, bst.getSize());
    }
}
