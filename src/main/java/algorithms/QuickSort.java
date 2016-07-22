package algorithms;

import java.util.Random;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(array, lo, hi);
        sort(array, lo, p - 1);
        sort(array, p + 1, hi);
    }

    private static <T extends Comparable<T>> void shuffle(T[] array) {
        Random r = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, r.nextInt(i));
        }
    }

    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
        int left = lo;
        int right = hi + 1;
        while (true) {
            while (array[++left].compareTo(array[lo]) <= 0) {
                if (left == hi) {
                    break;
                }
            }
            while (array[--right].compareTo(array[lo]) >= 0) {
                if (right == lo) {
                    break;
                }
            }
            if (left >= right) {
                break;
            }
            swap(array, left, right);
        }
        swap(array, lo, right);
        return right;
    }
}
