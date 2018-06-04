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
public class MatrixGraphTest {
    
    public MatrixGraphTest() {
    }

    @Test
    public void testAddEdge() {
    }

    @Test
    public void testRemoveEdge() {
    }

    @Test
    public void testGetEdges() {
    }

    @Test
    public void testGetEdgeWeight() {
    }

    @Test
    public void testCreateGraph() throws Exception {
    }

    @Test
    public void testToString() throws IOException {
        MatrixGraph g = MatrixGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        System.out.println("MATRIX: \n" + g.toString());
    
    }
    
    @Test
    public void findShortestPathFromNodeToOthers() throws IOException {
        MatrixGraph g = MatrixGraph.createGraph("C:\\Users\\tiago\\OneDrive\\Dokument\\KTH\\Algo\\Repo\\Algo\\Algo\\src\\f_10_graf" + "\\adjacency.txt");
        g.findShortestPathFromNodeToOthers(0);
    }
   
}
