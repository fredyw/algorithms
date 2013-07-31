package algorithms;

import java.util.HashMap;
import java.util.Map;

public class QuickFind {
    private Map<String, Integer> map = new HashMap<>();
    private int idx;
    
    public void union(String a, String b) {
        if (!map.containsKey(a)) {
            map.put(a, idx++);
        }
        if (!map.containsKey(b)) {
            map.put(b, idx++);
        }
        if (!connected(a, b)) {
            Integer idx = map.get(a);
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue().equals(idx)) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }
    }
    
    public boolean connected(String a, String b) {
        return map.get(a).equals(map.get(b));
    }
}
