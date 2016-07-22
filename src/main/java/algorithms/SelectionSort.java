package algorithms;

public class SelectionSort {
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = -1;
            for (int j = i; j < array.length; j++) {
                if (min == -1 || array[j].compareTo(array[min]) < 0) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }
}
