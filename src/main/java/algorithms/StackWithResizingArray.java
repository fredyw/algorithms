package algorithms;

public class StackWithResizingArray<T> {
    private ResizingArray<T> array = new ResizingArray<>(10); // initial size
    
    public T pop() {
        return array.removeBack();
    }
    
    public void push(T item) {
        array.add(item);
    }
}
