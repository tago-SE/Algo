
package f_10_graf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiago
 */
public class ListGraph {
    
    private int numV;
    private LinkedList<Edge> adjacencyList[];
    private boolean directed;
  
    
    public ListGraph(int numV, boolean directed) {
        this.numV = numV;
        adjacencyList = new LinkedList[numV];
        this.directed = directed;
        for (int i = 0; i < numV; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public void insertEdge(int srcs, int dest, int weight) {
        Edge edge = new Edge(srcs, dest, weight);
        adjacencyList[srcs].addFirst(edge);
    }
    
    public boolean isConnected(int srcs, int dest) {
        for (Edge e : adjacencyList[srcs]) {
            if (e.getDest() == dest) 
                return true;
        }
        if (!directed) {
            for (Edge e : adjacencyList[dest]) {
                if (e.getDest() == srcs) 
                    return true;
            }
        }
        return false;
    }
    
    public static ListGraph createGraph(String fileName) throws FileNotFoundException, IOException {
        ListGraph g = null;
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
            g = new ListGraph(maxSrcs + 1, true);
            for (Edge e : edges) {
                g.insertEdge(e.getSource(), e.getDest(), e.getWeight());
            }
            //System.out.println("FOUND: " + sb.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListGraph.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            br.close();
        }
        return g;
    } 
    
    private static class Path {
        String path;
        int weight;
        public Path(String path, int weight) {
            this.path = path;
            this.weight = weight;
        }
    }
    
    public void findPathBreadthFirst(int srcs, int dest) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> weightQ = new LinkedList<>();
        Queue<String> stepsQ = new LinkedList<>();
        boolean[] identified = new boolean[numV];
        identified[srcs] = true;
        q.offer(srcs);
        weightQ.offer(0);
        stepsQ.offer("");
        while (!q.isEmpty()) {
            int pos = q.poll();
            int weight = weightQ.poll();
            String steps = stepsQ.poll();
            if (pos == dest) {
                System.out.println("PATH FOUND: " + steps + "" + weight);
                return;
            }
            for (Edge e : adjacencyList[pos]) {
                int neighbor = e.getDest();
                if (!identified[neighbor]) {
                    identified[neighbor] = true;
                    q.offer(neighbor);
                    weightQ.offer(weight + e.getWeight());
                    stepsQ.offer(steps + (char)(e.getSource() + 'A') + ",");
                }
            }
        }
    }
    
    private int findPathDepthFirst(
            int srcs, 
            int dest, 
            int sumWeight, 
            boolean[] visited, 
            String steps, 
            ArrayList<Integer> solutionWeights, 
            ArrayList<String> solutionSteps) 
    {
        if (srcs == dest) {
            solutionWeights.add(sumWeight);
            solutionSteps.add(steps);
            return sumWeight;   // Base case
        }
        for (Edge e : adjacencyList[srcs]) {
            int neighbor = e.getDest();
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                String s = steps + (char)(neighbor + 'A') + ",";
                int sum = findPathDepthFirst(neighbor, dest, sumWeight + e.getWeight(), visited, s, solutionWeights, solutionSteps);
                visited[neighbor] = false;
            }
        }
        return Integer.MAX_VALUE; // Fail case
    }
    
    public int findShortestPathDepthFirst(int srcs, int dest) {
        boolean[] visited = new boolean[numV];
        visited[srcs] = true;
        ArrayList<Integer> solutionWeight = new ArrayList<>();
        ArrayList<String> solutionSteps = new ArrayList<>();
        int weight = findPathDepthFirst(srcs, dest, 0, visited, "" + (char) (srcs + 'A') + ",", solutionWeight, solutionSteps);
        int minWeight = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < solutionWeight.size(); i++) {
            if (solutionWeight.get(i) < minWeight) {
                minWeight = solutionWeight.get(i);
                index = i;
            }
        }
        System.out.println("Shortest Path: " + solutionWeight.get(index) + " - " + solutionSteps.get(index));
        return minWeight;
    }
    
    private int findShortestPath(int srcs, int dest, int sumWeight, boolean[] identified, String steps) {
     
        return 0;
    }
   
    public void findClosestPath(int srcs, int dest) {
        for (int i = 0; i < numV; i++) {
            
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListGraph:\n");
        for (int i = 0; i < numV; i++) {
            char c = (char) (i + 'A');
            sb.append("[").append(c).append("]{");
            for (Edge e : adjacencyList[i]) {
                c = (char) (e.getDest() + 'A');
                sb.append("(").append(c).append(":").append(e.getWeight()).append(")");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }
}
