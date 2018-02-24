
package f_06_back_tracking;

import java.util.LinkedList;

/**
 *
 * @author tiago
 */
public class Elevator {
    
    private static int MAX_TRAVEL = 30;
    
   private  static int numTimesTraveled_DF(int levels, int up, int down, int pos, int des, int numTraveled) {
        if (pos == des) 
            return numTraveled;
        if (numTraveled > MAX_TRAVEL)
            return Integer.MAX_VALUE;
        
        int u = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if (pos + up <= levels) 
            u = numTimesTraveled_DF(levels, up, down, pos + up, des, numTraveled + 1);
        if (pos - down >= 1) 
            d = numTimesTraveled_DF(levels, up, down, pos - down, des, numTraveled + 1);
        return Math.min(u, d);
    }
   
    private static class State {
        int pos, traveled;
        
        private State(int pos, int traveled) {
            this.pos = pos;
            this.traveled = traveled;
        }
    }
   
    private static int numTimesTraveled_BF(int levels, int up, int down, int dest) {
       LinkedList<State> q = new LinkedList();
       State cur = new State(1, 0);
       while(cur.pos != dest) {
           int p = cur.pos;
           int t = cur.traveled;
           if (p + up <= levels) 
               q.offer(new State(p + up, t + 1));
           if (p - down >= 1)
               q.offer(new State(p - down, t + 1));
           cur = q.poll();
       }
       return cur.traveled;
   }
    
    public static int numTimesTraveled(int levels, int up, int down, int dest) {
        //return numTimesTraveled_DF(levels, up, down, 1, dest, 0);
        return numTimesTraveled_BF(levels, up, down, dest);
    }

}
