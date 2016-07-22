package algorithms;

import algorithms.UndirectedGraph.BipartiteDetector;
import algorithms.UndirectedGraph.ConnectedComponent;
import algorithms.UndirectedGraph.CycleDetector;
import algorithms.UndirectedGraph.PathFinder;
import algorithms.UndirectedGraph.ShortestPath;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UndirectedGraphTest {
    @Test
    public void test() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.add(1, 2);
        graph.add(2, 3);
        graph.add(4, 1);
        graph.add(5, 3);
        graph.add(6, 1);
        graph.add(3, 7);

        assertEquals(7, graph.getVertices().size());
        assertTrue(graph.adjacent(10).isEmpty());
        Set<Integer> adj = graph.adjacent(1);
        assertEquals(3, adj.size());
        assertTrue(adj.contains(6));
        assertTrue(adj.contains(4));
        assertTrue(adj.contains(2));

        adj = graph.adjacent(3);
        assertEquals(3, adj.size());
        assertTrue(adj.contains(2));
        assertTrue(adj.contains(5));
        assertTrue(adj.contains(7));
    }

    @Test
    public void tesPathFinder() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
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
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
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
    public void testConnectedComponenent() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.add(0, 6);
        graph.add(0, 2);
        graph.add(0, 1);
        graph.add(0, 5);
        graph.add(3, 5);
        graph.add(3, 4);
        graph.add(4, 6);
        graph.add(4, 5);
        graph.add(7, 8);
        graph.add(9, 10);
        graph.add(9, 11);
        graph.add(9, 12);

        ConnectedComponent<Integer> dfs = new ConnectedComponent<>(graph);
        List<List<Integer>> cc = dfs.getConnectedComponents();
        assertEquals(3, cc.size());
        assertEquals("[0, 1, 2, 5, 3, 4, 6]", cc.get(0).toString());
        assertEquals("[7, 8]", cc.get(1).toString());
        assertEquals("[9, 10, 11, 12]", cc.get(2).toString());
    }

    @Test
    public void testCycleDetector() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.add(1, 2);
        graph.add(2, 3);
        graph.add(4, 1);
        graph.add(5, 3);
        graph.add(6, 1);
        graph.add(3, 7);
        CycleDetector<Integer> cd = new CycleDetector<>(graph);
        assertFalse(cd.hasCycle());

        graph = new UndirectedGraph<>();
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(3, 2);
        cd = new CycleDetector<>(graph);
        assertTrue(cd.hasCycle());
    }

    @Test
    public void testBipartiteDetector() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.add(1, 6);
        graph.add(2, 6);
        graph.add(2, 7);
        graph.add(3, 8);
        graph.add(3, 9);
        graph.add(4, 7);
        graph.add(5, 6);
        graph.add(5, 9);
        BipartiteDetector<Integer> bd = new BipartiteDetector<>(graph);
        assertTrue(bd.isBipartitie());

        graph = new UndirectedGraph<>();
        graph.add(1, 2);
        graph.add(1, 3);
        graph.add(3, 2);
        bd = new BipartiteDetector<>(graph);
        assertFalse(bd.isBipartitie());
    }
}
