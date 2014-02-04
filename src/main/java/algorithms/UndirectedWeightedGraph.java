package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UndirectedWeightedGraph<T> {
    private Map<Vertex<T>, Set<Vertex<T>>> vertices = new HashMap<>();
    
    public static class Vertex<T> {
        private int weight;
        private T t;
        
        public Vertex(T t, int weight) {
            this.t = t;
            this.weight = weight;
        }
        
        public Vertex(T t) {
            this(t, 0);
        }

        public T getVertex() {
            return t;
        }
        
        public int getWeight() {
            return weight;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((t == null) ? 0 : t.hashCode());
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
            Vertex<?> other = (Vertex<?>) obj;
            if (t == null) {
                if (other.t != null) {
                    return false;
                }
            } else if (!t.equals(other.t)) {
                return false;
            }
            return true;
        }
    }
    
    public Set<Vertex<T>> getVertices() {
        return vertices.keySet();
    }
    
    public Set<Vertex<T>> adjacent(Vertex<T> vertex) {
        if (!vertices.containsKey(vertex)) {
            return new HashSet<>();
        }
        return vertices.get(vertex);
    }
    
    public void add(Vertex<T> vertex1, Vertex<T> vertex2) {
        if (!vertices.containsKey(vertex1)) {
            Set<Vertex<T>> newSet = new HashSet<>();
            newSet.add(vertex2);
            vertices.put(vertex1, newSet);
        } else {
            vertices.get(vertex1).add(vertex2);
        }
        
        if (!vertices.containsKey(vertex2)) {
            Set<Vertex<T>> newSet = new HashSet<>();
            newSet.add(vertex1);
            vertices.put(vertex2, newSet);
        } else {
            vertices.get(vertex2).add(vertex1);
        }
    }
}
