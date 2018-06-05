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
public class MinimumSpanningTreeTest {
    
      int V = 5;
      int[][] graph  = {
          {0, 2, 0, 6, 0},
          {2, 0, 3, 8, 5},
          {0, 3, 0, 0, 7},
          {6, 8, 0, 0, 9},
          {0, 5, 7, 9, 0},
      };
      
     int V2 = 8;
    int[][] graph2  = {
          {0, 2, 0, 0, 0, 1, 0, 0},
          {2, 0, 2, 2, 4, 0, 0, 0},
          {0, 2, 0, 0, 3, 0, 0, 1},
          {0, 2, 0, 0, 3, 1, 0, 0},
          {0, 4, 3, 3, 0, 0, 7, 0},
          {1, 0, 0, 1, 0, 0, 5, 0},
          {0, 0, 0, 0, 7, 5, 0, 6},
          {0, 0, 1, 0, 0, 0, 6, 0},
      };
    
    public MinimumSpanningTreeTest() {
    }

    @Test
    public void testHasEdge() {
    }

    @Test
    public void testGetAdjacent() {
    }

    @Test
    public void testMinDistance() {
    }

    @Test
    public void testPrimsMST() {
        MinimumSpanningTree mst = new MinimumSpanningTree(graph2, V2);
        mst.primsMST(0);
    }

    
    @Test
    public void testToString() {
        MinimumSpanningTree mst = new MinimumSpanningTree(graph2, V2);
        System.out.println("" + mst.toString());
    }
    
}
