package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DirectedGraph<T> {
    private Map<T, Set<T>> edges = new HashMap<>();
    private Set<T> vertices = new HashSet<>();

    public Set<T> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

    public Set<T> adjacent(T node) {
        if (!edges.containsKey(node)) {
            return new HashSet<>();
        }
        return edges.get(node);
    }

    public void add(T node1, T node2) {
        if (!edges.containsKey(node1)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(node2);
            edges.put(node1, newSet);
        } else {
            edges.get(node1).add(node2);
        }

        if (!vertices.contains(node1)) {
            vertices.add(node1);
        }

        if (!vertices.contains(node2)) {
            vertices.add(node2);
        }
    }

    public static class PathFinder<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, T> edgeTo = new HashMap<>();

        public PathFinder(DirectedGraph<T> graph, T source) {
            dfs(graph, source);
        }

        private void dfs(DirectedGraph<T> graph, T source) {
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
                return new ArrayList<>();
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

    public static class ShortestPath<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, T> edgeTo = new HashMap<>();

        public ShortestPath(DirectedGraph<T> graph, T source) {
            bfs(graph, source);
        }

        private void bfs(DirectedGraph<T> graph, T source) {
            LinkedList<T> nodes = new LinkedList<>();
            nodes.add(source);
            while (!nodes.isEmpty()) {
                T s = nodes.removeFirst();
                marked.add(s);
                for (T adj : graph.adjacent(s)) {
                    if (!marked.contains(adj)) {
                        nodes.add(adj);
                        marked.add(adj);
                        edgeTo.put(adj, s);
                    }
                }
            }
        }

        public boolean hasPathTo(T target) {
            return marked.contains(target);
        }

        public List<T> pathTo(T target) {
            if (!hasPathTo(target)) {
                return new ArrayList<>();
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

    public static class CycleDetector<T> {
        private boolean hasCycle = false;
        private Set<T> marked = new HashSet<>();
        private Map<T, Boolean> onStack = new HashMap<>();

        public CycleDetector(DirectedGraph<T> graph) {
            for (T t : graph.getVertices()) {
                onStack.put(t, false);
            }
            for (T t : graph.getVertices()) {
                if (!marked.contains(t)) {
                    dfs(graph, t);
                }
            }
        }

        private void dfs(DirectedGraph<T> graph, T source) {
            marked.add(source);
            onStack.put(source, true);
            for (T t : graph.adjacent(source)) {
                if (!marked.contains(t)) {
                    dfs(graph, t);
                } else {
                    if (onStack.get(t)) {
                        hasCycle = true;
                    }
                }
            }
            onStack.put(source, false);
        }

        public boolean hasCycle() {
            return hasCycle;
        }
    }

    public static class TopologicalSort<T> {
        private Set<T> marked = new HashSet<>();
        private Stack<T> paths = new Stack<>();

        public TopologicalSort(DirectedGraph<T> graph) {
            for (T v : graph.getVertices()) {
                if (!marked.contains(v)) {
                    dfs(graph, v);
                }
            }
        }

        private void dfs(DirectedGraph<T> graph, T node) {
            marked.add(node);
            for (T adj : graph.adjacent(node)) {
                if (!marked.contains(adj)) {
                    dfs(graph, adj);
                }
            }
            paths.add(node);
        }

        public List<T> getPaths() {
            List<T> p = new ArrayList<>();
            while (!paths.isEmpty()) {
                p.add(paths.pop());
            }
            return p;
        }
    }

    public static class StronglyConnectedComponent<T> {
        private Set<T> marked = new HashSet<>();
        private Map<T, Integer> groups = new HashMap<>();
        private Map<Integer, List<T>> connectedComponents = new HashMap<>();
        private int numGroups;

        public StronglyConnectedComponent(DirectedGraph<T> graph) {
            DirectedGraph<T> reversedGraph = reverse(graph);
            int group = 0;
            for (T t : reversePostOrder(reversedGraph)) {
                if (!marked.contains(t)) {
                    dfs(graph, t, group++);
                }
            }
            numGroups = group;
        }

        /*
         * Reverse the direction of the graph
         */
        private DirectedGraph<T> reverse(DirectedGraph<T> graph) {
            DirectedGraph<T> reversedGraph = new DirectedGraph<>();
            for (T t : graph.getVertices()) {
                for (T adj : graph.adjacent(t)) {
                    // reverse the direction
                    reversedGraph.add(adj, t);
                }
            }
            return reversedGraph;
        }

        /*
         * Gets the vertices in reverse post order
         */
        private List<T> reversePostOrder(DirectedGraph<T> graph) {
            Set<T> reversedMarked = new HashSet<>();
            Stack<T> reversedVertices = new Stack<>();
            for (T vertex : graph.getVertices()) {
                if (!reversedMarked.contains(vertex)) {
                    reversedDfs(graph, vertex, reversedMarked, reversedVertices);
                }
            }
            List<T> paths = new ArrayList<>();
            while (!reversedVertices.isEmpty()) {
                paths.add(reversedVertices.pop());
            }
            return paths;
        }

        private void reversedDfs(DirectedGraph<T> graph, T source,
                                 Set<T> reversedMarked, Stack<T> reversedVertices) {
            reversedMarked.add(source);
            for (T adj : graph.adjacent(source)) {
                if (!reversedMarked.contains(adj)) {
                    reversedDfs(graph, adj, reversedMarked, reversedVertices);
                }
            }
            reversedVertices.add(source);
        }

        private void dfs(DirectedGraph<T> graph, T source, int group) {
            marked.add(source);
            groups.put(source, group);
            if (!connectedComponents.containsKey(group)) {
                connectedComponents.put(group, new ArrayList<>());
            }
            connectedComponents.get(group).add(source);
            for (T t : graph.adjacent(source)) {
                if (!marked.contains(t)) {
                    dfs(graph, t, group);
                }
            }
        }

        public boolean stronglyConnected(T node1, T node2) {
            return groups.get(node1) == groups.get(node2);
        }

        public List<List<T>> getStronglyConnectedComponents() {
            List<List<T>> result = new ArrayList<>();
            for (int i = 0; i < numGroups; i++) {
                result.add(connectedComponents.get(i));
            }
            return result;
        }
    }
}
