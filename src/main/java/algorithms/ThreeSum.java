package algorithms;

import java.util.Arrays;

/**
 * Problem: count the number of triples that sum to 0
 */
public class ThreeSum {
    public static int[] solve(Integer[] array) {
        int[] result = new int[3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                int idx = BinarySearch.search(
                    Arrays.asList(array), -(array[i] + array[j]));
                if (idx != -1) {
                    result[0] = array[i];
                    result[1] = array[j];
                    result[2] = array[idx];
                    return result;
                }
            }
        }
        return result;
    }
}
