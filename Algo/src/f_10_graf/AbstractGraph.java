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
public abstract class AbstractGraph {
    
    protected final List<Vertex> vertices;
    protected final List<Edge> edges;

    public AbstractGraph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
    
    public List<Edge> getEdges() {
        return edges;
    }
    
    public List<Vertex> getVertices() {
        return vertices;
    }
    
    public int getNumV() {
        return vertices.size();
    }
   
}
