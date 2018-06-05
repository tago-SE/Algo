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
public class GraphAdjacencyTest {

    
    private ListGraph getInstance() {
        ListGraph g = new ListGraph(6, true);
        g.insertEdge(0, 1, 1);
        g.insertEdge(0, 3, 2);
        g.insertEdge(1, 4, 3);
        g.insertEdge(2, 4, 4);
        g.insertEdge(2, 5, 5);
        g.insertEdge(3, 1, 6);
        g.insertEdge(4, 3, 7);
        g.insertEdge(5, 5, 8);
        return g;
    } 
    
    public GraphAdjacencyTest() {
    }   

    @Test
    public void testInsertEdge() {
        
    }

    @Test
    public void testIsConnected() {
        ListGraph g = getInstance();
        assertEquals(true, g.isConnected(0, 1));
        assertEquals(true, g.isConnected(0, 3));
        assertEquals(true, g.isConnected(1, 4));
        assertEquals(true, g.isConnected(2, 4));
        assertEquals(true, g.isConnected(2, 5));
        assertEquals(true, g.isConnected(3, 1));
        assertEquals(true, g.isConnected(4, 3));
        assertEquals(true, g.isConnected(5, 5));
        assertEquals(false, g.isConnected(1, 0));
    }

    @Test
    public void testToString() throws IOException {
        ListGraph g = ListGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency_1.txt");
        System.out.println(g.toString());
    }
    
    //@Test
    public void testCreateGraph() throws IOException {
        ListGraph g = ListGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        System.out.println(g.toString());
    }
    
    //@Test
    public void findClosestPath() throws IOException {
        ListGraph g = ListGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        g.findClosestPath(0,'H' - 'A');
    }
    
     //@Test
    public void findPathBreadthFirst() throws IOException {
        ListGraph g = ListGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        g.findPathBreadthFirst(0,'H' - 'A');
    }
    
    @Test
    public void findShortestPathDepthFirst() throws IOException {
        ListGraph g = ListGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency_1.txt");
        g.findShortestPathDepthFirst(0, 'H' - 'A');
    }
    /*
   // @Test
    public void printMatrixGraph() throws IOException {
        ShortestPath g = ShortestPath.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        System.out.println("MATRIX: \n" + g.toString());
    }
*/
}
