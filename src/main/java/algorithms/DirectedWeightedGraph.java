package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DirectedWeightedGraph<T> {
    private Map<T, Set<Edge<T>>> vertices = new HashMap<>();

    public static class Edge<T> {
        private double weight;
        private T t1;
        private T t2;
        
        public Edge(T t1, T t2, double weight) {
            this.t1 = t1;
            this.t2 = t2;
            this.weight = weight;
        }
        
        public double getWeight() {
            return weight;
        }
        
        public T from() {
            return t1;
        }
        
        public T to() {
            return t2;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
            result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
            return result;
        }

        @SuppressWarnings("unchecked")
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
            Edge<T> other = (Edge<T>) obj;
            if (t1 == null) {
                if (other.t1 != null) {
                    return false;
                }
            } else if (!t1.equals(other.t1)) {
                return false;
            }
            if (t2 == null) {
                if (other.t2 != null) {
                    return false;
                }
            } else if (!t2.equals(other.t2)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(t1).append("->").append(t2).append(" ").append(weight);
            return sb.toString();
        }
    }
    
    public Set<T> getVertices() {
        return vertices.keySet();
    }
    
    public Set<Edge<T>> adjacent(T t) {
        if (!vertices.containsKey(t)) {
            return new HashSet<>();
        }
        return vertices.get(t);
    }
    
    public void add(Edge<T> edge) {
        if (!vertices.containsKey(edge.from())) {
            Set<Edge<T>> newSet = new HashSet<>();
            newSet.add(edge);
            vertices.put(edge.from(), newSet);
        } else {
            vertices.get(edge.from()).add(edge);
        }
    }
    
    public static class ShortestPath<T> {
//        public ShortestPath(DirectedWeightedGraph<T> graph, T source) {
//            
//        }
//        
//        public double distTo(T target) {
//            
//        }
//        
//        public boolean hasPathTo(T target) {
//            
//        }
//        
//        public List<T> pathTo(T target) {
//            
//        }
    }
}
