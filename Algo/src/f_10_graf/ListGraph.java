/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

import java.util.List;

/**
 *
 * @author tiago
 */
public class ListGraph extends AbstractGraph {
    
    private List<Edge>[] edges;;
    
    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
    }
    
}
