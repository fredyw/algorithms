package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<T extends Comparable<T>> {
    private boolean descending;
    private List<T> list = new ArrayList<>();
    
    public PriorityQueue(boolean descending) {
        this.descending = descending;
        // use 1-based index for easier calculation
        list.add(null);
    }
    
    public void insert(T item) {
        list.add(item);
        swim(size());
    }
    
    public T remove() {
        T item = list.get(1);
        swap(1, size());
        list.remove(size());
        sink(1);
        return item;
    }
    
    public int size() {
        return list.size() - 1;
    }
    
    private void swap(int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    
    private void sink(int idx) {
        int i = idx;
        while (i*2 <= size()) {
            int child = i * 2;
            // do comparison only if there are two children
            if ((i*2)+1 <= size()) {
                if (descending) {
                    // right child is bigger than left child
                    if (list.get(i*2).compareTo(list.get((i*2)+1)) < 0) {
                        child = i * 2;
                    } else {
                        child = (i * 2) + 1;
                    }
                } else {
                    // left child is bigger than right child
                    if (list.get(i*2).compareTo(list.get((i*2)+1)) > 0) {
                        child = i * 2;
                    } else {
                        child = (i * 2) + 1;
                    }
                }
            }
            if (descending) {
                if (list.get(i).compareTo(list.get(child)) > 0) {
                    swap(i, child);
                }
            } else {
                if (list.get(i).compareTo(list.get(child)) < 0) {
                    swap(i, child);
                }
            }
            i = child;
        }
    }
    
    private void swim(int idx) {
        int i = idx;
        while (i > 1) {
            if (descending) {
                if (list.get(i).compareTo(list.get(i/2)) < 0) {
                    swap(i, i/2);
                }
            } else {
                if (list.get(i).compareTo(list.get(i/2)) > 0) {
                    swap(i, i/2);
                }
            }
            i /= 2;
        }
    }
}
