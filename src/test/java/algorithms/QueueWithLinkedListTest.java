package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueWithLinkedListTest {

    @Test
    public void test() {
        QueueWithLinkedList<Integer> queue = new QueueWithLinkedList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }
}
