package algorithms;

import algorithms.DirectedGraph.CycleDetector;
import algorithms.DirectedGraph.PathFinder;
import algorithms.DirectedGraph.ShortestPath;
import algorithms.DirectedGraph.StronglyConnectedComponent;
import algorithms.DirectedGraph.TopologicalSort;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DirectedGraphTest {
    @Test
    public void test() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(1, 2);
        graph.add(2, 3);
        graph.add(4, 1);
        graph.add(5, 3);
        graph.add(6, 1);
        graph.add(3, 7);

        assertEquals(7, graph.getVertices().size());
        assertTrue(graph.adjacent(10).isEmpty());
        Set<Integer> adj = graph.adjacent(1);
        assertEquals(1, adj.size());
        assertTrue(adj.contains(2));

        adj = graph.adjacent(3);
        assertEquals(1, adj.size());
        assertTrue(adj.contains(7));
    }

    @Test
    public void tesPathFinder() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(0, 5);
        graph.add(2, 4);
        graph.add(2, 3);
        graph.add(1, 2);
        graph.add(0, 1);
        graph.add(3, 4);
        graph.add(3, 5);
        graph.add(0, 2);

        PathFinder<Integer> dfs = new PathFinder<>(graph, 0);
        assertTrue(dfs.hasPathTo(5));
        assertFalse(dfs.hasPathTo(10));
        assertEquals("[5, 3, 2, 1, 0]", dfs.pathTo(5).toString());
        assertEquals("[4, 3, 2, 1, 0]", dfs.pathTo(4).toString());
        assertEquals("[3, 2, 1, 0]", dfs.pathTo(3).toString());
        assertEquals("[2, 1, 0]", dfs.pathTo(2).toString());
        assertEquals("[1, 0]", dfs.pathTo(1).toString());
        assertEquals("[0]", dfs.pathTo(0).toString());
        assertEquals("[]", dfs.pathTo(10).toString());
    }

    @Test
    public void testShortestPath() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(0, 5);
        graph.add(2, 4);
        graph.add(2, 3);
        graph.add(1, 2);
        graph.add(0, 1);
        graph.add(3, 4);
        graph.add(3, 5);
        graph.add(0, 2);

        ShortestPath<Integer> bfs = new ShortestPath<>(graph, 0);
        assertTrue(bfs.hasPathTo(5));
        assertFalse(bfs.hasPathTo(10));
        assertEquals("[5, 0]", bfs.pathTo(5).toString());
        assertEquals("[4, 2, 0]", bfs.pathTo(4).toString());
        assertEquals("[3, 2, 0]", bfs.pathTo(3).toString());
        assertEquals("[2, 0]", bfs.pathTo(2).toString());
        assertEquals("[1, 0]", bfs.pathTo(1).toString());
        assertEquals("[0]", bfs.pathTo(0).toString());
        assertEquals("[]", bfs.pathTo(10).toString());
    }

    @Test
    public void testCycleDetector() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(1, 2);
        graph.add(2, 3);
        graph.add(4, 1);
        graph.add(5, 3);
        graph.add(6, 1);
        graph.add(3, 7);
        CycleDetector<Integer> cd = new CycleDetector<>(graph);
        assertFalse(cd.hasCycle());

        graph = new DirectedGraph<>();
        graph.add(2, 1);
        graph.add(1, 3);
        graph.add(3, 2);
        graph.add(2, 4);
        cd = new CycleDetector<>(graph);
        assertTrue(cd.hasCycle());
    }

    @Test
    public void testTopologicalSort() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(1, 5);
        graph.add(2, 5);
        graph.add(2, 6);
        graph.add(4, 6);
        graph.add(4, 7);
        graph.add(5, 7);
        graph.add(3, 7);

        TopologicalSort<Integer> ts = new TopologicalSort<>(graph);
        assertEquals("[4, 1, 3, 2, 6, 5, 7]", ts.getPaths().toString());
    }

    @Test
    public void testStronglyConnectedComponent() {
        DirectedGraph<Integer> graph = new DirectedGraph<>();
        graph.add(0, 1);
        graph.add(0, 5);
        graph.add(2, 0);
        graph.add(2, 3);
        graph.add(3, 2);
        graph.add(3, 5);
        graph.add(4, 2);
        graph.add(4, 3);
        graph.add(5, 4);
        graph.add(6, 0);
        graph.add(6, 4);
        graph.add(6, 8);
        graph.add(6, 9);
        graph.add(7, 6);
        graph.add(7, 9);
        graph.add(8, 6);
        graph.add(9, 10);
        graph.add(9, 11);
        graph.add(10, 12);
        graph.add(11, 4);
        graph.add(11, 12);
        graph.add(12, 9);

        StronglyConnectedComponent<Integer> scc = new StronglyConnectedComponent<>(graph);
        List<List<Integer>> groups = scc.getStronglyConnectedComponents();
        assertEquals(5, groups.size());
        assertEquals("[1]", groups.get(0).toString());
        assertEquals("[0, 5, 4, 2, 3]", groups.get(1).toString());
        assertEquals("[11, 12, 9, 10]", groups.get(2).toString());
        assertEquals("[6, 8]", groups.get(3).toString());
        assertEquals("[7]", groups.get(4).toString());
        assertTrue(scc.stronglyConnected(0, 5));
        assertFalse(scc.stronglyConnected(0, 1));
    }
}
