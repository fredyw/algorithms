package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UndirectedWeightedGraph<T> {
    private Map<T, Set<Edge<T>>> vertices = new HashMap<>();
    
    public static class Edge<T> implements Comparable<T> {
        private double weight;
        private T t1;
        private T t2;
        private double flow;
        
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
        
        public double residualCapacityTo(T vertex) {
            if (vertex.equals(t1)) {
                return flow;
            } else if (vertex.equals(t2)) {
                return weight - flow;
            }
            throw new IllegalArgumentException();
        }
        
        public void addResidualFlowTo(T vertex, double delta) {
            if (vertex.equals(t1)) {
                flow -= delta;
            } else if (vertex.equals(t2)) {
                flow += delta;
            }
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
    
    /*
     * MST using Prim's algorithm 
     */
    public static class PrimMinimumSpanningTree<T> {
        private Set<T> marked = new HashSet<>();
        private PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        private List<Edge<T>> mst = new ArrayList<>();
        
        public PrimMinimumSpanningTree(UndirectedWeightedGraph<T> graph) {
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
    
    /*
     * MST using Kruskal's algorithm
     */
    public static class KruskalMinimumSpanningTree<T> {
        private PriorityQueue<Edge<T>> pq = new PriorityQueue<>();
        private List<Edge<T>> mst = new ArrayList<>();

        public KruskalMinimumSpanningTree(UndirectedWeightedGraph<T> graph) {
            Set<Edge<T>> edges = getEdges(graph);
            for (Edge<T> edge : edges) {
                pq.add(edge);
            }
            
            QuickWeightedUnion<T> unionFind = new QuickWeightedUnion<>();
            while (!pq.isEmpty()) {
                Edge<T> edge = pq.remove(); // remove the minimum
                T v = edge.either();
                T w = edge.other(v);
                // if not connected, that means there's no cycle
                if (!unionFind.connected(v, w)) {
                    mst.add(edge);
                    unionFind.union(v, w);
                }
            }
        }
        
        private Set<Edge<T>> getEdges(UndirectedWeightedGraph<T> graph) {
            Set<Edge<T>> edges = new HashSet<>();
            for (T vertex : graph.getVertices()) {
                edges.addAll(graph.adjacent(vertex));
            }
            return edges;
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
    
    /*
     * Dijkstra's algorithm
     */
    public static class ShortestPath<T> {
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
        
        private Map<T, Edge<T>> edgeTo = new HashMap<>();
        private Map<T, Double> distTo = new HashMap<>();
        private PriorityQueue<DistTo<T>> pq = new PriorityQueue<>();
        
        public ShortestPath(UndirectedWeightedGraph<T> graph, T source) {
            for (T t : graph.getVertices()) {
                distTo.put(t, Double.POSITIVE_INFINITY);
            }
            distTo.put(source, 0.0);
            
            pq.add(new DistTo<>(source, 0.0));
            while (!pq.isEmpty()) {
                relax(graph, pq.remove().t);
            }
        }
        
        private void relax(UndirectedWeightedGraph<T> graph, T from) {
            for (Edge<T> e : graph.adjacent(from)) {
                T to = e.other(e.either());
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
            paths.add(e.either());
            while ((e = edgeTo.get(e.either())) != null) {
                paths.add(e.either());
            }
            return paths;
        }
    }
    
    /*
     * Ford Fulkerson's algorithm
     */
    public static class MaximumFlow<T> {
        private double maxFlow;
        private Map<T, Edge<T>> edgeTo = new HashMap<>();
        private Set<T> marked = new HashSet<>();
        
        public MaximumFlow(UndirectedWeightedGraph<T> graph, T source, T dest) {
            while (hasAugmentingPath(graph, source, dest)) {
                // compute bottleneck capacity
                double bottleneck = Double.POSITIVE_INFINITY;
                for (T v = dest; !v.equals(source); v = edgeTo.get(v).other(v)) {
                    bottleneck = Math.min(bottleneck, edgeTo.get(v).residualCapacityTo(v));
                }

                // augment flow
                for (T v = dest; !v.equals(source); v = edgeTo.get(v).other(v)) {
                    edgeTo.get(v).addResidualFlowTo(v, bottleneck); 
                }
                maxFlow += bottleneck;
            }
        }
        
        private boolean hasAugmentingPath(UndirectedWeightedGraph<T> graph, T source, T dest) {
            edgeTo = new HashMap<>();
            marked = new HashSet<>();

            // breadth-first search
            Queue<T> queue = new LinkedList<>();
            queue.add(source);
            marked.add(source);
            while (!queue.isEmpty() && !marked.contains(dest)) {
                T v = queue.remove();
                for (Edge<T> e : graph.adjacent(v)) {
                    T w = e.other(v);
                    // if residual capacity from v to w
                    if (e.residualCapacityTo(w) > 0) {
                        if (!marked.contains(w)) {
                            edgeTo.put(w, e);
                            marked.add(w);
                            queue.add(w);
                        }
                    }
                }
            }
            // is there an augmenting path?
            return marked.contains(dest);
        }
        
        public double getMaximumFlow() {
            return maxFlow;
        }
    }
}
