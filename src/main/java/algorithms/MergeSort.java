package algorithms;

public class MergeSort {
    public static <T extends Object & Comparable<T>> void sort(T[] array) {
        T[] aux = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            aux[i] = array[i];
        }
        sort(array, 0, array.length - 1, aux);
    }

    private static <T extends Object & Comparable<T>> void sort(T[] array, int lo, int hi, T[] aux) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(aux, lo, mid, array);
        sort(aux, mid + 1, hi, array);
        merge(array, lo, mid, hi, aux);
    }

    @SuppressWarnings("unchecked")
    static <T extends Object & Comparable<T>> void merge(T[] array, int lo, int mid, int hi,
                                                         T[] aux) {
        int idx = lo;
        int lo1 = lo;
        int hi1 = mid;
        int lo2 = mid + 1;
        int hi2 = hi;
        while (lo1 <= hi1 && lo2 <= hi2) {
            if (aux[lo1].compareTo(aux[lo2]) < 0) {
                array[idx++] = aux[lo1++];
            } else {
                array[idx++] = aux[lo2++];
            }
        }
        while (lo1 <= hi1) {
            array[idx++] = aux[lo1++];
        }
        while (lo2 <= hi2) {
            array[idx++] = aux[lo2++];
        }
    }
}
