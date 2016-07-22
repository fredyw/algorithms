package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableTest {
    @Test
    public void test() {
        HashTable<String, Integer> ht = new HashTable<>();
        ht.put("e", 1);
        ht.put("b", 2);
        ht.put("c", 3);
        ht.put("c", 30);
        ht.put("d", 4);
        ht.put("a", 5);
        ht.put("h", 6);
        ht.put("f", 7);
        ht.put("g", 8);

        assertEquals(8, ht.getSize());

        assertEquals(new Integer(1), ht.get("e"));
        assertEquals(new Integer(2), ht.get("b"));
        assertEquals(new Integer(30), ht.get("c"));
        assertEquals(new Integer(4), ht.get("d"));
        assertEquals(new Integer(5), ht.get("a"));
        assertEquals(new Integer(6), ht.get("h"));
        assertEquals(new Integer(7), ht.get("f"));
        assertEquals(new Integer(8), ht.get("g"));
        assertNull(ht.get("i"));
    }
}
