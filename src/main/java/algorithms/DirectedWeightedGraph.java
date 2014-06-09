package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DirectedWeightedGraph<T> {
    private Map<T, Set<Edge<T>>> edges = new HashMap<>();
    private Set<T> vertices = new HashSet<>();
    
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
        return Collections.unmodifiableSet(vertices);
    }
    
    public Set<Edge<T>> adjacent(T t) {
        if (!edges.containsKey(t)) {
            return new HashSet<>();
        }
        return edges.get(t);
    }
    
    public void add(Edge<T> edge) {
        if (!edges.containsKey(edge.from())) {
            Set<Edge<T>> newSet = new HashSet<>();
            newSet.add(edge);
            edges.put(edge.from(), newSet);
        } else {
            edges.get(edge.from()).add(edge);
        }
        
        if (!vertices.contains(edge.from())) {
            vertices.add(edge.from());
        }
        
        if (!vertices.contains(edge.to())) {
            vertices.add(edge.to());
        }
    }
    
    private static class DistTo<T> implements Comparable<DistTo<T>> {
        private T t;
        private double weight;
 
        public DistTo(T t, double weight) {
            this.t = t;
            this.weight = weight;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((t == null) ? 0 : t.hashCode());
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
            DistTo<T> other = (DistTo<T>) obj;
            if (t == null) {
                if (other.t != null) {
                    return false;
                }
            } else if (!t.equals(other.t)) {
                return false;
            }
            return true;
        }


        @Override
        public int compareTo(DistTo<T> d) {
            return Double.valueOf(weight).compareTo(d.weight);
        }
    }
    
    public static class ShortestPath<T> {
        private Map<T, Edge<T>> edgeTo = new HashMap<>();
        private Map<T, Double> distTo = new HashMap<>();
        private PriorityQueue<DistTo<T>> pq = new PriorityQueue<>();
        
        public ShortestPath(DirectedWeightedGraph<T> graph, T source) {
            for (T t : graph.getVertices()) {
                distTo.put(t, Double.POSITIVE_INFINITY);
            }
            distTo.put(source, 0.0);
            
            pq.add(new DistTo<>(source, 0.0));
            while (!pq.isEmpty()) {
                relax(graph, pq.remove().t);
            }
        }
        
        private void relax(DirectedWeightedGraph<T> graph, T from) {
            for (Edge<T> e : graph.adjacent(from)) {
                T to = e.to();
                if (distTo.get(to) > distTo.get(from) + e.weight) {
                    double newWeight = distTo.get(from) + e.weight;
                    distTo.put(to, newWeight);
                    edgeTo.put(to, e);
                    DistTo<T> dt = new DistTo<>(to, newWeight);
                    if (pq.contains(dt)) {
                        pq.remove(dt);
                    }
                    pq.add(dt);
                }
            }
        }
        
        public double distTo(T target) {
            if (!hasPathTo(target)) {
                return 0.0;
            }
            return distTo.get(target);
        }
        
        public boolean hasPathTo(T target) {
            return edgeTo.containsKey(target);
        }
        
        public List<T> pathTo(T target) {
            List<T> paths = new ArrayList<>();
            if (!hasPathTo(target)) {
                return paths;
            }
            Edge<T> e = edgeTo.get(target);
            paths.add(target);
            paths.add(e.from());
            while ((e = edgeTo.get(e.from())) != null) {
                paths.add(e.from());
            }
            return paths;
        }
    }
}
