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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            result = prime * result + value;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Element other = (Element) obj;
            if (key == null) {
                if (other.key != null) {
                    return false;
                }
            } else if (!key.equals(other.key)) {
                return false;
            }
            if (value != other.value) {
                return false;
            }
            return true;
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
