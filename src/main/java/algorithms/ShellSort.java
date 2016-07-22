package algorithms;

public class ShellSort {
    private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int h = 1;
        while (h < array.length / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i - h; j >= 0 && array[j].compareTo(array[j + h]) > 0; j -= h) {
                    swap(array, j, j + h);
                }
            }
            h = h / 3;
        }
    }
}
