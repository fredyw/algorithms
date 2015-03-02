package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import algorithms.DirectedWeightedGraph.Edge;
import algorithms.DirectedWeightedGraph.MaximumFlow;
import algorithms.DirectedWeightedGraph.ShortestPath;

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
    
    @Test
    public void testMaximumFlow() {
        DirectedWeightedGraph<Integer> graph = new DirectedWeightedGraph<>();
        graph.add(new Edge<>(0, 1, 16));
        graph.add(new Edge<>(0, 2, 13));
        graph.add(new Edge<>(1, 2, 10));
        graph.add(new Edge<>(2, 1, 4));
        graph.add(new Edge<>(1, 3, 12));
        graph.add(new Edge<>(3, 2, 9));
        graph.add(new Edge<>(2, 4, 14));
        graph.add(new Edge<>(4, 3, 7));
        graph.add(new Edge<>(3, 5, 20));
        graph.add(new Edge<>(4, 5, 4));
        
        MaximumFlow<Integer> maxFlow = new MaximumFlow<Integer>(graph, 0, 5);
        assertEquals(23.0, maxFlow.getMaximumFlow(), 0);
    }
}
