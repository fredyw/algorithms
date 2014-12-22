package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickWeightedUnion<T> {
    private Map<T, T> map = new HashMap<>();
    private Map<T, Integer> children = new HashMap<>();
    
    public void union(T a, T b) {
        if (!map.containsKey(a)) {
            map.put(a, a);
            children.put(a, 1);
        }
        if (!map.containsKey(b)) {
            map.put(b, b);
            children.put(b, 1);
        }
        T aVal = find(a);
        T bVal = find(b);
        if (!aVal.equals(bVal)) {
            if (children.get(aVal) > children.get(bVal)) {
                map.put(bVal, aVal);
                children.put(bVal, children.get(bVal)+1);
            } else {
                map.put(aVal, bVal);
                children.put(bVal, children.get(aVal)+1);
            }
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
        return x.equals(y);
    }
}
