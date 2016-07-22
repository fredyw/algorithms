package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ResizingArrayTest {
    @Test
    public void test1() {
        ResizingArray<Integer> array = new ResizingArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals(Integer.valueOf(1), array.removeFront());
        assertEquals(Integer.valueOf(2), array.removeFront());
        assertEquals(Integer.valueOf(3), array.removeFront());
        assertEquals(Integer.valueOf(4), array.removeFront());
        assertEquals(Integer.valueOf(5), array.removeFront());
        assertNull(array.removeFront());
    }

    @Test
    public void test2() {
        ResizingArray<Integer> array = new ResizingArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals(Integer.valueOf(5), array.removeBack());
        assertEquals(Integer.valueOf(4), array.removeBack());
        assertEquals(Integer.valueOf(3), array.removeBack());
        assertEquals(Integer.valueOf(2), array.removeBack());
        assertEquals(Integer.valueOf(1), array.removeBack());
        assertNull(array.removeBack());
    }

    @Test
    public void test3() {
        ResizingArray<Integer> array = new ResizingArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals(Integer.valueOf(1), array.removeFront());
        assertEquals(Integer.valueOf(2), array.removeFront());
        assertEquals(Integer.valueOf(5), array.removeBack());
        assertEquals(Integer.valueOf(3), array.removeFront());
        assertEquals(Integer.valueOf(4), array.removeBack());
        assertNull(array.removeBack());
        assertNull(array.removeFront());
    }

    @Test
    public void test4() {
        ResizingArray<Integer> array = new ResizingArray<>(2);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        assertEquals(Integer.valueOf(1), array.removeFront());
        assertEquals(Integer.valueOf(2), array.removeFront());
        assertEquals(Integer.valueOf(5), array.removeBack());
        assertEquals(Integer.valueOf(3), array.removeFront());
        assertEquals(Integer.valueOf(4), array.removeBack());
        assertNull(array.removeBack());
        assertNull(array.removeFront());

    }
}
