package f_06_back_tracking;

import java.util.Arrays;

/**
 *
 * @author tiago
 */
public class RobotSort {
    
    private static final int MAX_STEPS = 11;
    
    /*
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
    
    public static char[] copy(char[] source) {
         char[] c = new char[source.length];
         for (int i = 0; i < source.length; i++) {
             c[i] = source[i];
         }
         return c;
    }
    
    public static int sort_DF(char[] c1, int steps) {
        if (isSorted(c1, 0)) 
            return steps;
        if (steps >= MAX_STEPS)
            return Integer.MAX_VALUE;
        
        char[] c2 = copy(c1);
        /*
        switchFirstWithSecond(c1);
        System.out.println(Arrays.toString(c1));
        System.out.println(Arrays.toString(c2));
        return 0;
        
        return Math.min(sort_DF(switchFirstWithSecond(c1), steps + 1), sort_DF(moveLastToFirst(c2), steps + 1));
    }
    */
    private static boolean isSorted(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1))
                return false;
        }
        return true;
    }
    
    private static String moveLastToFirst(String str) {
        String s = "" + str.charAt(str.length() - 1);
        char tmp = str.charAt(0);
        for (int i = 1; i < str.length() - 1; i++) {
            s = s + str.charAt(i);
        }
        return s + tmp;
    }
    
    private static String switchFirstWithSecond(String str) {
        char tmp = str.charAt(0);
        String s = "" + str.charAt(1);
        s += tmp;
        for (int i = 2; i < str.length(); i++) {
            s = s + str.charAt(i);
        }
        return s;
    }
    
    private static int sort_DF(String str, int steps) {
        if (isSorted(str))
            return steps;
        if (steps >= MAX_STEPS)
            return Integer.MAX_VALUE;
        int a = sort_DF(moveLastToFirst(str), steps + 1);
        int b = sort_DF(switchFirstWithSecond(str), steps + 1);
        return Math.min(a, b);
    }
    
    public static String sort(String str) {
        /*
        int max = str.length();

        char[] c = new char[max];
        for (int i = 0; i < max; i++) {
            c[i] = str.charAt(i);
        }
        int steps = sort_DF(c, 0);
        return Arrays.toString(c) + " steps = " + steps;
*/
        String s1 = "AGGGGGB";
        String s2 = "ABGGGG";
        System.out.println(moveLastToFirst(s1));
        System.out.println(switchFirstWithSecond(s2));
        System.out.println(isSorted("ABC"));
        System.out.println(isSorted("EDF"));
        int steps = sort_DF("BEACAD", 0);
        System.out.println("steps = " + steps);
        return "";
    }

}
