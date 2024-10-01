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

        assertEquals(Integer.valueOf(1), ht.get("e"));
        assertEquals(Integer.valueOf(2), ht.get("b"));
        assertEquals(Integer.valueOf(30), ht.get("c"));
        assertEquals(Integer.valueOf(4), ht.get("d"));
        assertEquals(Integer.valueOf(5), ht.get("a"));
        assertEquals(Integer.valueOf(6), ht.get("h"));
        assertEquals(Integer.valueOf(7), ht.get("f"));
        assertEquals(Integer.valueOf(8), ht.get("g"));
        assertNull(ht.get("i"));
    }
}
