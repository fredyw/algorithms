package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RabinKarpSubstringSearchTest {
    @Test
    public void test() {
        assertEquals(1, RabinKarpSubstringSearch.substring("hel", "hhelo"));
        assertEquals(0, RabinKarpSubstringSearch.substring("hello", "hello world"));
        assertEquals(2, RabinKarpSubstringSearch.substring("llo", "hello world"));
        assertEquals(5, RabinKarpSubstringSearch.substring(" ", "hello world"));
        assertEquals(0, RabinKarpSubstringSearch.substring("hello world", "hello world"));
        assertEquals(-1, RabinKarpSubstringSearch.substring("word", "hello world"));
        assertEquals(-1, RabinKarpSubstringSearch.substring("foo", "hello world"));
        assertEquals(-1, RabinKarpSubstringSearch.substring("hello world1", "hello world"));
    }
}
