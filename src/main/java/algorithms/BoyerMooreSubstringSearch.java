package algorithms;


public class BoyerMooreSubstringSearch {
    private static final int R = 256; // assume 256 characters.

    public static int substring(String pattern, String text) {
        int[] right = new int[R];
        for (int i = 0; i < R; i++) {
            // not in the pattern
            // this -1 value isn't an arbitrary value, this is required to move
            // the pattern one more step to the right,
            // see skip = j - right[text.charAt(i+j)];
            right[i] = -1;
        }
        for (int i = 0; i < pattern.length(); i++) {
            right[pattern.charAt(i)] = i; // rightmost position
        }
        int skip = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i += skip) {
            skip = 0;
            for (int j = pattern.length() - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) {
                        skip = 1;
                    }
                    break;
                }
            }
            if (skip == 0) {
                return i;
            }
        }
        return -1;
    }
}