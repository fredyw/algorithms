package algorithms;

public class LSDRadixSort {
    public static void sort(String[] strings, int stringLength, int numValues) {
        for (int i = stringLength-1; i >= 0; i--) {
            String[] aux = new String[strings.length];
            int[] count = new int[numValues];

            for (int j = 0; j < strings.length; j++) {
                int newIdx = strings[j].charAt(i) + 1;
                count[newIdx] += 1;
            }

            for (int j = 1; j < numValues; j++) {
                count[j] += count[j-1];
            }

            for (int j = 0; j < strings.length; j++) {
                int value = strings[j].charAt(i);
                int idx = count[value];

                aux[idx] = strings[j];
                count[value]++;
            }

            for (int j = 0; j < aux.length; j++) {
                strings[j] = aux[j];
            }
        }
    }
}
