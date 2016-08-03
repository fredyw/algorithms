package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
    @Test
    public void editDistance() {
        assertEquals(2, EditDistance.editDistance("hello", "holla"));
        assertEquals(6, EditDistance.editDistance("hello", "hello world"));
        assertEquals(3, EditDistance.editDistance("abc", "xyz"));
        assertEquals(3, EditDistance.editDistance("abcdef", "axdf"));
    }
}