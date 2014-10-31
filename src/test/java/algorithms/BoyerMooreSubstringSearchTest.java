package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoyerMooreSubstringSearchTest {
    @Test
    public void test() {
        assertEquals(1, BoyerMooreSubstringSearch.substring("hel", "hhelo"));
        assertEquals(0, BoyerMooreSubstringSearch.substring("hello", "hello world"));
        assertEquals(2, BoyerMooreSubstringSearch.substring("llo", "hello world"));
        assertEquals(5, BoyerMooreSubstringSearch.substring(" ", "hello world"));
        assertEquals(0, BoyerMooreSubstringSearch.substring("hello world", "hello world"));
        assertEquals(-1, BoyerMooreSubstringSearch.substring("word", "hello world"));
        assertEquals(-1, BoyerMooreSubstringSearch.substring("foo", "hello world"));
        assertEquals(-1, BoyerMooreSubstringSearch.substring("hello world1", "hello world"));
    }
}
