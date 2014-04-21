package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import algorithms.DirectedWeightedGraph.Edge;

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
        
        assertEquals(6, graph.getVertices().size());
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
        
    }
}
