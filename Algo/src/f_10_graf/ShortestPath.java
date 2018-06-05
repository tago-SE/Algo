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
    private static final int NO_PARENT = -1;
    
    public ShortestPath(int[][] graph, int numV) {
        this.graph = graph;
        this.numV = numV;
    }
    
    public void printSolution(int srcs, int dist[], int numV, int[] parent) {
        System.out.println("Vertex\t\tDistance\tPath");
        for (int v = 0; v < numV; v++) {
            if (v == srcs)
                continue;
            System.out.print((char) (v + 'A') + " -> " + (char) (srcs + 'A') + "\t\t" + dist[v] + "\t\t"); 
            for (Integer p : getPath(v, parent, new ArrayList<>())) {
                System.out.print((char) (p + 'A') + ", ");
            }
            System.out.println("");
        }
    }
    
     public List<Integer> getPath(int v, int[] parent, List<Integer> output) {
        if (v == NO_PARENT)
            return output;
        getPath(parent[v], parent, output);
        output.add(v);
        return output;
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
    
    public void djikstra(int srcs, int[] dist, int[] parent) {
        boolean[] proc = new boolean[numV];
        for (int u = 0; u < numV; u++) {
            dist[u] = Integer.MAX_VALUE;    
            proc[u] = false;
        }
        dist[srcs] = 0;                 
        parent[srcs] = NO_PARENT;
        
        for (int u = 0; u < numV - 1; u++) { 
            int min = minDistance(dist, proc);
            proc[min] = true;
            for (Integer v : getAdjacent(min)) {
                 if (dist[v] > dist[min] + graph[min][v]) {
                    parent[v] = min;
                    dist[v] = dist[min] + graph[min][v];
                }
            }
        }
        printSolution(srcs, dist, numV, parent);
    }
    
    public int shortestPath(int srcs, int dest) {
        int dist[] = new int[numV];
        int parent[] = new int[numV];
        djikstra(srcs, dist, parent);
        /*
        System.out.println("----");
        System.out.println("Shortest distance from " + srcs + " to " + dest + " is " + dist[dest]);
        for (Integer v : getPath(dest, parent, new ArrayList<>())) {
            System.out.print(v + ", ");
        }
        System.out.println("\n----");
        */
        return dist[dest];   
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
