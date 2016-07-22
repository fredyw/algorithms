package algorithms;

import algorithms.DirectedWeightedGraph.Edge;
import algorithms.DirectedWeightedGraph.ShortestPath;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DirectedWeightedGraphTest {
    @Test
    public void test() {
        DirectedWeightedGraph<Integer> graph = new DirectedWeightedGraph<>();
        graph.add(new Edge<>(1, 2, 0));
        graph.add(new Edge<>(2, 3, 0));
        graph.add(new Edge<>(4, 1, 0));
        graph.add(new Edge<>(5, 3, 0));
        graph.add(new Edge<>(6, 1, 0));
        graph.add(new Edge<>(3, 7, 0));

        assertEquals(7, graph.getVertices().size());
        assertTrue(graph.adjacent(10).isEmpty());
        Set<Edge<Integer>> adj = graph.adjacent(1);
        assertEquals(1, adj.size());
        assertTrue(adj.contains(new Edge<>(1, 2, 0)));

        adj = graph.adjacent(3);
        assertEquals(1, adj.size());
        assertTrue(adj.contains(new Edge<>(3, 7, 0)));
    }

    @Test
    public void testShortestPath() {
        DirectedWeightedGraph<Integer> graph = new DirectedWeightedGraph<>();
        graph.add(new Edge<>(1, 2, 8));
        graph.add(new Edge<>(2, 3, 5));
        graph.add(new Edge<>(3, 7, 5));
        graph.add(new Edge<>(1, 4, 1));
        graph.add(new Edge<>(4, 7, 8));
        graph.add(new Edge<>(4, 5, 2));
        graph.add(new Edge<>(5, 6, 3));
        graph.add(new Edge<>(6, 7, 9));

        ShortestPath<Integer> sp = new ShortestPath<Integer>(graph, 1);
        assertEquals("[7, 4, 1]", sp.pathTo(7).toString());
        assertEquals(9, sp.distTo(7), 0);
        assertEquals("[6, 5, 4, 1]", sp.pathTo(6).toString());
        assertEquals(6, sp.distTo(6), 0);
        assertEquals("[]", sp.pathTo(10).toString());
        assertEquals(0, sp.distTo(10), 0);
    }
}
