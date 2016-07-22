package algorithms;

public class LSDRadixSort {
    public static void sort(String[] strings, int stringLength, int numCharacters) {
        // start from the right to the left
        for (int i = stringLength - 1; i >= 0; i--) {
            String[] aux = new String[strings.length];
            int[] count = new int[numCharacters];

            // compute frequency counts
            for (int j = 0; j < strings.length; j++) {
                int newIdx = strings[j].charAt(i) + 1;
                count[newIdx]++;
            }

            // transform counts to indicies
            for (int j = 1; j < numCharacters; j++) {
                count[j] += count[j - 1];
            }

            // distribute
            for (int j = 0; j < strings.length; j++) {
                int value = strings[j].charAt(i);
                int idx = count[value];

                aux[idx] = strings[j];
                count[value]++;
            }

            // copy back
            for (int j = 0; j < aux.length; j++) {
                strings[j] = aux[j];
            }
        }
    }
}
