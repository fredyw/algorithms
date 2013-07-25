package algorithms;

public class StackWithLinkedList<T> {
    private LinkedList<T> linkedList = new LinkedList<>();
    
    public T pop() {
        return linkedList.removeFront();
    }
    
    public void push(T item) {
        linkedList.addFront(item);
    }
}
