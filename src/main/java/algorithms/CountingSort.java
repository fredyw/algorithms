package algorithms;

public class CountingSort {
    public static void sort(int[] array, int size) {
        int[] aux = new int[array.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = array[i];
        }
        int[] count = new int[size];
        for (int i = 0; i < aux.length; i++) {
            count[aux[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        for (int i = aux.length - 1; i >= 0; i--) {
            int val = aux[i];
            count[val]--;
            int idx = count[val];
            array[idx] = val;
        }
    }
}
