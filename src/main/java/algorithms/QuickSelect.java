package algorithms;

import java.util.Random;

public class QuickSelect {
    public static <T extends Comparable<T>> T select(T[] array, int n) {
        shuffle(array);
        return select(array, 0, array.length - 1, n - 1);
    }

    private static <T extends Comparable<T>> T select(T[] array, int lo, int hi, int n) {
        if (lo >= hi) {
            return array[n];
        } else {
            int p = partition(array, lo, hi);
            if (p == n) {
                return array[n];
            } else if (p > n) {
                return select(array, lo, hi - 1, n);
            } else {
                return select(array, p + 1, hi, n);
            }
        }
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

    private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
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
