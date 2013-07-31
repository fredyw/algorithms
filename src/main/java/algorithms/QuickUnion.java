package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickUnion {
    private Map<String, String> map = new HashMap<>();
    
    public void union(String a, String b) {
        if (!map.containsKey(a)) {
            map.put(a, a);
        }
        if (!map.containsKey(b)) {
            map.put(b, b);
        }
        String aVal = find(a);
        String bVal = find(b);
        if (!aVal.equals(bVal)) {
            map.put(aVal, bVal);
        }
    }
    
    private String find(String a) {
        String key = a;
        String value = map.get(key);
        while (!key.equals(value)) {
            key = value;
            value = map.get(key);
        }
        return value;
    }
    
    public boolean connected(String a, String b) {
        return find(a).equals(find(b));
    }
}
