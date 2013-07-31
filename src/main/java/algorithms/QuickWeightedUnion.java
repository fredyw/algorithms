package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickWeightedUnion {
    private Map<String, String> map = new HashMap<>();
    private Map<String, Integer> children = new HashMap<>();
    
    public void union(String a, String b) {
        if (!map.containsKey(a)) {
            map.put(a, a);
            children.put(a, 1);
        }
        if (!map.containsKey(b)) {
            map.put(b, b);
            children.put(b, 1);
        }
        String aVal = find(a);
        String bVal = find(b);
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
