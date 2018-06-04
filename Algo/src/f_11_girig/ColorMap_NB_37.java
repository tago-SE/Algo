/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_11_girig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class ColorMap_NB_37 {
    
    static private int numV;
    static private List<Edge> adjacent[];
    static private int[] countryColor;
 
    private static class Edge {
        int srcs;
        int dest;
        
        public Edge(int srcs, int dest) {
            this.srcs = srcs; this.dest = dest;
        }
    }
    
    private static boolean isUsed(int srcs, int color) {
        for (Edge e : adjacent[srcs]) {
            if (countryColor[e.dest] == color)
                return true;
        }
        return false;
    }
            
    public static void solve(String fileName) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line = br.readLine();
            ArrayList<Edge> edges = new ArrayList<>(); 
            int maxSrcs = -1;
            while (line != null) {
                int srcs = line.charAt(0) - '0';
                int dest = line.charAt(2) - '0';
                if (srcs > maxSrcs)
                    maxSrcs = srcs;
                if (dest > maxSrcs)
                    maxSrcs = dest;
                edges.add(new Edge(srcs, dest));
                line = br.readLine();
            }
            numV = maxSrcs + 1;
            adjacent = new ArrayList[numV];
            countryColor = new int[numV];
            for (int i = 0; i < numV; i++) {
                adjacent[i] = new ArrayList<>();
            }
            for (Edge e : edges) {
                adjacent[e.srcs].add(e);
                adjacent[e.dest].add(new Edge(e.dest, e.srcs));
            }
            for (int srcs = 0; srcs < numV; srcs++) {
                 int color = 0;
                do {
                    color++;
                } while (isUsed(srcs, color));
                countryColor[srcs] = color;
                System.out.println(srcs + " color used: " + color);
            }
            
            // Print result:
            StringBuilder sb = new StringBuilder("Map:\n");
            for (int i = 0; i < numV; i++) {
                char c = (char) (i + '0');
                sb.append("[").append(c).append("(" + countryColor[i] + ")]{");
                for (Edge e : adjacent[i]) {
                    c = (char) (e.dest + '0');
                    sb.append("").append(c).append(",");
                }
                sb.append("}\n");
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(ColorMap_NB_37.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            br.close();
        }
    }  
}
