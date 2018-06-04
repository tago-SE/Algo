/*
    NOT WORKING
 */
package f_06_back_tracking;

/**
 *
 * @author tiago
 */
public class Puzzle {
    private static final int maxx = 5;
    private static final int maxy = 5;
    private static int[][] board = new int[maxx][maxy];
    
    
    private static boolean outsideBounds(int x, int y) {
        return x < 0 || x >= maxx - 1 || y < 0 || y >= maxy - 1;
    }
    
    private static boolean canPlace1(int[][] b, int x, int y) {
        if (outsideBounds(x, y)) return false;
        System.out.println("here");
        return b[x + 1][y] == 0 && b[x][y + 1] == 0 && b[x + 1][y + 1] == 0;
    }
    
    private static void set1(int b[][], int x, int y, int value) {
        b[x + 1][y] = b[x][y + 1] = b[x + 1][y + 1] = value;
    }
    
    private static boolean canPlace2(int[][] b, int x, int y) {
        if (outsideBounds(x, y)) return false;
        return b[x][y] == 0 && b[x][y + 1] == 0 && b[x + 1][y + 1] == 0;
    }
    
    private static void set2(int b[][], int x, int y, int value) {
        b[x][y] = b[x][y + 1] = b[x + 1][y + 1] = value;
    }
    
    private static boolean canPlace3(int[][] b, int x, int y) {
        if (outsideBounds(x, y)) return false;
        return b[x][y] == 0 && b[x + 1][y] == 0 && b[x + 1][y + 1] == 0;
    }
    
   private static void set3(int b[][], int x, int y, int value) {
        b[x][y] = b[x + 1][y] = b[x + 1][y + 1] = value;
    }
   
    private static boolean canPlace4(int[][] b, int x, int y) {
        if (outsideBounds(x, y)) return false;
        return b[x][y] == 0 && b[x + 1][y] == 0 && b[x][y + 1] == 0;
    }
    
   private static void set4(int b[][], int x, int y, int value) {
        b[x][y] = b[x + 1][y] = b[x][y + 1] = value;
    }
    
    public static void printBoard() {
        for (int y = 0; y < maxy; y++) {
            for (int x = 0; x < maxx; x++) {
                System.out.print(" " + board[x][y] + " ");
            }
            System.out.println("");
        }
    }
    
    private static boolean isSolved(int[][] b) {
        for (int y = 0; y < maxy; y++) {
            for (int x = 0; x < maxx; x++) {
                if (b[x][y] == 0)
                    return false;
            }
        }
        return true;
    }
    
    
    public static boolean solveOne(int x, int y) {
        if (isSolved(board)) {
            printBoard();
            return true;
        }
        for ( ; y < maxy; y++) {
            for ( ; x < maxx; x++) {
                if (canPlace1(board, x, y)) {
                    set1(board, x, y, 1);
                    if (solveOne(x + 1, y)) {
                        return true;
                    }
                    set1(board, x, y, 0);
                }
                if (canPlace2(board, x, y)) {
                    set2(board, x, y, 1);
                    if (solveOne(x + 1, y)) {
                        return true;
                    }
                    set2(board, x, y, 0);
                }
                if (canPlace3(board, x, y)) {
                    set3(board, x, y, 1);
                    if (solveOne(x + 1, y)) {
                        return true;
                    }
                    set3(board, x, y, 0);
                }
                if (canPlace4(board, x, y)) {
                    set4(board, x, y, 1);
                    if (solveOne(x + 1, y)) {
                        return true;
                    }
                    set4(board, x, y, 0);
                }
            }
        }

        return false;
    }
    
    public static int solve(int x, int y, int count) {
        if (isSolved(board)) {
            System.out.println("found a solution");
            return 1;
        }
        
        if (x >= maxx) {
            x = x % maxx;
            y++;
        }
        if (y >= maxy) 
            return 0;

 
        
        if (canPlace1(board, x, y)) {
            set1(board, x, y, 1);
            printBoard();
            count += solve(x + 1, y, count);
            set1(board, x, y, 0);
        }
        if (canPlace2(board, x, y)) {
            set2(board, x, y, 1);
            count += solve(x + 1, y, count);
            set2(board, x, y, 0);
        }
        if (canPlace3(board, x, y)) {
            set3(board, x, y, 1);
            count += solve(x + 1, y, count);
            set3(board, x, y, 0);
        }
        if (canPlace4(board, x, y)) {
            set4(board, x, y, 1);
            count += solve(x + 1, y, count);
            set4(board, x, y, 0);
        }
        return count;
    }
    
    public static int solve(int y, int x) {
        if (x < 1 || x > maxx || y < 1 || y > maxy)
            throw new IllegalArgumentException();
        
        board[x - 1][y - 1] = 1;
        
        if (solveOne(x, y)) {
            System.out.println("solved");
        } else  System.out.println("not solved");
        //System.out.println("ret: " + ret);
        System.out.println("done?");
        return 0;
    }
    
}
