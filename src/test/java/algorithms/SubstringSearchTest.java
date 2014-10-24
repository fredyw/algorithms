package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringSearchTest {
    @Test
    public void test() {
        assertEquals(0, SubstringSearch.substring("hello", "hello world"));
        assertEquals(2, SubstringSearch.substring("llo", "hello world"));
        assertEquals(5, SubstringSearch.substring(" ", "hello world"));
        assertEquals(0, SubstringSearch.substring("hello world", "hello world"));
        assertEquals(-1, SubstringSearch.substring("word", "hello world"));
        assertEquals(-1, SubstringSearch.substring("foo", "hello world"));
        assertEquals(-1, SubstringSearch.substring("hello world1", "hello world"));
    }
}
