package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    
    public static class PathFinderDFS<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, T> edgeTo = new HashMap<>();
        
        public PathFinderDFS(UndirectedGraph<T> graph, T source) {
            dfs(graph, source);
        }
        
        private void dfs(UndirectedGraph<T> graph, T source) {
            marked.add(source);
            for (T adj : graph.adjacent(source)) {
                if (!marked.contains(adj)) {
                    edgeTo.put(adj, source);
                    dfs(graph, adj);
                }
            }
        }
        
        public boolean hasPathTo(T target) {
            return marked.contains(target);
        }
        
        public List<T> pathTo(T target) {
            if (!hasPathTo(target)) {
                return new ArrayList<T>();
            }
            List<T> paths = new ArrayList<>();
            paths.add(target);
            T t = edgeTo.get(target);
            while (t != null) {
                paths.add(t);
                t = edgeTo.get(t);
            }
            return paths;
        }
    }
    
    public static class PathFinderBFS<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, T> edgeTo = new HashMap<>();
        
        public PathFinderBFS(UndirectedGraph<T> graph, T source) {
            bfs(graph, source);
        }
        
        private void bfs(UndirectedGraph<T> graph, T source) {
            T s = source;
            LinkedList<T> nodes = new LinkedList<>();
            while (true) {
                marked.add(s);
                for (T adj : graph.adjacent(s)) {
                    if (!marked.contains(adj)) {
                        nodes.add(adj);
                        marked.add(adj);
                        edgeTo.put(adj, s);
                    }
                }
                if (nodes.size() == 0) {
                    break;
                }
                s = nodes.removeFirst();
            }
        }
        
        public boolean hasPathTo(T target) {
            return marked.contains(target);
        }
        
        public List<T> pathTo(T target) {
            if (!hasPathTo(target)) {
                return new ArrayList<T>();
            }
            List<T> paths = new ArrayList<>();
            paths.add(target);
            T t = edgeTo.get(target);
            while (t != null) {
                paths.add(t);
                t = edgeTo.get(t);
            }
            return paths;
        }
    }
    
    public static class ConnectedComponentDFS<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, Integer> groups = new HashMap<>();
        private Map<Integer, List<T>> connectedComponents = new HashMap<>(); 
        private int group;
        
        public ConnectedComponentDFS(UndirectedGraph<T> graph) {
            for (T t : graph.vertices.keySet()) {
                if (!marked.contains(t)) {
                    dfs(graph, t);
                    group++;
                }
            }
        }
        
        private void dfs(UndirectedGraph<T> graph, T source) {
            marked.add(source);
            groups.put(source, group);
            if (!connectedComponents.containsKey(group)) {
                connectedComponents.put(group, new ArrayList<T>());
            }
            connectedComponents.get(group).add(source);
            for (T t : graph.adjacent(source)) {
                if (!marked.contains(t)) {
                    dfs(graph, t);
                }
            }
        }
        
        public boolean connected(T node1, T node2) {
            return groups.get(node1) == groups.get(node2);
        }
        
        public List<List<T>> getConnectedComponents() {
            List<List<T>> result = new ArrayList<>();
            for (int i = 0; i < group; i++) {
                result.add(connectedComponents.get(i));
            }
            return result;
        }
    }
    
    public static class CycleDetector<T> {
        private boolean hasCycle = false;
        private Set<T> marked = new HashSet<>();
        
        public CycleDetector(UndirectedGraph<T> graph) {
            for (T t : graph.vertices.keySet()) {
                if (!marked.contains(t)) {
                    dfs(graph, t, t);
                }
            }
        }
        
        private void dfs(UndirectedGraph<T> graph, T source, T parent) {
            marked.add(source);
            for (T t : graph.adjacent(source)) {
                if (!marked.contains(t)) {
                    dfs(graph, t, source);
                } else {
                    if (!t.equals(parent)) {
                        hasCycle = true;
                    }
                }
            }
        }
        
        public boolean hasCycle() {
            return hasCycle;
        }
    }
}
