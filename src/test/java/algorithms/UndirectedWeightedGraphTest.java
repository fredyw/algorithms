package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import algorithms.UndirectedWeightedGraph.Edge;
import algorithms.UndirectedWeightedGraph.KruskalMinimumSpanningTree;
import algorithms.UndirectedWeightedGraph.PrimMinimumSpanningTree;
import algorithms.UndirectedWeightedGraph.ShortestPath;

public class UndirectedWeightedGraphTest {
    @Test
    public void test() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        graph.add(new Edge<>(1, 2, 0));
        graph.add(new Edge<>(2, 3, 0));
        graph.add(new Edge<>(4, 1, 0));
        graph.add(new Edge<>(5, 3, 0));
        graph.add(new Edge<>(6, 1, 0));
        graph.add(new Edge<>(3, 7, 0));
        
        assertEquals(7, graph.getVertices().size());
        assertTrue(graph.adjacent(10).isEmpty());
        Set<Edge<Integer>> adj = graph.adjacent(1);
        assertEquals(3, adj.size());
        assertTrue(adj.contains(new Edge<>(6, 1, 0)));
        assertTrue(adj.contains(new Edge<>(4, 1, 0)));
        assertTrue(adj.contains(new Edge<>(1, 2, 0)));
        
        adj = graph.adjacent(3);
        assertEquals(3, adj.size());
        assertTrue(adj.contains(new Edge<>(2, 3, 0)));
        assertTrue(adj.contains(new Edge<>(5, 3, 0)));
        assertTrue(adj.contains(new Edge<>(3, 7, 0)));
    }
    
    @Test
    public void testPrimMinimumSpanningTree() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        graph.add(new Edge<>(4, 5, 0.35));
        graph.add(new Edge<>(4, 7, 0.37));
        graph.add(new Edge<>(5, 7, 0.28));
        graph.add(new Edge<>(0, 7, 0.16));
        graph.add(new Edge<>(1, 5, 0.32));
        graph.add(new Edge<>(0, 4, 0.38));
        graph.add(new Edge<>(2, 3, 0.17));
        graph.add(new Edge<>(1, 7, 0.19));
        graph.add(new Edge<>(0, 2, 0.26));
        graph.add(new Edge<>(1, 2, 0.36));
        graph.add(new Edge<>(1, 3, 0.29));
        graph.add(new Edge<>(2, 7, 0.34));
        graph.add(new Edge<>(6, 2, 0.40));
        graph.add(new Edge<>(3, 6, 0.52));
        graph.add(new Edge<>(6, 0, 0.58));
        graph.add(new Edge<>(6, 4, 0.93));
        
        PrimMinimumSpanningTree<Integer> mst = new PrimMinimumSpanningTree<>(graph);
        assertEquals(
            "[0-7 0.16, 1-7 0.19, 0-2 0.26, 2-3 0.17, 5-7 0.28, 4-5 0.35, 6-2 0.4]",
            mst.getPaths().toString());
        assertEquals(1.81, mst.getWeight(), 0.0);
    }
    
    @Test
    public void testKruskalMinimumSpanningTree() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        graph.add(new Edge<>(4, 5, 0.35));
        graph.add(new Edge<>(4, 7, 0.37));
        graph.add(new Edge<>(5, 7, 0.28));
        graph.add(new Edge<>(0, 7, 0.16));
        graph.add(new Edge<>(1, 5, 0.32));
        graph.add(new Edge<>(0, 4, 0.38));
        graph.add(new Edge<>(2, 3, 0.17));
        graph.add(new Edge<>(1, 7, 0.19));
        graph.add(new Edge<>(0, 2, 0.26));
        graph.add(new Edge<>(1, 2, 0.36));
        graph.add(new Edge<>(1, 3, 0.29));
        graph.add(new Edge<>(2, 7, 0.34));
        graph.add(new Edge<>(6, 2, 0.40));
        graph.add(new Edge<>(3, 6, 0.52));
        graph.add(new Edge<>(6, 0, 0.58));
        graph.add(new Edge<>(6, 4, 0.93));
        
        KruskalMinimumSpanningTree<Integer> mst = new KruskalMinimumSpanningTree<>(graph);
        assertEquals(
            "[0-7 0.16, 2-3 0.17, 1-7 0.19, 0-2 0.26, 5-7 0.28, 4-5 0.35, 6-2 0.4]",
            mst.getPaths().toString());
        assertEquals(1.81, mst.getWeight(), 0.0);
    }
    
    @Test
    public void testShortestPath() {
        UndirectedWeightedGraph<Integer> graph = new UndirectedWeightedGraph<>();
        graph.add(new Edge<>(1, 2, 3));
        graph.add(new Edge<>(1, 3, 3));
        graph.add(new Edge<>(2, 3, 1));
        graph.add(new Edge<>(2, 4, 2));
        graph.add(new Edge<>(3, 4, 50));
        
        ShortestPath<Integer> sp = new ShortestPath<>(graph, 1);
        assertEquals("[]", sp.pathTo(1).toString());
        assertEquals(0.0, sp.distTo(1), 0.0);
        
        assertEquals("[2, 1]", sp.pathTo(2).toString());
        assertEquals(3.0, sp.distTo(2), 0.0);
        
        assertEquals("[3, 1]", sp.pathTo(3).toString());
        assertEquals(3.0, sp.distTo(3), 0.0);
        
        assertEquals("[4, 2, 1]", sp.pathTo(4).toString());
        assertEquals(5.0, sp.distTo(4), 0.0);
    }
}
