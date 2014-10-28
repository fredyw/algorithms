package algorithms;

public class SubstringSearch {
    public static int substring(String pattern, String text) {
        // this is the brute-force solution for substring problem
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            boolean found = true;
            for (j = 0; j < pattern.length(); j++) {
                if (i+j >= text.length()) {
                    return -1;
                }
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
