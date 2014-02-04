package algorithms;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import algorithms.DirectedGraph.CycleDetector;
import algorithms.DirectedGraph.PathFinder;
import algorithms.DirectedGraph.ShortestPath;
import algorithms.DirectedGraph.TopologicalSort;

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
        
        assertEquals(6, graph.getVertices().size());
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
        graph.add(5, 7);
        graph.add(3, 7);
        
        TopologicalSort<Integer> ts = new TopologicalSort<>(graph);
        assertEquals("[4, 1, 3, 2, 6, 5, 7]", ts.getPaths().toString());
    }
}
