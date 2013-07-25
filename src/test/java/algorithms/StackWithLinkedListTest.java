package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackWithLinkedListTest {

    @Test
    public void test() {
        StackWithLinkedList<Integer> stack = new StackWithLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }
}
