package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickFind<T> {
    private Map<T, T> map = new HashMap<>();
    
    public void union(T a, T b) {
        if (!map.containsKey(a)) {
            map.put(a, a);
        }
        if (!map.containsKey(b)) {
            map.put(b, b);
        }
        if (!connected(a, b)) {
            T value = map.get(a);
            for (Map.Entry<T, T> e : map.entrySet()) {
                if (e.getValue().equals(value)) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }
    }
    
    private T find(T a) {
        return map.get(a);
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
