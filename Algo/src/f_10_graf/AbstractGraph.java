package f_10_graf;

import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class AbstractGraph implements GraphInt {
    
    
    private int numVerticies;
    private boolean directed; 
    
    public AbstractGraph(int numV, boolean directed) {
        this.numVerticies = numV;
        this.directed = directed;
    }
    
    @Override
    public int getNumVertices() {
        return numVerticies;
    }
    
    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void loadEdgesFromFile(Scanner scan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
