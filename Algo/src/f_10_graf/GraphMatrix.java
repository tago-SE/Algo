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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */

public class GraphMatrix {
    
    /**
     * 
     * @param graph output 2D array for the graph containing weights
     * @param fileName the file to be read
     * @return the number of vertices
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static int[][] create(String fileName) throws FileNotFoundException, IOException  {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        ArrayList<Edge> edges = new ArrayList<>();
        String line = br.readLine();
        int numV = -1;
        int[][] graph = null;
        try {
            while (line != null) {
                int srcs = line.charAt(0) - 'A';
                int dest = line.charAt(2) - 'A';
                int weight = line.charAt(4) - '0';
                if (srcs > numV)
                    numV = srcs;
                edges.add(new Edge(srcs, dest, weight));
                line = br.readLine();
            }
            graph = new int[numV + 1][numV + 1];
            for (Edge e: edges) {
                graph[e.source][e.dest] = e.weight;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListGraph.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            br.close();
        }
        return graph;
    }
}
