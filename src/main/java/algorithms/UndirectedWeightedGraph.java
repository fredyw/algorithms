package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class UndirectedWeightedGraph<T> {
    private Map<T, Set<Edge<T>>> vertices = new HashMap<>();
    
    public static class Edge<T> implements Comparable<T> {
        private double weight;
        private T t1;
        private T t2;
        
        public Edge(T t1, T t2, double weight) {
            this.t1 = t1;
            this.t2 = t2;
            this.weight = weight;
        }

        public T either() {
            return t1;
        }
        
        public T other(T t) {
            if (!t.equals(t1)) {
                return t1;
            }
            return t2;
        }
        
        public double getWeight() {
            return weight;
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

        @SuppressWarnings("unchecked")
        @Override
        public int compareTo(T o) {
            return Double.valueOf(weight).compareTo(((Edge<T>) o).weight);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(t1).append("-").append(t2).append(" ").append(weight);
            return builder.toString();
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
        T t1 = edge.either();
        if (!vertices.containsKey(t1)) {
            Set<Edge<T>> newSet = new HashSet<>();
            newSet.add(edge);
            vertices.put(t1, newSet);
        } else {
            vertices.get(t1).add(edge);
        }
        
        T t2 = edge.other(t1);
        if (!vertices.containsKey(t2)) {
            Set<Edge<T>> newSet = new HashSet<>();
            newSet.add(edge);
            vertices.put(t2, newSet);
        } else {
            vertices.get(t2).add(edge);
        }
    }
    
    public static class MinimumSpanningTree<T> {
        private Set<T> marked = new HashSet<>();
        private PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        private List<Edge<T>> mst = new ArrayList<>();
        
        public MinimumSpanningTree(UndirectedWeightedGraph<T> graph) {
            if (graph.getVertices().size() == 0) {
                return;
            }
            T t = graph.getVertices().iterator().next();
            visit(graph, t);
            while (!pq.isEmpty()) {
                Edge<T> edge = pq.remove();
                T t1 = edge.either();
                T t2 = edge.other(t1);
                if (marked.contains(t1) && marked.contains(t2)) {
                    continue;
                }
                mst.add(edge);
                if (!marked.contains(t1)) {
                    visit(graph, t1);
                }
                if (!marked.contains(t2)) {
                    visit(graph, t2);
                }
            }
        }
        
        private void visit(UndirectedWeightedGraph<T> graph, T t) {
            marked.add(t);
            for (Edge<T> e : graph.adjacent(t)) {
                if (!marked.contains(e.other(t))) {
                    pq.add(e);
                }
            }
        }
        
        public List<Edge<T>> getPaths() {
            return mst;
        }
        
        public double getWeight() {
            double weight = 0;
            for (Edge<T> e : mst) {
                weight += e.getWeight();
            }
            return weight;
        }
    }
}
