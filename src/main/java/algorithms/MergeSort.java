package algorithms;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length-1);
    }
    
    private static <T extends Comparable<T>> void sort(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(array, lo, mid);
        sort(array, mid+1, hi);
        merge(array, lo, mid, hi);
    }
    
    @SuppressWarnings("unchecked")
    static <T extends Object & Comparable<T>> void merge(T[] array,
        int lo, int mid, int hi) {
        T[] aux = (T[]) new Object[hi-lo+1];
        for (int i = lo, j = 0; i <= hi; i++, j++) {
            aux[j] = array[i];
        }
        int idx = lo;
        int lo1 = 0;
        int hi1 = mid - lo;
        int lo2 = hi1 + 1;
        int hi2 = aux.length;
        while (lo1 < hi1+1 && lo2 < hi2) {
            if (aux[lo1].compareTo((T) aux[lo2]) < 0) {
                array[idx++] = (T) aux[lo1++];
            } else {
                array[idx++] = (T) aux[lo2++];
            }
        }
        while (lo1 < hi1+1) {
            array[idx++] = (T) aux[lo1++];
        }
        while (lo2 < hi2) {
            array[idx++] = (T) aux[lo2++];
        }
    }
}
