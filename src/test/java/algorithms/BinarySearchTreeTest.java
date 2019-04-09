package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

        assertNull(bst.ceiling(90));

        assertNull(bst.ceiling(80));
    }

    @Test
    public void testFloor() {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree();
        bst.put(60, 60);
        bst.put(30, 30);
        bst.put(70, 70);
        bst.put(10, 10);
        bst.put(40, 40);
        bst.put(80, 80);
        bst.put(20, 20);
        bst.put(50, 50);

        int floor = bst.floor(31);
        assertEquals(30, floor);

        floor = bst.floor(69);
        assertEquals(60, floor);

        floor = bst.floor(30);
        assertEquals(20, floor);

        assertNull(bst.floor(10));

        floor = bst.floor(11);
        assertEquals(10, floor);

        assertNull(bst.floor(9));
    }
}
