package f_10_graf;

import java.util.List;



/** Interface to specify a Graph ADT. A graph is a set of vertices and set 
    of edges. Vertices are represented by integers from 0 to n - 1. Edges are
    ordered pairs of vertices. Each implementation of the Graph interface 
    should provide a constructor that specifies the number of vertices and 
    whether or not the graph is directed. 
 */
public interface GraphInt {
    public void insert(Edge edge);
    public boolean isEdge(int source, int dest);
    public Edge getEdge(int source, int dest);
    public List<Edge> edgeIterator(int source);
}
