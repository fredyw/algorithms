package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UndirectedGraph<T> {
    private Map<T, Set<T>> vertices = new HashMap<>();
    
    public Set<T> getVertices() {
        return vertices.keySet();
    }
    
    public Set<T> adjacent(T node) {
        if (!vertices.containsKey(node)) {
            return null;
        }
        return vertices.get(node);
    }
    
    public void add(T node1, T node2) {
        if (!vertices.containsKey(node1)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(node2);
            vertices.put(node1, newSet);
        } else {
            vertices.get(node1).add(node2);
        }
        
        if (!vertices.containsKey(node2)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(node1);
            vertices.put(node2, newSet);
        } else {
            vertices.get(node2).add(node1);
        }
    }
}
