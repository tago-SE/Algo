/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

import java.io.IOException;
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
    public void createGraph() throws IOException {
        System.out.println("--------");
        int[][] g = GraphMatrix.create("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency_1.txt");
        int numV = g[0].length;
        ShortestPath sp = new ShortestPath(g, numV);
        
        int d = sp.shortestPath(0, 'H' - 'A');
        System.out.println("d = " + d);
        
    }

    @Test
    public void testShortestPath() {
        ShortestPath sp = new ShortestPath(graph, V);
        sp.shortestPath(0, 7);
    }
    
    @Test
    public void testToString() {
        ShortestPath sp = new ShortestPath(graph, V);
        System.out.println(sp.toString());
    }
 
}
