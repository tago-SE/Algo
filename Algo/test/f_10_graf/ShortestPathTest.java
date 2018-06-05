/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class ShortestPathTest {
    
    final int V = 9;
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        
    public ShortestPathTest() {
    }

    @Test
    public void testMinDistance() {
    }

    @Test
    public void testPrintSolution() {
    }

    @Test
    public void testIsEdge() {
    }

    /* Prints shortest path to a specific node */
    @Test
    public void testDjikstra() {
        ShortestPath sp = new ShortestPath(graph, V);
        sp.djikstra(0); 
    }
    
    @Test
    public void testToString() {
        ShortestPath sp = new ShortestPath(graph, V);
        System.out.println(sp.toString());
    }
 
}
