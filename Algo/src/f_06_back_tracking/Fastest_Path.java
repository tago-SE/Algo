
package f_06_back_tracking;

/**
 *
 * @author tiago
 * 
 * INCOMPLETE!!!
 */
public class Fastest_Path {
    
    private static int[][] grid;
    
    private final static int VISTED = 1;
    private final static int UNVISTED = 0;
    private final static int MAX_STEPS = 10;
    
    public static String print(int[][] grid, int x_len, int y_len) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < y_len; y++) {
            for (int x = 0; x < x_len; x++) {
                sb.append(" ").append(grid[x][y]).append(" ");
            }
            sb.append("\n"); 
        }
        return sb.toString();
    }
    
    
    
    private static int solve(int[][] status, int sum, int steps, int x, int y, int xMax, int yMax) {
        if (y == yMax - 1) {
            return sum;
        }
        if (steps >= MAX_STEPS) // Max depth
            return Integer.MAX_VALUE;
        
        int[] a = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        if (x + 1 < xMax && status[x + 1][y] == UNVISTED) {
            status[x + 1][y] = VISTED;
            a[0] = solve(status, sum + grid[x + 1][y], steps + 1, x + 1, y, xMax, yMax);
            status[x + 1][y] = UNVISTED;
        }
        if (x - 1 >= 0 && status[x - 1][y] == UNVISTED) {
            status[x - 1][y] = VISTED;
            a[1] = solve(status, sum + grid[x - 1][y], steps + 1, x - 1, y, xMax, yMax);
            status[x - 1][y] = UNVISTED;
        }
        if (y + 1 < yMax && status[x][y + 1] == UNVISTED) {
            status[x][y + 1] = VISTED;
            a[2] = solve(status, sum + grid[x][y + 1], steps + 1, x, y + 1, xMax, yMax);
            status[x][y + 1] = UNVISTED;
        }
        if (y - 1 >= 0) {
            status[x][y - 1] = VISTED;
            a[3] = solve(status, sum + grid[x][y - 1], steps + 1, x, y - 1, xMax, yMax);
            status[x][y - 1] = UNVISTED;
        } 
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        return min;
    }
    
    private static int solve(int xMax, int yMax) {
        int[] start = new int[xMax];
        for (int x = 0; x < xMax; x++) {
            int[][] status = new int[xMax][yMax];
            start[x] = solve(status, grid[x][0], 0, x, 0, xMax, yMax); 
            System.out.println("start " + x + ": smallest " + start[x]);
        }
        return 0;
    }
    
    public static String solve() {

        int g[][] = { 
            {2, 7, 1, 7, 5, 9}, 
            {6, 4, 2, 8, 6, 7}, 
            {8, 5, 5,  9, 7, 9},
            {0, 7, 9, 8, 7, 6}, 
            {5, 8, 6, 8, 5, 8},
            {4, 1, 5, 6, 7, 8},
            {7, 2, 6, 8, 7, 8},
            {9, 7, 1, 1, 2, 1}, 
            {3, 8, 1, 7, 8, 8}, 
            {6, 4, 2, 1, 9, 6},
            {8, 5, 7, 2, 6, 8},
            {1, 2, 1, 1, 7, 9}, 
            {5, 8, 4, 5, 9, 8},
            {8, 9, 6, 6, 5, 6},
            {3, 6, 4, 7, 5, 8}
        };
        grid = g;
        int x = g.length;
        int y = g[0].length;
        solve(x, y);
        return "";
    }
}
