package algorithms;

public class QueueWithResizingArray<T> {
    private ResizingArray<T> array = new ResizingArray<>(10); // initial size

    public void enqueue(T item) {
        array.add(item);
    }

    public T dequeue() {
        return array.removeFront();
    }
}
