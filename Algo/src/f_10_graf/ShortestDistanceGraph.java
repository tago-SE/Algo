package f_10_graf;

import f_04_queue.QueueLinked;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author tiago
 */
public class ShortestDistanceGraph {
    
    int numVertecies;
    int[][] adjacencyMatrix;
    
    public ShortestDistanceGraph(int[][] adjMatrix) {
        if ( adjMatrix.length != adjMatrix[0].length)
            throw new IllegalArgumentException("must be a square matrix");
        adjacencyMatrix = adjMatrix;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < adjacencyMatrix.length; y++) {
            sb.append("\n[").append(y).append("] is connected to...");
            for (int x = 0; x < adjacencyMatrix[0].length; x++) {
                if (adjacencyMatrix[y][x] != Integer.MAX_VALUE) 
                    sb.append("[").append(x).append("] ").append(adjacencyMatrix[y][x]).append("...");
            }    
        }
        return sb.toString();
    }
    
    private Object[] getAdjacentNodes(int y) {
        List<Integer> l = new ArrayList();
        for (int x = 0, o = 0; x < adjacencyMatrix[0].length; x++) {
            if (adjacencyMatrix[y][x] != Integer.MAX_VALUE)
                l.add(x);
        }
        return l.toArray();
    }
    
    /*
    
    private boolean solve(Position p) {
        // Sets the cell as visited
        mazeMatrix[p.row][p.column] = Cell.VISITED;
        
        // Base case - solved
        if (p.equals(goal)) {
            mazeMatrix[p.row][p.column] = Cell.CORRECT;
            return true;
        }
        
        else {
            
            if (mazeMatrix[p.row + 1][p.column] == Cell.OPEN) {
                if (solve(new Position(p.row + 1, p.column))) {
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    return true;
                }
            }
            if (mazeMatrix[p.row - 1][p.column] == Cell.OPEN) {
                if (solve(new Position(p.row - 1, p.column))) {
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    return true;
                }
            }
            if (mazeMatrix[p.row][p.column + 1] == Cell.OPEN) {
                if (solve(new Position(p.row, p.column + 1))) {
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    return true;
                }
            }
            if (mazeMatrix[p.row][p.column - 1] == Cell.OPEN) {
                if (solve(new Position(p.row, p.column - 1))) {
                    mazeMatrix[p.row][p.column] = Cell.CORRECT;
                    return true;
                }
            }
            return false;
        }
    }

    */
    
    /*
    rivate static State sort_BreadthFirst(String str) {
        Queue<State> queue = new LinkedList<>();
        State state = new State(str, 0, "");
        while (!isSorted(0, state.str)) {
            queue.offer(new State(switchFirstWithSecond(state.str), state.counter + 1, state.order + "b"));
            queue.offer(new State(moveLastToFirst(state.str), state.counter + 1, state.order + "s"));
            state = queue.poll();
        }
        return state;
    }
    */
    
    
    private int[][] findShortestPath_DF_Search(int startNode, int endNode) {
       // boolean[] visited = new Boolean[adjacencyMatrix]
        QueueLinked<Integer> nodes = new QueueLinked();
        int curNode = startNode;
        while (curNode != endNode) {
            Object[] a = getAdjacentNodes(curNode);
            for (Object o: a) {
                nodes.offer(o);
            }     
            curNode = (int) nodes.poll();
        }
        
        
        return null;
    }
    
    public static void test() {
        int X = Integer.MAX_VALUE;
        int[][] w = { {X, 2, X, X, X, 1, X, X},
        {2, X, 2, 2, 4, X, X, X},
        {X, 2, X, X, 3, X, X, 1},
        {X, 2, X, X, 3, 1, X, X},
        {X, 4, 3, 3, X, X, 7, X},
        {1, X, X, 1, X, X, 5, X},
        {X, X, X, X, 7, 5, X, 6},
        {X, X, 1, X, X, X, 6, X}};   
        ShortestDistanceGraph g = new ShortestDistanceGraph(w);
        System.out.println(g.toString());
        
        Object[] a = g.getAdjacentNodes(2);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
