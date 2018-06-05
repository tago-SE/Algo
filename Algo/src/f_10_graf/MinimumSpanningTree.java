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
public class MinimumSpanningTree {
    
    final private int numV;
    final private int[][] graph;
    private static final int NO_PARENT = -1;
    
    public MinimumSpanningTree(int[][] graph, int numV) {
        this.graph = graph;
        this.numV = numV;
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
    
    public void primsMST(int srcs) {
        int parent[] = new int[numV];
        int dist[] = new int[numV];
        boolean proc[] = new boolean[numV];
        
       
        for (int u = 0; u < numV; u++) {
            dist[u] = Integer.MAX_VALUE;
            proc[u] = false;
        }
        dist[srcs] = 0;  // first picked
        parent[srcs] = NO_PARENT;
     
        for (int u = 0; u < numV - 1; u++) { 
            int min = minDistance(dist, proc);
            proc[min] = true;
            for (Integer v : getAdjacent(min)) {
                if (!proc[v] && graph[min][v] < dist[v]){
                    parent[v] = min;
                    dist[v] = graph[min][v];
                }
            }
        }
        printMST(parent, srcs);
    }
    
    public void printMST(int[] parent, int srcs) {
        for (int v = 0; v < numV; v++) {
            if (v == srcs)
                continue;
            System.out.print(parent[v] + " - " + v + "\t" + graph[v][parent[v]] + "\n");
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Weighted Adjacency List\n");
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
