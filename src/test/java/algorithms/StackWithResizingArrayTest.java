package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackWithResizingArrayTest {

    @Test
    public void test() {
        StackWithResizingArray<Integer> stack = new StackWithResizingArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }
}
