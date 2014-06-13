package algorithms;

public class KeyIndexedCounting {
    public static class Element {
        public final String key;
        public final int value;
        
        public Element(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Element [key=");
            builder.append(key);
            builder.append(", value=");
            builder.append(value);
            builder.append("]");
            return builder.toString();
        }
    }
    
    public static void sort(Element[] elements, int numValues) {
        Element[] aux = new Element[elements.length];
        int[] count = new int[numValues];
        
        for (int i = 0; i < elements.length; i++) {
            int newIdx = elements[i].value + 1;
            count[newIdx] += 1;
        }
        
        for (int i = 1; i < numValues; i++) {
            count[i] += count[i-1];
        }
        
        for (int i = 0; i < elements.length; i++) {
            int value = elements[i].value;
            int idx = count[value];
            
            aux[idx] = elements[i];
            count[value]++;
        }
        
        for (int i = 0; i < aux.length; i++) {
            elements[i] = aux[i];
        }
    }
}
