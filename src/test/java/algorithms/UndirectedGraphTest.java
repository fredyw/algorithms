package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

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
       assertNull(graph.adjacent(10));
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
}
