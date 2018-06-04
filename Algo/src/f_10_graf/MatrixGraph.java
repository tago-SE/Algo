/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_10_graf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class MatrixGraph extends AbstractGraph {

    private boolean[][] adjacent; 
    private int[][] weight;
    
    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        adjacent = new boolean[numV][numV];
        weight = new int[numV][numV];
    }
    
    public void addEdge(int srcs, int dest, int weight) {
         this.adjacent[srcs][dest] = true;
         this.weight[srcs][dest] = weight;
    }
    
    public void removeEdge(int srcs, int dest) {
        this.adjacent[srcs][dest] = false;
    }
    
    public List<Integer> getEdges(int srcs) {
        List<Integer> edges = new ArrayList<>();
        for (int dest = 0; dest < numV; dest++) {
            if (adjacent[srcs][dest]) {
                edges.add(dest);
            }
        }
        return edges;
    }
    
    public int getEdgeWeight(int srcs, int dest) {
        return weight[srcs][dest];
    }
    
    
    /**
     * 
     * @param start     the start vertex
     * @param pred      Output-array containing predecessors
     * @param dist      Output-array containing the distance in the shortest path
     */
    public void dijkstra(int start, int[] pred, int[] dist) {
        HashSet<Integer> vMinusS = new HashSet<>();
        // Initialize V-S   Add all vertecies except the starting one
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        for (int v : vMinusS) { // Initialize pred and dist
            pred[v] = start;
            dist[v] = getEdgeWeight(start, v);
        }
        // Main Loop
        while (vMinusS.size() != 0) {
            // Find the value u in V-S with the smallest dist[u]
            int minDist = Integer.MAX_VALUE;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            vMinusS.remove(u);  // Remove u from vMinusS
            // Update the distance
            for (int v : vMinusS) {
                if (adjacent[u][v]) {
                    int weight = getEdgeWeight(u, v);
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }
    
    public int findShortestPathFromNodeToOthers(int srcs) {
        int[] pred = new int[numV];
        int[] dist = new int[numV];
        dijkstra(srcs, pred, dist);
        System.out.println("here");
        for (int i = 0; i < numV; i++) {
            if (i != srcs) {
                System.out.println("" + pred[i] + " " + dist[i]);
            }
        }
        System.out.println("done");
        return 0;
    }

   public static MatrixGraph createGraph(String fileName) throws FileNotFoundException, IOException {
        MatrixGraph g = null;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line = br.readLine();
            int lineCount = 0;
            
            ArrayList<Edge> edges = new ArrayList<>();
            int numV; 
            int maxSrcs = -1;
            while (line != null) {
                int srcs = line.charAt(0) - 'A';
                int dest = line.charAt(2) - 'A';
                int weight = line.charAt(4) - '0';
                if (srcs > maxSrcs)
                    maxSrcs = srcs;
                edges.add(new Edge(srcs, dest, weight));
                line = br.readLine();
            }
            g = new MatrixGraph(maxSrcs + 1, true);
            for (Edge e : edges) {
                g.addEdge(e.getSource(), e.getDest(), e.getWeight());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListGraph.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            br.close();
        }
        return g;
    } 
   
   
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MatrixGraph:\n");
        for (int srcs = 0; srcs < numV; srcs++) {
            char c = (char) (srcs + 'A');
            sb.append("[").append(c).append("]{");
            for (Integer dest : getEdges(srcs)) {
                c = (char) (dest + 'A');
                sb.append("(").append(c).append(":").append(getEdgeWeight(srcs, dest)).append(")");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }
}
