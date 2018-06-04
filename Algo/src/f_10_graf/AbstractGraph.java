/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

/**
 *
 * @author tiago
 */
public abstract class AbstractGraph {
    
    protected int numV;
    protected boolean directed;
   
    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }
    
    public int getNumV() {
        return numV;
    }
    public boolean isDirected() {
        return directed;
    }
   
}
