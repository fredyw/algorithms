package algorithms;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;
        for (int i = ((int) Math.ceil(n/2.0))-1; i >= 0; i--) {
            sink(array, i, n);
        }
        while (n > 0) {
            swap(array, 0, n-1);
            n--;
            sink(array, 0, n);
        }
    }
    
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
    private static <T extends Comparable<T>> void sink(T[] array, int idx, int n) {
        int i = idx;
        while ((i*2)+1 < n) {
            int child = (i * 2) + 1;
            // do comparison only if there are two children
            if ((i*2)+2 < n) {
                // left child is bigger than right child
                if (array[(i*2)+1].compareTo(array[(i*2)+2]) > 0) {
                    child = (i * 2) + 1;
                } else {
                    child = (i * 2) + 2;
                }
            }
            if (array[i].compareTo(array[child]) < 0) {
                swap(array, i, child);
            }
            i = child;
        }
    }
}
