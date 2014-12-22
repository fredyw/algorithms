package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion<T> {
    private Map<T, T> map = new HashMap<>();
    
    public void union(T a, T b) {
        if (!map.containsKey(a)) {
            map.put(a, a);
        }
        if (!map.containsKey(b)) {
            map.put(b, b);
        }
        T aVal = find(a);
        T bVal = find(b);
        if (!aVal.equals(bVal)) {
            map.put(aVal, bVal);
        }
    }
    
    private T find(T a) {
        T key = a;
        T value = map.get(key);
        while (!key.equals(value)) {
            key = value;
            value = map.get(key);
        }
        return value;
    }
    
    public boolean connected(T a, T b) {
        T x = find(a);
        T y = find(b);
        if (x == null || y == null) {
            return false;
        }
        return find(a).equals(find(b));
    }
}
