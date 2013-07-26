package algorithms;

public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    
    public static class Node<T> {
        private Node<T> next;
        private T item;
        
        public Node(T item) {
            this.item = item;
        }
    }
    
    public void addFront(T item) {
        if (first == null) {
            first = new Node<T>(item);
            last = first;
        } else {
            Node<T> oldFirst = first;
            first = new Node<T>(item);
            first.next = oldFirst;
        }
    }
    
    public T removeFront() {
        if (first == null) {
            return null;
        }
        T t = first.item;
        first = first.next;
        return t;
    }
    
    public void addBack(T item) {
        if (last == null) {
            first = new Node<T>(item);
            last = first;
        } else {
            last.next = new Node<T>(item);
            last = last.next;
        }
    }
}
