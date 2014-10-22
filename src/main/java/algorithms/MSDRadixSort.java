package algorithms;

public class MSDRadixSort {
    public static void sort(String[] strings, int numCharacters) {
        int n = strings.length;
        String[] aux = new String[n];
        sort(strings, 0, n-1, 0, aux, numCharacters);
    }

    private static int charAt(String s, int i) {
        if (i == s.length()) {
            return -1;
        }
        return s.charAt(i);
    }

    private static void sort(String[] strings, int lo, int hi, int strIdx, String[] aux,
        int numCharacters) {
        // start from the left to the right
        
        if (hi <= lo) {
            return;
        }

        // compute frequency counts
        int[] count = new int[numCharacters+2];
        for (int i = lo; i <= hi; i++) {
            int newIdx = charAt(strings[i], strIdx);
            count[newIdx+2]++;
        }

        // transform counts to indicies
        for (int i = 0; i < numCharacters+1; i++) {
            count[i+1] += count[i];
        }

        // distribute
        for (int i = lo; i <= hi; i++) {
            int value = charAt(strings[i], strIdx);
            int idx = count[value+1];
            
            aux[idx] = strings[i];
            count[value+1]++;
        }

        // copy back
        for (int i = lo; i <= hi; i++) {
            strings[i] = aux[i-lo];
        }

        // recursively sort for each character
        for (int i = 0; i < numCharacters; i++) {
            sort(strings, lo+count[i], lo+count[i+1]-1, strIdx+1, aux, numCharacters);
        }
    }
}
