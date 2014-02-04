package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import algorithms.UndirectedWeightedGraph.Vertex;

public class UndirectedWeightedGraphTest {
    @Test
    public void test() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        graph.add(new Vertex<>(1), new Vertex<>(2));
        graph.add(new Vertex<>(2), new Vertex<>(3));
        graph.add(new Vertex<>(4), new Vertex<>(1));
        graph.add(new Vertex<>(5), new Vertex<>(3));
        graph.add(new Vertex<>(6), new Vertex<>(1));
        graph.add(new Vertex<>(3), new Vertex<>(7));
        
        assertEquals(7, graph.getVertices().size());
        assertTrue(graph.adjacent(new Vertex<>(10)).isEmpty());
        Set<Vertex<Integer>> adj = graph.adjacent(new Vertex<>(1));
        assertEquals(3, adj.size());
        assertTrue(adj.contains(new Vertex<>(6)));
        assertTrue(adj.contains(new Vertex<>(4)));
        assertTrue(adj.contains(new Vertex<>(2)));
        
        adj = graph.adjacent(new Vertex<>(3));
        assertEquals(3, adj.size());
        assertTrue(adj.contains(new Vertex<>(2)));
        assertTrue(adj.contains(new Vertex<>(5)));
        assertTrue(adj.contains(new Vertex<>(7)));
    }
}
