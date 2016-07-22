package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueWithResizingArrayTest {
    @Test
    public void test() {
        QueueWithResizingArray<Integer> queue = new QueueWithResizingArray<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());
    }
}
