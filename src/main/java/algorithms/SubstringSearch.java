package algorithms;

public class SubstringSearch {
    public static int substring(String pattern, String string) {
        // this is the brute-force solution for substring problem
        for (int i = 0; i < string.length(); i++) {
            int j = 0;
            boolean found = true;
            for (j = 0; j < pattern.length(); j++) {
                if (i+j >= string.length()) {
                    return -1;
                }
                if (string.charAt(i+j) != pattern.charAt(j)) {
                    found = false;
                    i += j;
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
