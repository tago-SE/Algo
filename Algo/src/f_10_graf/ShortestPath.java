/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author tiago
 */
public class ShortestPath {
    
    final private int numV;
    final private int[][] graph;
     
    public ShortestPath(int[][] graph, int numV) {
        this.graph = graph;
        this.numV = numV;
    }
    
    public void printSolution(int dist[], int numV) {
       System.out.println("Vertex   Distance from Source");
       for (int v = 0; v < numV; v++)
            System.out.println(v + "\t\t" + dist[v]);
    }
    
    /* Utility function to find vertex with minimum distance value from
     * the set of vertices not yet included in shortest path tree */
    public int minDistance(int[] dist, boolean[] proc) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!proc[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    
    public boolean hasEdge(int srcs, int dest) {
        return graph[srcs][dest] > 0;
    }
    
    // Can be optimized to have a predefined adjacency matrix
    public List<Integer> getAdjacent(int srcs) {
        List<Integer> adj = new ArrayList<>();
        for (int dest = 0; dest < numV; dest++) {
            if (dest != srcs && hasEdge(srcs, dest)) {
                adj.add(dest);
            }
        }
        return adj;
    }
    
    public void djikstra(int srcs) {
        // Output array - dist[i] will hold the shortest distance from src to i
        int dist[] = new int[numV];
        
        boolean[] proc  = new boolean[numV];
        
        // Setup all distances
        for (int u = 0; u < numV; u++) {
            dist[u] = Integer.MAX_VALUE;
            proc[u] = false;
        }
        dist[srcs] = 0; // distance to source is always 0
        
        for (int u = 0; u < numV - 1; u++) {
            // Pick the min distance vertec from the set of vertices not yet 
            // processed. u is always srcs in the first iteration
            int min = minDistance(dist, proc);
            proc[min] = true;
            
            for (Integer v : getAdjacent(min)) {
                 if (dist[v] > dist[min] + graph[min][v]) {
                    dist[v] = dist[min] + graph[min][v];
                }
            }
        }
        printSolution(dist, numV);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Weighted Adjacency List");
        for (int v = 0; v < numV; v++) {
            sb.append(v).append(": ");
            Iterator itr = getAdjacent(v).iterator();
            while (itr.hasNext()) {
                int u = (int) itr.next();
                sb.append(u).append("(").append(graph[v][u]).append(")");
                if (itr.hasNext()) sb.append(",");
            }
            sb.append("\n");
        }
       return sb.toString();
    }
}
