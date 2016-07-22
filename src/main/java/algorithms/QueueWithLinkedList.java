package algorithms;

public class QueueWithLinkedList<T> {
    private LinkedList<T> linkedList = new LinkedList<>();

    public void enqueue(T item) {
        linkedList.addBack(item);
    }

    public T dequeue() {
        return linkedList.removeFront();
    }
}
