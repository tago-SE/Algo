package f_06_back_tracking;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tiago
 */
public class RobotSort {
    
    private static final int MAX_STEPS = 15;
 
    private static boolean isSorted(char[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] > c[i + 1])
                return false;
        }
        return true;
    }
    
    private static char[] switchFirstWithSecond(char[] c) {
        char tmp = c[0];
        c[0] = c[1];
        c[1] = tmp;
        return c;
    }
    
    private static char[] moveLastToFirst(char[] c) {
        char tmp = c[c.length - 1];
        for (int i = c.length -1; i > 0; i--) {
            c[i] = c[i - 1];
        }
        c[0] = tmp;
        return c;
    }
    
    private static char[] moveFirstToLast(char[] c) {
        char tmp = c[0];
        int i;
        for (i = 0; i < c.length - 1; i++) {
            c[i] = c[i + 1];
        }
        c[i] = tmp;
        return c;
    }
    
    private static class State {
        char[] c;
        int steps;
        private State(char[] c, int steps) {
            this.steps = steps;
            this.c = new char[c.length];
            System.arraycopy(c, 0, this.c, 0, c.length);
        }
    }
    
    private static int sort_BF(char[] c, int steps) {
        Queue<State> q = new LinkedList();
        q.offer(new State(c, 0));
        State s;
        while (q.size() > 0) {
            s = q.poll();
            if (isSorted(s.c))
                return s.steps;
            if (s.steps >= MAX_STEPS)
                break;
            q.offer(new State(switchFirstWithSecond(s.c), s.steps + 1));
            q.offer(new State(moveLastToFirst(s.c), s.steps + 1));
        }
        return -1;
    }
    
    private static int sort_DF(char[] c, int steps) {
        if (isSorted(c)) 
            return steps;
        if (steps >= MAX_STEPS)
            return Integer.MAX_VALUE;
        
        switchFirstWithSecond(c);
        int b = sort_DF(c, steps + 1);
        switchFirstWithSecond(c);       // reset
        moveLastToFirst(c);
        int a = sort_DF(c, steps + 1);
        moveFirstToLast(c);             // reset
        return Math.min(a, b);
    }
    
    public static void test(String s) {
        s += " change";
        
    }
    
    public static String sort(String str) {
        System.out.println("DF = " + sort_DF("BECAD".toCharArray(), 0));
        System.out.println("BF = " + sort_BF("BECAD".toCharArray(), 0));
        return "";
    }

}
