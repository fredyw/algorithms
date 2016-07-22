package algorithms;

public class InsertionSort {
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j].compareTo(array[j + 1]) > 0; j--) {
                swap(array, j, j + 1);
            }
        }
    }
}
