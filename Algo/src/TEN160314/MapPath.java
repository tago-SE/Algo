package TEN160314;

import java.util.LinkedList;

/**
 *
 * @author tiago
 */
public class MapPath {
    
    private static final int VISTED = 1;
    private static final int UNVISTED = 0;
    
    private static class Goal {
        int x, y;
        
        private Goal(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        private boolean reached(int x, int y) {
            return this.x == x && this.y == y;
        }
    }
    
    private static Goal g;
    private static int yyMax;
    
    private static int solveDF(int x, int y) {
        if (g.reached(x, y)) 
            return 1;
        int nr = 0;
        if (x - 1 >= 0) 
             nr = solveDF(x - 1, y);
        if (y + 1 < yyMax) 
            nr += solveDF(x, y + 1);      
        return nr;
    }
    
    private static class Node {
        int x, y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static int solveBF(int xMax, int yMax) {
        int counter = 0;
        LinkedList<Node> q = new LinkedList();
        Node n = new Node(xMax - 1, 0);
        while (n != null) {
            if (g.reached(n.x, n.y))
                counter++;
            if (n.x - 1 >= 0) 
                q.offer(new Node(n.x - 1, n.y));
            if (n.y + 1 < yMax)
                q.offer(new Node(n.x, n.y + 1));
            
            n = q.poll();
        }
        return counter;
    }
    
    public static void solve(int xMax, int yMax) {
        yyMax = yMax;
        g = new Goal(0, yMax - 1);
        /*
       
        int counter = 0;
        LinkedList<Node> q = new LinkedList();
        Node n = new Node(xMax - 1, 0);
        while (n != null) {
            if (g.reached(n.x, n.y))
                counter++;
            if (n.x - 1 >= 0) 
                q.offer(new Node(n.x - 1, n.y));
            if (n.y + 1 < yyMax)
                q.offer(new Node(n.x, n.y + 1));
            
            n = q.poll();
        }
        */
        //System.out.println("Found = " + counter);
        
        System.out.println("goal (" + g.x + "," + g.y + ")");
        int found = solveDF(xMax - 1, 0);
        System.out.println("found: " + found);
        
        System.out.println("BF: " + solveBF(xMax, yMax));

    }
    
}
