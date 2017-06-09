package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTreeTest {
    @Test
    public void test() {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
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
    
    @Test
    public void testCeiling() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree();
        bst.put(60, 60);
        bst.put(30, 30);
        bst.put(70, 70);
        bst.put(10, 10);
        bst.put(40, 40);
        bst.put(80, 80);
        bst.put(20, 20);
        bst.put(50, 50);

        int ceiling = bst.ceiling(31);
        assertEquals(40, ceiling);

        ceiling = bst.ceiling(69);
        assertEquals(70, ceiling);

        ceiling = bst.ceiling(30);
        assertEquals(40, ceiling);

        ceiling = bst.ceiling(10);
        assertEquals(20, ceiling);

        ceiling = bst.ceiling(9);
        assertEquals(10, ceiling);

        ceiling = bst.ceiling(11);
        assertEquals(20, ceiling);
    }
}
