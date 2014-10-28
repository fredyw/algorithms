package algorithms;

public class RabinKarpSubstringSearch {
    private static final int R = 10; // radix
    private static final int Q = 997; // some prime number
    
    private static long hash(String key, int size) {
        long h = 0;
        for (int i = 0; i < size; i++) {
            h = hash(h, key.charAt(i));
        }
        return h;
    }
    
    private static long hash(long hashValue, int value) {
        return ((hashValue * R) + value) % Q;
    }
    
    private static long removeLeadingDigit(int size) {
        long value = 0;
        for (int i = 1; i <= size-1; i++) {
            value = (R * value) % Q;
        }
        return value;
    }
    
    public static int substring(String pattern, String text) {
        // this uses Horner's hashing method
        long patternHash = hash(pattern, pattern.length());
        long textHash = 0;
        long rld = removeLeadingDigit(pattern.length());
        for (int i = 0; i < text.length(); i++) {
            // remove leading digit
            textHash = (textHash + Q - rld * text.charAt(i-pattern.length()) % Q) % Q;
            // add trailing digit
            textHash = hash(textHash, text.charAt(i));
            if (patternHash == textHash) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }
}
