/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package L2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author tiago
 */
public class RobotSort {
    
    
    private static String switchFirstWithSecond(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(1));
        sb.append(str.charAt(0));
        sb.append(str.substring(2));
        return sb.toString();
    }
    
    private static String moveLastToFirst(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(str.length() - 1));
        sb.append(str.substring(0, str.length() - 1));
        return sb.toString();
    }
    
    /*
    private static boolean isSorted(int index, String str) {
        if (index == str.length()) {
            return true;
        }
        if (index > 0) {
            if (str.charAt(index) < str.charAt(index - 1)) {
                return false;
            }
        } 
        return isSorted(index + 1, str);
    }
    */
    private static class State {
        String str;
        String order;
        int counter; 
        
        private State(String str, int counter, String order) {
            this.str = str;
            this.counter = counter;
            this.order = order;
        }
        
        @Override
        public String toString() {
            return this.str + " | " + this.counter + " | " + this.order;
        }
    }
    

    /** Depth-first  (old version)
     * 
     * @param str
     * @param counter
     * @param order
     * @return 
     */
    
    /*
    private static State sort_Deepth(State state, int max) {
        if (isSorted(0, state.str)) {
            //System.out.println("sorted: " + state.str + " | " + state.counter);
            return state;
        }
        else {
            if (state.counter > max) {
                return null;
            }
            State s1, s2;
            s1 = sort_Deepth(new State(switchFirstWithSecond(state.str), state.counter + 1, state.order + "b"), max);
            s2 = sort_Deepth(new State(moveLastToFirst(state.str), state.counter + 1, state.order + "s"), max);
            
            if (s1 != null && s2 != null) {
               if (s1.counter < s2.counter) {
                   return s1;
               } else {
                   return s2;
               }
            }
            if (s1 != null) {
                return s1;
            }
            if (s2 != null) {
                return s2;
            }
        }
        return null;
    }
    */
    /*
    private static State sort_Deepth(State state, int max) {

        if (isSorted(0, state.str)) {
            return state;
        }
        else {
            if (state.counter > max) {
                return new State(state.str + "_failed", Integer.MAX_VALUE, ""); 
            }
            State s1 = sort_Deepth(new State(switchFirstWithSecond(state.str), state.counter + 1, state.order + "b"), max);
            State s2 = sort_Deepth(new State(moveLastToFirst(state.str), state.counter + 1, state.order + "s"), max);
            if (Math.min(s1.counter, s2.counter) == s1.counter) {
                return s1;
            }
            return s2;
        }   
    }
    
    private static int solve(String str, String order, int max, boolean show) {
        if (isSorted(0, str)) {
            if (show) {
                System.out.println("Solved: " + str + " || " + order);
            }
            return order.length();
        } else {
           if (order.length() >= max) {
               return Integer.MAX_VALUE;
           }
           return Math.min(solve(moveLastToFirst(str), order + "s", max, show), solve(switchFirstWithSecond(str), order + "b", max, show));
        }
    }

    private static State sort_BreadthFirst(String str) {
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
    /*
    public static String sort(String str) {
        
       // return sort_BreadthFirst(str).toString();
        
         
         int x = solve(str, "", 15, false); 
         System.out.println("max = " + x);
         if (x != Integer.MAX_VALUE) {
            solve(str, "", x, true);
         } else {
             System.out.println("Wasn't solved");
         }
         return "";
         
        //State result = sort_Deepth(new State(str, 0, ""), 15);  // 126447
        //return result.toString();

    }*/
    
    private static boolean isSorted(char[] c, int i) {
        if (i >= c.length - 1)
            return true;
        if (c[i] > c[i + 1])
            return false;
        return isSorted(c, i + 1);
    }
    
    private static char[] switchFirstWithSecond(char[] c) {
        char tmp = c[0];
        c[0] = c[1];
        c[1] = tmp;
        return c;
    }
    
    private static char[] moveLastToFirst(char[] c) {
        char tmp = c[0];
        c[0] = c[c.length - 1];
        c[c.length - 1] = tmp;
        return c;
    }

    private static int sort(char[] c, int steps) {
        if (isSorted(c, 0))
            return steps;
        if (steps > 15)
            return Integer.MAX_VALUE;
        return Math.min(sort(moveLastToFirst(c), steps + 1), sort(switchFirstWithSecond(c), steps + 1));
    }
    
    public static String sort(String str) {
        int max = str.length();
        char[] c = new char[max];
        for (int i = 0; i < max; i++) {
            c[i] = str.charAt(i);
        }
        int steps = sort(c, 0);
        System.out.println("steps " + steps);
        return Arrays.toString(c);
    }
}

